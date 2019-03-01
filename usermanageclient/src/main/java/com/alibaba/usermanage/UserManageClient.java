package com.alibaba.usermanage;

import com.alibaba.usermanage.grpc.UserManageServiceGrpc;
import com.alibaba.usermanage.grpc.UserRegister;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class UserManageClient {
    private final ManagedChannel channel;
    private final UserManageServiceGrpc.UserManageServiceBlockingStub blockingStub;
    private  long requestId;

    public UserManageClient(String host,int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = UserManageServiceGrpc.newBlockingStub(channel);
        requestId = 0;
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void login(String userName, String password){
        UserRegister.LoginResponse response;
        try{
            response = blockingStub.login(UserRegister.LoginRequest.newBuilder().setUserName(userName).setPassword(password).setRequestId(String.valueOf(++requestId)).build());
            System.out.println("login: "+response.getResult());
        }catch (StatusRuntimeException e) {
            System.out.println("login exception");
        }
    }

    public  void register(String userName, String password){
        UserRegister.RegisterResponse response;
        try{
            response = blockingStub.register(UserRegister.RegisterRequest.newBuilder().setUserName(userName).setPassword(password).setRequestId(String.valueOf(++requestId)).build());
            System.out.println("register: "+response.getResult());
        }catch (StatusRuntimeException e) {
            System.out.println("register exception");
        }
    }

    public static void main(String[] args) {
        int i = 0;
        UserManageClient client = new UserManageClient("user-manage-service",10051);
        try{
            while(++i < 1000){
                client.register("user" + String.valueOf(i), "pass"+String.valueOf(i));
            }
            while(true){
                int num = (int) (Math.random() * 1500);
                client.login("user" + String.valueOf(num), "pass"+String.valueOf(num));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            try {
                client.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
