import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
	private ServerSocket serveur;
	private Socket sock;
	private PrintWriter sendinfo;
	public Serveur() {
		try {
			this.serveur = new ServerSocket(8888);
			while(true) {
				this.sock = serveur.accept();
				this.sendinfo = new PrintWriter(sock.getOutputStream());
				Thread t = new Thread(new lectureClient(sock));
				t.start();
				System.out.println("CrÃ©ation d'un client OK");
			}
		}
		catch(IOException ioe) { ioe.printStackTrace(); }
	}

	class lectureClient implements Runnable {
		Socket sockCli;
		BufferedReader info;
		String message;
		public lectureClient (Socket sockCli) {
			try {
				this.sockCli = sockCli;
              	this.info = new BufferedReader(
					new InputStreamReader(this.sockCli.getInputStream()));
			} catch(IOException ioe) { ioe.printStackTrace(); }
		}
		public void run() {
			try {
				while((this.message=info.readLine()) != null) {
					System.out.println("Message du client : " + this.message);
				}
			} catch(IOException ioe1) { ioe1.printStackTrace(); }
			finally {
				try {
					System.out.println("Un client a quitter la discussion !");
					this.sockCli.close();
				} catch(IOException ioe2) { ioe2.printStackTrace(); }
			}
		}
	}

	public static void main(String[] args) {
		Serveur myServ = new Serveur();
	}

}