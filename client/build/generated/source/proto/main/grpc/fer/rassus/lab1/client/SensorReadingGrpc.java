package fer.rassus.lab1.client;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.41.0)",
    comments = "Source: readings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SensorReadingGrpc {

  private SensorReadingGrpc() {}

  public static final String SERVICE_NAME = "fer.rassus.lab1.SensorReading";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<fer.rassus.lab1.client.SensorReadingRequest,
      fer.rassus.lab1.client.SensorReadingResponse> getSensorRequestReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SensorRequestReading",
      requestType = fer.rassus.lab1.client.SensorReadingRequest.class,
      responseType = fer.rassus.lab1.client.SensorReadingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fer.rassus.lab1.client.SensorReadingRequest,
      fer.rassus.lab1.client.SensorReadingResponse> getSensorRequestReadingMethod() {
    io.grpc.MethodDescriptor<fer.rassus.lab1.client.SensorReadingRequest, fer.rassus.lab1.client.SensorReadingResponse> getSensorRequestReadingMethod;
    if ((getSensorRequestReadingMethod = SensorReadingGrpc.getSensorRequestReadingMethod) == null) {
      synchronized (SensorReadingGrpc.class) {
        if ((getSensorRequestReadingMethod = SensorReadingGrpc.getSensorRequestReadingMethod) == null) {
          SensorReadingGrpc.getSensorRequestReadingMethod = getSensorRequestReadingMethod =
              io.grpc.MethodDescriptor.<fer.rassus.lab1.client.SensorReadingRequest, fer.rassus.lab1.client.SensorReadingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SensorRequestReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fer.rassus.lab1.client.SensorReadingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fer.rassus.lab1.client.SensorReadingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SensorReadingMethodDescriptorSupplier("SensorRequestReading"))
              .build();
        }
      }
    }
    return getSensorRequestReadingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SensorReadingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorReadingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorReadingStub>() {
        @java.lang.Override
        public SensorReadingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorReadingStub(channel, callOptions);
        }
      };
    return SensorReadingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SensorReadingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorReadingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorReadingBlockingStub>() {
        @java.lang.Override
        public SensorReadingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorReadingBlockingStub(channel, callOptions);
        }
      };
    return SensorReadingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SensorReadingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorReadingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorReadingFutureStub>() {
        @java.lang.Override
        public SensorReadingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorReadingFutureStub(channel, callOptions);
        }
      };
    return SensorReadingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SensorReadingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sensorRequestReading(fer.rassus.lab1.client.SensorReadingRequest request,
        io.grpc.stub.StreamObserver<fer.rassus.lab1.client.SensorReadingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSensorRequestReadingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSensorRequestReadingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                fer.rassus.lab1.client.SensorReadingRequest,
                fer.rassus.lab1.client.SensorReadingResponse>(
                  this, METHODID_SENSOR_REQUEST_READING)))
          .build();
    }
  }

  /**
   */
  public static final class SensorReadingStub extends io.grpc.stub.AbstractAsyncStub<SensorReadingStub> {
    private SensorReadingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorReadingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorReadingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sensorRequestReading(fer.rassus.lab1.client.SensorReadingRequest request,
        io.grpc.stub.StreamObserver<fer.rassus.lab1.client.SensorReadingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSensorRequestReadingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SensorReadingBlockingStub extends io.grpc.stub.AbstractBlockingStub<SensorReadingBlockingStub> {
    private SensorReadingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorReadingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorReadingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public fer.rassus.lab1.client.SensorReadingResponse sensorRequestReading(fer.rassus.lab1.client.SensorReadingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSensorRequestReadingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SensorReadingFutureStub extends io.grpc.stub.AbstractFutureStub<SensorReadingFutureStub> {
    private SensorReadingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorReadingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorReadingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<fer.rassus.lab1.client.SensorReadingResponse> sensorRequestReading(
        fer.rassus.lab1.client.SensorReadingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSensorRequestReadingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SENSOR_REQUEST_READING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SensorReadingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SensorReadingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SENSOR_REQUEST_READING:
          serviceImpl.sensorRequestReading((fer.rassus.lab1.client.SensorReadingRequest) request,
              (io.grpc.stub.StreamObserver<fer.rassus.lab1.client.SensorReadingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SensorReadingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SensorReadingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return fer.rassus.lab1.client.Readings.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SensorReading");
    }
  }

  private static final class SensorReadingFileDescriptorSupplier
      extends SensorReadingBaseDescriptorSupplier {
    SensorReadingFileDescriptorSupplier() {}
  }

  private static final class SensorReadingMethodDescriptorSupplier
      extends SensorReadingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SensorReadingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SensorReadingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SensorReadingFileDescriptorSupplier())
              .addMethod(getSensorRequestReadingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
