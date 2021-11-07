package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.service.ClientService;
import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.service.response.CreateRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ClientServiceImpl implements ClientService {

    private final ServerUrls serverUrls;
    private final RestTemplate restTemplate;

    @Autowired
    public ClientServiceImpl(ServerUrls serverUrls, RestTemplateBuilder builder) {
        this.serverUrls = serverUrls;
        final Collection<MediaType> mediaTypes = List.of(MediaType.APPLICATION_JSON);
        this.restTemplate = builder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.toString(mediaTypes))
                .build();
    }

    @Override
    public CreateRegistrationResponse register(CreateRegistrationRequest createRegistrationRequest) {
        final ResponseEntity<CreateRegistrationResponse> response = restTemplate
                .postForEntity(serverUrls.getRegisterUrl(), createRegistrationRequest,
                        CreateRegistrationResponse.class);
        return Objects.requireNonNull(response.getBody());
    }



}
