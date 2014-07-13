package qin.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	/*
	 * �����̷߳���ʵ�ֶ���û�����socket��������.
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// ��������ˣ�����˿�6688
		ServerSocket ss = new ServerSocket(6687);
		System.out.println("服务器已经开启，等待连接。");
		// ʹ�÷������˱������ü���״̬
		while (true) {
			// ����ÿһ���ͻ��˵����ӣ�������socketʵ��
			//Server osa = new Server(server.accept());
			// Ϊÿһ���ͻ�����һ���̣߳�ȥִ�в���
			//osa.start();
			HandlingThread ht = new HandlingThread(ss.accept());
			ht.start();
		}
	}
}

