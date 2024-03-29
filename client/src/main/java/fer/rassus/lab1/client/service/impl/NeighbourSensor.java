package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NeighbourSensor {

    private String host;
    private int port;
    private boolean isConfigured = false;
    private boolean neighbourFindSuccess = false;

    public void updateInformation(Optional<CreateRegistrationRequest> createRegistrationRequest) {
        setConfigured(true);
        if (createRegistrationRequest.isEmpty()) {
            return;
        }
        setHost(createRegistrationRequest.get().getIp());
        setPort(createRegistrationRequest.get().getPort());
        setNeighbourFindSuccess(true);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isConfigured() {
        return isConfigured;
    }

    public void setConfigured(boolean configured) {
        isConfigured = configured;
    }

    public boolean isNeighbourFindSuccess() {
        return neighbourFindSuccess;
    }

    public void setNeighbourFindSuccess(boolean neighbourFindSuccess) {
        this.neighbourFindSuccess = neighbourFindSuccess;
    }
}
