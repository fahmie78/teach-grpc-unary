package my.com.prasarana.learn.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LearnMainApp {

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(LearnMainApp.class.getName());

        Server server = ServerBuilder
                .forPort(50002)
                .addService(new UserServiceImpl())
                .build().start();

        logger.info("gRPC is running on port 50002");

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
