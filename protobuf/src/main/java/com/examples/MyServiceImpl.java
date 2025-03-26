package com.examples;

import io.grpc.stub.StreamObserver;

public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {
    @Override
    public void sayHello(Service.HelloRequest request, StreamObserver<Service.HelloResponse> responseObserver) {
        String name = request.getName();
        Service.HelloResponse response = Service.HelloResponse.newBuilder()
                .setMessage("Hello, " + name)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
