package fer.rassus.lab1.client;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startServer() throws IOException, InterruptedException {
//        Server server = ServerBuilder
//                .forPort(8090)
//                .addService(new GRpcServerServiceImpl()).build();
//
//        server.start();
//        server.awaitTermination();
    }

}
