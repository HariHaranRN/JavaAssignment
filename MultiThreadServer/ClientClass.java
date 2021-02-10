package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientClass {
	public static void main(String[] args) {
		Client.connect("localhost", 3333);
	}
}

class Client {

	private Client() {
	}

	private static Socket socket;
	private static BufferedReader keyIn;
	private static PrintWriter out;
	private static ExecutorService es;

	public static void connect(String Domain, int PORT) {

		try {
			socket = new Socket(Domain, PORT);
			System.out.println(">>");
			
			// Sub-thread to receive incoming messages
			IncMsgHandler handler = new IncMsgHandler(socket);
			es = Executors.newSingleThreadExecutor();
			es.execute(handler);

			// Sending message to server/other clients in main thread
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(socket.getOutputStream(), true);
			while (true && !socket.isClosed()) {
				String input = keyIn.readLine();
				if (input.equals("quit")) {
					break;
				} else {
					out.println(input);
					Thread.sleep(100);
					System.out.println(">>");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Socket closed.");
				socket.close();
			} catch (IOException e) {
				System.out.println("Problem closing socket");
				e.printStackTrace();
			}
			es.shutdown();
			out.close();
		}
	}
}

class IncMsgHandler implements Runnable {
	private Socket serverSocket;
	private BufferedReader in;
	public IncMsgHandler(Socket serverSocket) throws Exception {
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		try {
			while (true && !serverSocket.isClosed()) {
				in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
				String serverMsg = in.readLine();
				if (serverMsg == null) {
					break;
				}
				System.out.println("Server : " + serverMsg);
			}
		} catch (Exception e) {
			if(e.getMessage().equals("Socket closed")) {
				System.out.println("Sub-Thread  : "+e.getMessage());
			}else {
				e.printStackTrace();
			}
		} finally {
			try {
				in.close();
				System.out.println("Server problem, disconnecting socket");
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}