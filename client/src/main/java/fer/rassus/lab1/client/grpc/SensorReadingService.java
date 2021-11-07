package fer.rassus.lab1.client.grpc;

import fer.rassus.lab1.client.SensorReadingRequest;
import fer.rassus.lab1.client.SensorReadingResponse;
import fer.rassus.lab1.client.SensorReadingServiceGrpc;
import fer.rassus.lab1.client.service.SensorReadingFileService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SensorReadingService extends SensorReadingServiceGrpc.SensorReadingServiceImplBase {
  private static final Logger logger = Logger.getLogger(SensorReadingService.class.getName());
  private final SensorReadingFileService sensorReadingFileService;

  @Autowired
  public SensorReadingService(SensorReadingFileService sensorReadingFileService) {
    this.sensorReadingFileService = sensorReadingFileService;
  }

  @Override
  public void requestSensorReading(
          SensorReadingRequest request, StreamObserver<SensorReadingResponse> responseObserver
  ) {

    // Create response
    SensorReadingResponse response = sensorReadingFileService.getSensorReading();

    // Send response
    responseObserver.onNext(
            response
    );

    logger.info("Responding with: " + response.getCo());
    responseObserver.onCompleted();
  }
}
