package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.SensorReadingGrpc;
import fer.rassus.lab1.client.SensorReadingMessageResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());


    private final ManagedChannel channel;
    private final SensorReadingGrpc.SensorReadingBlockingStub uppercaseBlockingStub;

    /**
     * Instantiates a new Simple unary rpc client.
     *
     * @param host the host
     * @param port the port
     */
    public Client(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        uppercaseBlockingStub = SensorReadingGrpc.newBlockingStub(channel);

    }

    /**
     * Stop the client.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void stop() throws InterruptedException {
//    Initiates an orderly shutdown in which preexisting calls continue but new calls are
//    immediately cancelled. Waits for the channel to become terminated, giving up if the timeout
//    is reached.
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Request uppercase.
     */
    public void sendData() {

        final String payload = "message";

        SensorReadingMessageResponse request = SensorReadingMessageResponse.newBuilder().setCo((float) 1.0)
                .setHumidity((float)2.0).setNo2((float)3.0).setPressure((float)4.0).setSo2((float)5.0).setTemperature((float)6.0).build();

        logger.info("Sending: " + request.getHumidity());
        try {
            SensorReadingMessageResponse response = uppercaseBlockingStub.sensorRequestMessageReading(request);
            logger.info("Received: " + response.getHumidity());
        } catch (StatusRuntimeException e) {
            logger.info("RPC failed: " + e.getMessage());
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client("127.0.0.1", 5000);

        client.sendData();

        client.stop();
    }
}
