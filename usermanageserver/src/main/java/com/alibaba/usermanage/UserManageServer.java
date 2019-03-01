package com.alibaba.usermanage;

import com.alibaba.usermanage.grpc.UserManageServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class UserManageServer {
    private int port = 20051;
    private Server server;
    private UserManageProxy userManageProxy = new UserManageProxy();

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new UserManageImpl())
                .build()
                .start();
        System.out.println("Server started, listening on "+ port);
        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run(){

                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                UserManageServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop(){
        if (server != null){
            server.shutdown();
        }
    }

    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null){
            server.awaitTermination();
        }
    }


    public  static  void main(String[] args) throws IOException, InterruptedException {

        final UserManageServer server = new UserManageServer();
        server.start();
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
    private class UserManageImpl extends UserManageServiceGrpc.UserManageServiceImplBase {

        public void register(com.alibaba.usermanage.grpc.UserRegister.RegisterRequest request,
                             io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.RegisterResponse> responseObserver) {
            System.out.println("i receieve a register info with username:" +
                    request.getUserName() + ",password:" +
                    request.getPassword() + ",requestId:" + request.getRequestId());
            com.alibaba.usermanage.grpc.UserRegister.RegisterResponse response;
            try{
                userManageProxy.Register(request.getUserName(), request.getPassword());
                response = com.alibaba.usermanage.grpc.UserRegister.RegisterResponse.newBuilder().setRequestId(request.getRequestId()).
                                setResult("success").build();
            }catch (UserNameExistException e){
                response = com.alibaba.usermanage.grpc.UserRegister.RegisterResponse.newBuilder().setRequestId(request.getRequestId()).
                                setRequestId(request.getRequestId()).
                                setResult(e.toString()).build();
            }catch (Exception e){
                response = com.alibaba.usermanage.grpc.UserRegister.RegisterResponse.newBuilder().setRequestId(request.getRequestId()).
                                setRequestId(request.getRequestId()).
                                setResult("InternalError").build();
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("finish register!");
        }

        /**
         */
        public void login(com.alibaba.usermanage.grpc.UserRegister.LoginRequest request,
                          io.grpc.stub.StreamObserver<com.alibaba.usermanage.grpc.UserRegister.LoginResponse> responseObserver) {
            System.out.println("i receieve a login info with username:" +
                    request.getUserName() + ",password:" +
                    request.getPassword() + ",requestId:" + request.getRequestId());
            com.alibaba.usermanage.grpc.UserRegister.LoginResponse response;
            try {
                userManageProxy.Login(request.getUserName(), request.getPassword());
                response = com.alibaba.usermanage.grpc.UserRegister.LoginResponse.newBuilder().
                                setRequestId(request.getRequestId()).
                                setResult("success").build();
            }catch (UserNamePasswordError e){
                response = com.alibaba.usermanage.grpc.UserRegister.LoginResponse.newBuilder().
                                setRequestId(request.getRequestId()).
                                setResult(e.toString()).build();
            }catch (UserNotExistException e){
                response = com.alibaba.usermanage.grpc.UserRegister.LoginResponse.newBuilder().
                                setRequestId(request.getRequestId()).
                                setResult(e.toString()).build();
            }catch (Exception e){
                response = com.alibaba.usermanage.grpc.UserRegister.LoginResponse.newBuilder().
                                setRequestId(request.getRequestId()).
                                setResult("InternalError").build();
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("finish login!");
        }

    }
}
