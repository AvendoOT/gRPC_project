package fer.rassus.lab1.client;

import fer.rassus.lab1.client.service.Client;
import fer.rassus.lab1.client.service.ReceiveService;
import io.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * The type Simple unary rpc client.
 */
public class Server {

  private static final Logger logger = Logger.getLogger(Server.class.getName());

  private io.grpc.Server server;
  private final ReceiveService service;
  private final int port;

  @Autowired
  public Server(ReceiveService service, int port) {
    this.service = service;
    this.port = port;
  }

  /**
   * Start the server.
   *
   * @throws IOException the io exception
   */
  public void start() throws IOException {
    // Register the service
    server = ServerBuilder.forPort(port)
            .addService(service)
            .build()
            .start();
    logger.info("Server started on " + port);

    //  Clean shutdown of server in case of JVM shutdown
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("Shutting down gRPC server since JVM is shutting down");
      try {
        Server.this.stop();
      } catch (InterruptedException e) {
        e.printStackTrace(System.err);
      }
      System.err.println("Server shut down");
    }));
  }

  /**
   * Stops the server.
   *
   * @throws InterruptedException the interrupted exception
   */
  public void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  /**
   * Await termination on the main thread
   *
   * @throws InterruptedException the interrupted exception
   */
  public void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final Server server = new Server(new ReceiveService(), 4000);
    server.start();
    Client client = new Client("127.0.0.1", 4000);

    client.sendData();
    client.stop();

    server.blockUntilShutdown();
  }
}
