package id.investree.chatserver;

import id.swarawan.ChatMessage;
import id.swarawan.ChatResponse;
import id.swarawan.ChatServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

	@Override
	public void chat(ChatMessage request, StreamObserver<ChatResponse> responseObserver) {
		String isGenap = isGenap(request.getNumber()) ? "Genap" : "Ganjil";
		String responseMessage = String.format("Halo %s, nomor kamu %d adalah %s",
			request.getName(),
			request.getNumber(),
			isGenap);

		ChatResponse response = ChatResponse.newBuilder()
			.setResponseMessage(responseMessage)
			.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	private boolean isGenap(int number) {
		return number % 2 == 0;
	}
}
