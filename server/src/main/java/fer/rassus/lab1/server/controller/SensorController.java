package fer.rassus.lab1.server.controller;
import fer.rassus.lab1.server.entity.Sensor;
import fer.rassus.lab1.server.entity.SensorReading;
import fer.rassus.lab1.server.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorService sensorService;

    @Value("${server.port}")
    private int SERVER_PORT;

    @Value("${server.host-name}")
    private String HOST_NAME;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public ResponseEntity<Void> registerSensor(@RequestBody Sensor sensor) {
        final Sensor savedSensor = sensorService.registerSensor(sensor);

        final URI sensorUrl = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host(HOST_NAME)
            .port(SERVER_PORT)
            .path("/sensor/" + savedSensor.getId())
            .build().toUri();

        return ResponseEntity.created(sensorUrl).build();
    }

    @GetMapping("/{id}/neighbour")
    public Sensor findNeighbour(@PathVariable Long id) {
        return sensorService.findNeighbour(id);
    }

    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable Long id) {
        return sensorService.getSensor(id);
    }

    @GetMapping("/{id}/readings")
    public List<SensorReading> getSensorReadings(@PathVariable Long id) {
        return sensorService.getSensorReadings(id);
    }

    @GetMapping("/sensorReading/{id}")
    public SensorReading getSensorReading(@PathVariable Long id) {
        return sensorService.getSensorReading(id);
    }

    @GetMapping("/all")
    public List<Sensor> getAll() {
        return sensorService.getAllSensors();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> saveSensorData(@RequestBody SensorReading sensorReading, @PathVariable Long id) {
        final SensorReading savedSensorReading = sensorService.saveSensorReading(sensorReading, id);

        final URI sensorReadingUrl = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host(HOST_NAME)
            .port(SERVER_PORT)
            .path("/sensor/sensorReading/" + savedSensorReading.getId())
            .build().toUri();

        return ResponseEntity.created(sensorReadingUrl).build();
    }

}
