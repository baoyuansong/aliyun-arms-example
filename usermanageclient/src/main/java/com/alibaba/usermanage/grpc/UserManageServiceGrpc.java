package com.alibaba.usermanage.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: grpc.proto")
public final class UserManageServiceGrpc {

  private UserManageServiceGrpc() {}

  public static final String SERVICE_NAME = "UserManageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.alibaba.usermanage.grpc.UserRegister.RegisterRequest,
      com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = com.alibaba.usermanage.grpc.UserRegister.RegisterRequest.class,
      responseType = com.alibaba.usermanage.grpc.UserRegister.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.alibaba.usermanage.grpc.UserRegister.RegisterRequest,
      com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.alibaba.usermanage.grpc.UserRegister.RegisterRequest, com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = UserManageServiceGrpc.getRegisterMethod) == null) {
      synchronized (UserManageServiceGrpc.class) {
        if ((getRegisterMethod = UserManageServiceGrpc.getRegisterMethod) == null) {
          UserManageServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<com.alibaba.usermanage.grpc.UserRegister.RegisterRequest, com.alibaba.usermanage.grpc.UserRegister.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserManageService", "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.usermanage.grpc.UserRegister.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.usermanage.grpc.UserRegister.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserManageServiceMethodDescriptorSupplier("Register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.alibaba.usermanage.grpc.UserRegister.LoginRequest,
      com.alibaba.usermanage.grpc.UserRegister.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.alibaba.usermanage.grpc.UserRegister.LoginRequest.class,
      responseType = com.alibaba.usermanage.grpc.UserRegister.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.alibaba.usermanage.grpc.UserRegister.LoginRequest,
      com.alibaba.usermanage.grpc.UserRegister.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.alibaba.usermanage.grpc.UserRegister.LoginRequest, com.alibaba.usermanage.grpc.UserRegister.LoginResponse> getLoginMethod;
    if ((getLoginMethod = UserManageServiceGrpc.getLoginMethod) == null) {
      synchronized (UserManageServiceGrpc.class) {
        if ((getLoginMethod = UserManageServiceGrpc.getLoginMethod) == null) {
          UserManageServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.alibaba.usermanage.grpc.UserRegister.LoginRequest, com.alibaba.usermanage.grpc.UserRegister.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserManageService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.usermanage.grpc.UserRegister.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.usermanage.grpc.UserRegister.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserManageServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserManageServiceStub newStub(io.grpc.Channel channel) {
    return new UserManageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserManageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserManageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserManageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserManageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserManageServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public void register(com.alibaba.usermanage.grpc.UserRegister.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void login(com.alibaba.usermanage.grpc.UserRegister.LoginRequest request,
        io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.alibaba.usermanage.grpc.UserRegister.RegisterRequest,
                com.alibaba.usermanage.grpc.UserRegister.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.alibaba.usermanage.grpc.UserRegister.LoginRequest,
                com.alibaba.usermanage.grpc.UserRegister.LoginResponse>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   */
  public static final class UserManageServiceStub extends io.grpc.stub.AbstractStub<UserManageServiceStub> {
    private UserManageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserManageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserManageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserManageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public void register(com.alibaba.usermanage.grpc.UserRegister.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.alibaba.usermanage.grpc.UserRegister.LoginRequest request,
        io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserManageServiceBlockingStub extends io.grpc.stub.AbstractStub<UserManageServiceBlockingStub> {
    private UserManageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserManageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserManageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserManageServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public com.alibaba.usermanage.grpc.UserRegister.RegisterResponse register(com.alibaba.usermanage.grpc.UserRegister.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.alibaba.usermanage.grpc.UserRegister.LoginResponse login(com.alibaba.usermanage.grpc.UserRegister.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserManageServiceFutureStub extends io.grpc.stub.AbstractStub<UserManageServiceFutureStub> {
    private UserManageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserManageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserManageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserManageServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> register(
        com.alibaba.usermanage.grpc.UserRegister.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.alibaba.usermanage.grpc.UserRegister.LoginResponse> login(
        com.alibaba.usermanage.grpc.UserRegister.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_LOGIN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserManageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserManageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.alibaba.usermanage.grpc.UserRegister.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.alibaba.usermanage.grpc.UserRegister.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.LoginResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserManageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserManageServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.alibaba.usermanage.grpc.UserRegister.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserManageService");
    }
  }

  private static final class UserManageServiceFileDescriptorSupplier
      extends UserManageServiceBaseDescriptorSupplier {
    UserManageServiceFileDescriptorSupplier() {}
  }

  private static final class UserManageServiceMethodDescriptorSupplier
      extends UserManageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserManageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserManageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserManageServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
