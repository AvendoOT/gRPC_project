package fer.rassus.lab1.server.service;

import fer.rassus.lab1.server.entity.Sensor;
import fer.rassus.lab1.server.entity.SensorReading;

import java.util.List;

public interface SensorService {

    Sensor registerSensor(Sensor sensor);

    Sensor findNeighbour(Long id);

    Sensor getSensor(Long id);

    List<Sensor> getAllSensors();

    SensorReading saveSensorReading(SensorReading sensorReading, Long sensorId);

    List<SensorReading> getSensorReadings(Long sensorId);

    SensorReading getSensorReading(Long id);
}
