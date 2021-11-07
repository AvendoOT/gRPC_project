package fer.rassus.lab1.server.service;

import fer.rassus.lab1.server.dto.CreateRegistrationRequest;
import fer.rassus.lab1.server.dto.CreateSensorDataRequest;
import fer.rassus.lab1.server.entity.Sensor;
import fer.rassus.lab1.server.entity.SensorReading;

import java.util.List;

public interface SensorService {

    Sensor registerSensor(CreateRegistrationRequest registrationRequest);

    Sensor findNeighbour(Long id);

    Sensor getSensor(Long id);

    List<Sensor> getAllSensors();

    SensorReading saveSensorReading(CreateSensorDataRequest sensorData, Long sensorId);

    List<SensorReading> getSensorReadings(Long sensorId);
}
