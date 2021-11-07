package fer.rassus.lab1.client.service;

import fer.rassus.lab1.client.SensorReadingGrpc;
import fer.rassus.lab1.client.SensorReadingRequest;
import fer.rassus.lab1.client.SensorReadingResponse;
import io.grpc.stub.StreamObserver;

public class ReceiveService extends SensorReadingGrpc.SensorReadingImplBase {

    @Override
    public void sensorRequestReading(SensorReadingRequest request, StreamObserver<SensorReadingResponse> responseObserver) {
        super.sensorRequestReading(request, responseObserver);
    }
}