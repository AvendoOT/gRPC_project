package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.service.request.CreateSensorDataRequest;
import fer.rassus.lab1.client.service.response.CreateSensorDataResponse;

import java.util.Optional;

public interface ClientService {

    long register(CreateRegistrationRequest createRegistrationRequest);

    Optional<CreateRegistrationRequest> getNeighbour(String id);

    void saveSensorData(String id, CreateSensorDataRequest createSensorDataRequest);
}
