package com.examples;

import io.grpc.stub.StreamObserver;

public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {
    @Override
    public void sayHello(Service.HelloRequest request, StreamObserver<Service.HelloResponse> responseObserver) {
        String name = request.getName();
        System.out.println("Received request: " + name);
        String phone = request.getPhone();
        Service.HelloResponse response = Service.HelloResponse.newBuilder()
                .setMessage("Hello, " + name)
                .setPhone(phone)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
