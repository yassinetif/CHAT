
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	private Socket sock;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	private String serveur, username;
	private int port;

	public Client(String username) {
		this.serveur = "localhost";
		this.port = 8888;
		this.username = username;
		try {
			sock = new Socket(serveur, port);
		} catch(IOException ioe1) { ioe1.printStackTrace(); }
		try {
			in  = new ObjectInputStream(sock.getInputStream());
			out = new ObjectOutputStream(sock.getOutputStream());
		} catch(IOException ioe2) { ioe2.printStackTrace(); }
		new ListenFromServer().start();
	}

	public void disconnect() {
		try {
			in.close();
			out.close();
			sock.close();
		} catch(IOException ioe) { ioe.printStackTrace(); }
	}

	class ListenFromServer extends Thread {
		public void run() {
			while(true) {
				try {
					String message = (String) in.readObject();
					System.out.println(message);
					System.out.print("> ");
				} catch(IOException ioe) { ioe.printStackTrace(); }	
				catch(ClassNotFoundException e) {}
			}
		}
	}

	public static void main(String args[]) {
		if(args.length!=1) {
			System.out.println("Usage : java Client username");
		}
		String username = args[0];
		Client client = new Client(username);
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("> ");
			// read message from user
			String message = scan.nextLine();
		}
		//client.disconnect();
	}

}