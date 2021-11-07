package fer.rassus.lab1.client;

import io.grpc.stub.StreamObserver;

public class GRpcServerServiceImpl extends RegistrationServiceGrpc.RegistrationServiceImplBase {
    @Override
    public void register(RegistrationRequest request, StreamObserver<RegistrationResponse> responseObserver) {
        super.register(request, responseObserver);
    }
}