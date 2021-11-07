package fer.rassus.lab1.client.scheduled;

import fer.rassus.lab1.client.SensorReadingResponse;
import fer.rassus.lab1.client.service.ClientService;
import fer.rassus.lab1.client.service.SensorReadingFileService;
import fer.rassus.lab1.client.service.SensorRequestReadingService;
import fer.rassus.lab1.client.service.impl.NeighbourSensor;
import fer.rassus.lab1.client.service.request.CreateSensorDataRequest;
import fer.rassus.lab1.client.service.request.CurrentSensorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class GenerateReadingsScheduledService {
    private static final Logger logger = Logger.getLogger(GenerateReadingsScheduledService.class.getName());
    private final String EVERY_SECOND = "0 * * * * *";
    private final SensorRequestReadingService sensorRequestReadingService;
    private final NeighbourSensor neighbourSensor;
    private final CurrentSensorInfo currentSensorInfo;
    private final SensorReadingFileService sensorReadingFileService;
    private final ClientService sensorRestService;

    @Autowired
    public GenerateReadingsScheduledService(
            SensorRequestReadingService sensorRequestReadingService,
            NeighbourSensor neighbourSensor, CurrentSensorInfo currentSensorInfo, SensorReadingFileService sensorReadingFileService, ClientService sensorRestService) {
        this.sensorRequestReadingService = sensorRequestReadingService;
        this.neighbourSensor = neighbourSensor;
        this.currentSensorInfo = currentSensorInfo;
        this.sensorReadingFileService = sensorReadingFileService;
        this.sensorRestService = sensorRestService;
    }

    @Scheduled(cron= EVERY_SECOND)
    public void generateReading() {
        CreateSensorDataRequest dto = null;
        if (!neighbourSensor.isConfigured()) {
            return;
        }
        final SensorReadingResponse mySensorReading = sensorReadingFileService.getSensorReading();

        SensorReadingResponse response;
        if (neighbourSensor.isNeighbourFindSuccess()) {
            try {
                logger.info("Sending request");
                response = sensorRequestReadingService.getSensorReading(neighbourSensor.getHost(), neighbourSensor.getPort());
                dto = combineResults(response, mySensorReading);
                logger.info("Recieved data");
            } catch (Exception e) {
                logger.info("Error getting sensor reading");
            }
        } else {
            dto = map(mySensorReading);
        }
        logger.info("Sending data to server");
        sensorRestService.saveSensorData(String.valueOf(currentSensorInfo.getId()), dto);
    }

    private static CreateSensorDataRequest combineResults(SensorReadingResponse response, SensorReadingResponse mySensorReading) {
        final Double temperature = (double) (response.getTemperature() + mySensorReading.getTemperature()) / 2;
        final Double pressure = (double) (response.getPressure() + mySensorReading.getPressure()) / 2;
        final Double humidity = (double) (response.getHumidity() + mySensorReading.getHumidity()) / 2;

        final Double co = getValue(response.getCo(), mySensorReading.getCo());
        final Double no2 = getValue(response.getNo2(), mySensorReading.getNo2());
        final Double so2 = getValue(response.getSo2(), mySensorReading.getSo2());

        return new CreateSensorDataRequest(temperature, pressure, humidity, co, no2, so2);
    }

    private static Double getValue(float responseValue, float myValue) {
        if (Float.compare(responseValue, 0) == 0 && Float.compare(myValue, 0) == 0) {
            return null;
        }

        if (Float.compare(responseValue, 0) == 0) {
            return (double) myValue;
        }

        return (double) (responseValue + myValue) / 2;
    }

    private static CreateSensorDataRequest map(SensorReadingResponse response) {
        return new CreateSensorDataRequest((double) response.getTemperature(),
                (double) response.getPressure(), (double) response.getHumidity(), (double) response.getCo(),
                (double) response.getNo2(), (double) response.getSo2());
    }

}
