package fer.rassus.lab1.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_id_generator")
    @SequenceGenerator(name = "sensor_id_generator", sequenceName = "sensor_reading_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private Integer port;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    private List<SensorReading> sensorReadingList;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<SensorReading> getSensorReadingList() {
        return sensorReadingList;
    }

    @JsonIgnore
    public void setSensorReadingList(List<SensorReading> sensorReadingList) {
        this.sensorReadingList = sensorReadingList;
    }

}
