package fer.rassus.lab1.client;

import fer.rassus.lab1.client.grpc.SensorReadingServer;
import fer.rassus.lab1.client.service.ClientService;
import fer.rassus.lab1.client.service.NeighbourSensor;
import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import fer.rassus.lab1.client.util.CreateRegistrationGeneratingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@EnableScheduling
@SpringBootApplication
public class ClientApplication {

    private static final Logger logger = Logger.getLogger(SensorReadingServer.class.getName());
    private final SensorReadingServer server;
    private final ClientService clientService;
    private final NeighbourSensor neighbourSensor;

    @Autowired
    public ClientApplication(SensorReadingServer server, ClientService clientService, NeighbourSensor neighbourSensor) {
        this.server = server;
        this.clientService = clientService;
        this.neighbourSensor = neighbourSensor;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startServer() throws IOException, InterruptedException {
        final CreateRegistrationGeneratingUtil createRegistrationGeneratingUtil = new CreateRegistrationGeneratingUtil();
        long id = clientService.register(createRegistrationGeneratingUtil.generateRegistrationRequest());
        Optional<CreateRegistrationRequest> sensorInfo = clientService.getNeighbour(String.valueOf(id));
        neighbourSensor.updateInformation(sensorInfo);
        logger.info(neighbourSensor.getHost());
        logger.info(neighbourSensor.getPort() + "");
    }

}
