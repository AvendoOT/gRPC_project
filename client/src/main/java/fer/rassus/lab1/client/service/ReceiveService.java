package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.SensorReadingGrpc;
import fer.rassus.lab1.client.SensorReadingMessageResponse;
import io.grpc.stub.StreamObserver;
import java.util.logging.Logger;

public class ReceiveService extends SensorReadingGrpc.SensorReadingImplBase {

    private static final Logger logger = Logger.getLogger(ReceiveService.class.getName());

    public ReceiveService() {
    }

    @Override
    public void sensorRequestMessageReading(SensorReadingMessageResponse request, StreamObserver<SensorReadingMessageResponse> responseObserver) {
        logger.info("Got a new request: " + request.getHumidity());
        SensorReadingMessageResponse response = SensorReadingMessageResponse.newBuilder().setCo((float) 1.0)
                .setHumidity((float)2.0).setNo2((float)3.0).setPressure((float)4.0).setSo2((float)5.0).setTemperature((float)6.0).build();
        responseObserver.onNext(
                response
        );
        logger.info("Responding with: " + response.getHumidity());
        responseObserver.onCompleted();
    }
}