package fer.rassus.lab1.server.controller;
import fer.rassus.lab1.server.dto.CreateRegistrationRequest;
import fer.rassus.lab1.server.dto.CreateSensorDataRequest;
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
    public ResponseEntity<Void> registerSensor(@RequestBody CreateRegistrationRequest registrationRequest) {
        final Sensor savedSensor = sensorService.registerSensor(registrationRequest);

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

    @GetMapping("/{id}/readings")
    public List<SensorReading> getSensorReadings(@PathVariable Long id) {
        return sensorService.getSensorReadings(id);
    }

    @GetMapping("/all")
    public List<Sensor> getAll() {
        return sensorService.getAllSensors();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> saveSensorData(@RequestBody CreateSensorDataRequest sensorData, @PathVariable Long id) {
        final SensorReading savedSensorReading = sensorService.saveSensorReading(sensorData, id);

        final URI sensorReadingUrl = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host(HOST_NAME)
            .port(SERVER_PORT)
            .path("/sensor/sensorReading/" + savedSensorReading.getId())
            .build().toUri();

        return ResponseEntity.created(sensorReadingUrl).build();
    }

}
