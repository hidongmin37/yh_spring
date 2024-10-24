package exception.ex2;

public class NetworkServiceV1_1 {


	public void sendMessage(String data){
		String address = "http://localhost:8080";
		NetworkClientV1 client = new NetworkClientV1(address);
		client.initError(data); // error1, error2


		try {
			String message = client.connect();
			System.out.println("connection status: " + message);
			client.send(data);
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		} finally {
			client.disconnect();
		}
	}
}
