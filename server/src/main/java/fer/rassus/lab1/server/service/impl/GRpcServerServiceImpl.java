package fer.rassus.lab1.server.service.impl;

import fer.rassus.lab1.server.RegistrationRequest;
import fer.rassus.lab1.server.RegistrationResponse;
import fer.rassus.lab1.server.RegistrationServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GRpcServerServiceImpl extends RegistrationServiceGrpc.RegistrationServiceImplBase {
    @Override
    public void register(RegistrationRequest request, StreamObserver<RegistrationResponse> responseObserver) {
        super.register(request, responseObserver);
    }
}