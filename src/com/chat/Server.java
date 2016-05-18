package com.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket socket = null;
		try {
			ServerSocket s = new ServerSocket(8888);
			System.out.println("��������������");
			socket = s.accept();
			while (true) {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				String str = null;
				if ((str = dis.readUTF()) != null) {
					System.out.println("�ͻ���˵��" + str);
				}
				dos.writeUTF("��������˵��" + str);
			}
		} catch (IOException e) {
			System.out.println("�������˹رգ�");
		} finally {
			try {
				dis.close();
				dos.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
