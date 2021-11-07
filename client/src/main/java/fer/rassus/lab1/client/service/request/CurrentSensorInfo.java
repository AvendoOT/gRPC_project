package fer.rassus.lab1.client.service.request;

import org.springframework.stereotype.Component;

@Component
public class CurrentSensorInfo {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
