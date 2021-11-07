package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.service.request.CreateSensorDataRequest;
import fer.rassus.lab1.client.service.response.CreateRegistrationResponse;
import fer.rassus.lab1.client.service.response.CreateSensorDataResponse;

public interface ClientService {

    CreateRegistrationResponse register(CreateRegistrationRequest createRegistrationRequest);

    String neighbour(String id);

    CreateSensorDataResponse saveSensorData(String id, CreateSensorDataRequest createSensorDataRequest);
}
