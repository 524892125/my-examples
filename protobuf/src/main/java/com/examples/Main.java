//package com.examples;
//
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//
//import java.io.IOException;
//
////TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
//// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
//public class Main {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        // 创建并启动 gRPC 服务器
//        Server server = ServerBuilder.forPort(50051)
//                .addService(new MyServiceImpl())  // 注册服务实现
//                .build();
//
//        server.start();
//        System.out.println("Server started on port 50051");
//
//        server.awaitTermination();
//    }
//}