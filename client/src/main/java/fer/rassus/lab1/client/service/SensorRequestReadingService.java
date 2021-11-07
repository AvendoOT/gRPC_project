package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.SensorReadingResponse;
import fer.rassus.lab1.client.grpc.SensorClient;
import org.springframework.stereotype.Service;

@Service
public class SensorRequestReadingService {

    public SensorReadingResponse getSensorReading(String host, int port) throws InterruptedException {
        SensorClient client = new SensorClient(host, port);
        SensorReadingResponse response = client.requestSensorReading();
        client.stop();
        return response;
    }
}
