package id.investree.chatserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChatServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ChatServerApplication.class, args);

		Server server = ServerBuilder.forPort(8080)
			.addService(new ChatServiceImpl())
			.build();

		server.start();
		System.out.println("Server is up");
		server.awaitTermination();
	}
}
