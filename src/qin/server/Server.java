package qin.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	/*
	 * 启用线程方法实现多个用户连接socket服务器端.
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 创建服务端，监听端口6688
		ServerSocket ss = new ServerSocket(6687);
		System.out.println("服务器已经开启，等待连接。");
		// 使用服务器端保持永久监听状态
		while (true) {
			// 接收每一个客户端的连接，并返回socket实例
			//Server osa = new Server(server.accept());
			// 为每一个客户端启一个线程，去执行操作
			//osa.start();
			HandlingThread ht = new HandlingThread(ss.accept());
			ht.start();
		}
	}
}

