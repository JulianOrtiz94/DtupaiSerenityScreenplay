package co.dtupai.qa.dtupaiscreenplay.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConexionInternet {
	public static boolean internetConnection() {
		Socket socket = new Socket();
		InetSocketAddress address = new InetSocketAddress("www.google.com", 80);
		
		try {
			socket.connect(address, 3000);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
	}
}
