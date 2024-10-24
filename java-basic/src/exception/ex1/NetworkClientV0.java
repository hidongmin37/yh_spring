package exception.ex1;

public class NetworkClientV0 {

	private final String address;

	public NetworkClientV0(String address) {
		this.address = address;
	}

	public String connect() {
		System.out.println("connect: " + address);

		return "success";
	}

	public String send(String data) {
		System.out.println("send: " + data);

		return "success";
	}

	public void disconnect() {
		System.out.println("disconnect: " + address);
	}


}
