package exception.ex1;

public class NetworkServiceV0 {


	public void sendMessage(String data){
		String address = "http://localhost:8080";
		NetworkClientV0 client = new NetworkClientV0(address);


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
