package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.service.ClientService;
import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.service.request.CreateSensorDataRequest;
import fer.rassus.lab1.client.service.request.CurrentSensorInfo;
import fer.rassus.lab1.client.service.response.CreateRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService {

    private final ServerUrls serverUrls;
    private final RestTemplate restTemplate;


    @Autowired
    public ClientServiceImpl(ServerUrls serverUrls, RestTemplateBuilder builder, CurrentSensorInfo currentSensorInfo) {
        this.serverUrls = serverUrls;
        final Collection<MediaType> mediaTypes = List.of(MediaType.APPLICATION_JSON);
        this.restTemplate = builder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.toString(mediaTypes))
                .build();
    }

    @Override
    public long register(CreateRegistrationRequest createRegistrationRequest) {
        final ResponseEntity<CreateRegistrationResponse> response = restTemplate
                .postForEntity(serverUrls.getRegisterUrl(), createRegistrationRequest,
                        CreateRegistrationResponse.class);
        return getIdFromUrl(Objects.requireNonNull(response.getHeaders().getLocation()).getPath());
    }

    @Override
    public Optional<CreateRegistrationRequest> getNeighbour(String id) {
        final String path = String.format(serverUrls.getNeighbourUrl(), id);
        final ResponseEntity<CreateRegistrationRequest> response = restTemplate.getForEntity(path, CreateRegistrationRequest.class);

        if (Objects.equals(response.getStatusCode(), HttpStatus.NO_CONTENT)) {
            return Optional.empty();
        }

        return Optional.ofNullable(response.getBody());
    }

    @Override
    public void saveSensorData(String id, CreateSensorDataRequest createSensorDataRequest) {
        final String path = String.format(serverUrls.getDataUrl(), id);
        restTemplate.postForEntity(path, createSensorDataRequest, Void.class);
    }

    private long getIdFromUrl(String url) {
        String[] split = url.split("/");
        String id = split[split.length - 1];
        return Long.parseLong(id);
    }






}
