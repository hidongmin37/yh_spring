package nested.ex2;

public class Network {

	private static class NetworkMessage {
		private String content;

		public NetworkMessage(String content) {
			this.content = content;
		}

		public void print() {
			System.out.println("content = " + content);
		}
	}

	public void sendMessage(String text) {
		NetworkMessage message = new NetworkMessage(text);
		message.print();
	}
}
