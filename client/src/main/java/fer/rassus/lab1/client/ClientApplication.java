package fer.rassus.lab1.client;

import fer.rassus.lab1.client.grpc.SensorReadingServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class ClientApplication {

    private final SensorReadingServer server;

    @Autowired
    public ClientApplication(SensorReadingServer server) {
        this.server = server;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startServer() throws IOException, InterruptedException {
        server.start();
        server.blockUntilShutdown();
    }

}
