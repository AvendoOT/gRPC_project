package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.service.ClientService;
import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.service.request.CreateSensorDataRequest;
import fer.rassus.lab1.client.service.response.CreateRegistrationResponse;
import fer.rassus.lab1.client.service.response.CreateSensorDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

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

    @Override
    public String neighbour(String id) {
        final String path = String.format(serverUrls.getRegisterUrl(), id);
        return sendGetRequestToServer(path, Collections.emptyMap(), id, String.class);
    }

    @Override
    public CreateSensorDataResponse saveSensorData(String id, CreateSensorDataRequest createSensorDataRequest) {
        final String path = String.format(serverUrls.getDataUrl(), id);
        final ResponseEntity<CreateSensorDataResponse> response = restTemplate
                .postForEntity(path, createSensorDataRequest,
                        CreateSensorDataResponse.class);
        return Objects.requireNonNull(response.getBody());
    }

    private <T> T sendGetRequestToServer(String url, Map<String, String> queryParams, String username,
                                         Class<T> castClass) {
        final HttpHeaders headers = createHeaders(username);
        final HttpEntity<String> entity = new HttpEntity<>(headers);

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        queryParams.forEach(builder::queryParam);
        final ResponseEntity<T> response =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, castClass);
        return response.getBody();
    }

    private static HttpHeaders createHeaders(String username) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Internal-Username", username);

        return headers;
    }






}
