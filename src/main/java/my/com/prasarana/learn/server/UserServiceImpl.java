package my.com.prasarana.learn.server;

import io.grpc.stub.StreamObserver;
import my.com.prasarana.learn.Request_user;
import my.com.prasarana.learn.User;
import my.com.prasarana.learn.User_ServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl extends User_ServiceGrpc.User_ServiceImplBase {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public void getUser(Request_user request, StreamObserver<User> responseObserver) {
        logger.info("User ID that you try to retrieve is {}", request.getId());

        responseObserver.onNext(
                User.newBuilder()
                        .setId(request.getId())
                        .setFullName("Fahmi Abdul Latip")
                        .setNirc("808080808080808")
                        .setAge(12)
                        .setAddress("Percint 8, Putrajaya")
                        .build()
        );
        responseObserver.onCompleted();
    }
}
