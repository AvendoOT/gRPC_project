package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.service.response.CreateRegistrationResponse;

public interface ClientService {

    CreateRegistrationResponse register(CreateRegistrationRequest createRegistrationRequest);
}
