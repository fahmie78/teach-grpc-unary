package my.com.prasarana.learn.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import my.com.prasarana.learn.Request_user;
import my.com.prasarana.learn.User;
import my.com.prasarana.learn.User_ServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LearnClientApp {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50002)
                .usePlaintext().build();

        new LearnClientApp().getUserFromClient(channel);
        channel.shutdown();
    }

    public void getUserFromClient(ManagedChannel channel) {
        User_ServiceGrpc.User_ServiceBlockingStub stub = User_ServiceGrpc.newBlockingStub(channel);

        User user = stub.getUser(
                Request_user.newBuilder()
                                .setId(5)
                                .build()
        );

        logger.info(user.toString());


    }
}
