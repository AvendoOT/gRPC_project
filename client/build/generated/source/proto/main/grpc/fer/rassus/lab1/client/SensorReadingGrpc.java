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
  private static volatile io.grpc.MethodDescriptor<fer.rassus.lab1.client.SensorReadingMessageResponse,
      fer.rassus.lab1.client.SensorReadingMessageResponse> getSensorRequestMessageReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SensorRequestMessageReading",
      requestType = fer.rassus.lab1.client.SensorReadingMessageResponse.class,
      responseType = fer.rassus.lab1.client.SensorReadingMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fer.rassus.lab1.client.SensorReadingMessageResponse,
      fer.rassus.lab1.client.SensorReadingMessageResponse> getSensorRequestMessageReadingMethod() {
    io.grpc.MethodDescriptor<fer.rassus.lab1.client.SensorReadingMessageResponse, fer.rassus.lab1.client.SensorReadingMessageResponse> getSensorRequestMessageReadingMethod;
    if ((getSensorRequestMessageReadingMethod = SensorReadingGrpc.getSensorRequestMessageReadingMethod) == null) {
      synchronized (SensorReadingGrpc.class) {
        if ((getSensorRequestMessageReadingMethod = SensorReadingGrpc.getSensorRequestMessageReadingMethod) == null) {
          SensorReadingGrpc.getSensorRequestMessageReadingMethod = getSensorRequestMessageReadingMethod =
              io.grpc.MethodDescriptor.<fer.rassus.lab1.client.SensorReadingMessageResponse, fer.rassus.lab1.client.SensorReadingMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SensorRequestMessageReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fer.rassus.lab1.client.SensorReadingMessageResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fer.rassus.lab1.client.SensorReadingMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SensorReadingMethodDescriptorSupplier("SensorRequestMessageReading"))
              .build();
        }
      }
    }
    return getSensorRequestMessageReadingMethod;
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
    public void sensorRequestMessageReading(fer.rassus.lab1.client.SensorReadingMessageResponse request,
        io.grpc.stub.StreamObserver<fer.rassus.lab1.client.SensorReadingMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSensorRequestMessageReadingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSensorRequestMessageReadingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                fer.rassus.lab1.client.SensorReadingMessageResponse,
                fer.rassus.lab1.client.SensorReadingMessageResponse>(
                  this, METHODID_SENSOR_REQUEST_MESSAGE_READING)))
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
    public void sensorRequestMessageReading(fer.rassus.lab1.client.SensorReadingMessageResponse request,
        io.grpc.stub.StreamObserver<fer.rassus.lab1.client.SensorReadingMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSensorRequestMessageReadingMethod(), getCallOptions()), request, responseObserver);
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
    public fer.rassus.lab1.client.SensorReadingMessageResponse sensorRequestMessageReading(fer.rassus.lab1.client.SensorReadingMessageResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSensorRequestMessageReadingMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<fer.rassus.lab1.client.SensorReadingMessageResponse> sensorRequestMessageReading(
        fer.rassus.lab1.client.SensorReadingMessageResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSensorRequestMessageReadingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SENSOR_REQUEST_MESSAGE_READING = 0;

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
        case METHODID_SENSOR_REQUEST_MESSAGE_READING:
          serviceImpl.sensorRequestMessageReading((fer.rassus.lab1.client.SensorReadingMessageResponse) request,
              (io.grpc.stub.StreamObserver<fer.rassus.lab1.client.SensorReadingMessageResponse>) responseObserver);
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
              .addMethod(getSensorRequestMessageReadingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
