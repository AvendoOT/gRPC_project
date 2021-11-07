package fer.rassus.lab1.server.service.impl;

import fer.rassus.lab1.server.dto.CreateRegistrationRequest;
import fer.rassus.lab1.server.dto.CreateSensorDataRequest;
import fer.rassus.lab1.server.entity.Sensor;
import fer.rassus.lab1.server.entity.SensorReading;
import fer.rassus.lab1.server.exception.EntityNotFoundException;
import fer.rassus.lab1.server.repository.SensorReadingRepository;
import fer.rassus.lab1.server.repository.SensorRepository;
import fer.rassus.lab1.server.service.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {

    private final ModelMapper modelMapper = new ModelMapper();
    private final SensorRepository sensorRepository;
    private final SensorReadingRepository sensorReadingRepository;

    private static final int EARTH_RADIUS = 6371;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository, SensorReadingRepository sensorReadingRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @Override
    public Sensor registerSensor(CreateRegistrationRequest registrationRequest) {
        final Sensor sensor = modelMapper.map(registrationRequest, Sensor.class);
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor findNeighbour(Long id) {
        final Sensor requesterSensor = getSensor(id);

        return findNeighbour(requesterSensor).orElseThrow(
            () -> new EntityNotFoundException("Sensors other than sensor with id " + id));
    }

    private Optional<Sensor> findNeighbour(Sensor requesterSensor) {
        final List<Sensor> allSensors = sensorRepository.findAll();
        allSensors.remove(requesterSensor);

        if (allSensors.isEmpty()) {
            return Optional.empty();
        }

        double minDistance = Double.MAX_VALUE;
        Sensor minDistanceSensor = null;

        for (Sensor sensor : allSensors) {
            double sensorDistance = distance(requesterSensor, sensor);

            if (sensorDistance < minDistance) {
                minDistance = sensorDistance;
                minDistanceSensor = sensor;
            }
        }

        return Optional.of(minDistanceSensor);
    }

    private double distance(Sensor sensor1, Sensor sensor2) {
        double lat1 = sensor1.getLatitude();
        double lat2 = sensor2.getLatitude();
        double lon1 = sensor1.getLongitude();
        double lon2 = sensor2.getLatitude();

        double dLon = lon2 - lon1;
        double dLat = lat2 - lat1;

        double a = Math.pow(Math.sin(dLat / 2), 2) +
            Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);

        return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)) * EARTH_RADIUS;
    }

    @Override
    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sensor with id " + id));
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public SensorReading saveSensorReading(CreateSensorDataRequest sensorData, Long sensorId) {
        final Sensor sensor = getSensor(sensorId);
        final SensorReading sensorReading = modelMapper.map(sensorData, SensorReading.class);
        sensorReading.setSensor(sensor);

        return sensorReadingRepository.save(sensorReading);
    }

    @Override
    public List<SensorReading> getSensorReadings(Long sensorId) {
        final Sensor sensor = getSensor(sensorId);
        return sensor.getSensorReadingList();
    }

    @Override
    public SensorReading getSensorReading(Long id) {
        return sensorReadingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sensor reading with id " + id));
    }

}
