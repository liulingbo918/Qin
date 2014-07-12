package qin.server;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import qin.control.QinHandler;
import qin.model.QinMessagePacket;

public class HandlingThread extends Thread {
	private Socket client;
	/*
	 * 构造函数，接收每一个socket实例
	 */
	public HandlingThread(Socket socket) {
		this.client = socket;
	}

	/*
	 * 线程执行方法
	 */
	public void run() {
		ObjectInputStream is = null;
		ObjectOutputStream out = null;
		try {
			System.out.println("线程开启");
			//对象数据流的获取与返回
			is = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
			Object obj = is.readObject();
			QinMessagePacket qmp = (QinMessagePacket) obj;
			
			QinHandler qinHandler = new QinHandler(qmp);
			qmp = qinHandler.getResponse();
			
			out = new ObjectOutputStream(client.getOutputStream());
			out.writeObject(qmp);
			out.flush();
			is.close();
			out.close();
		} catch (Exception e) {
		} finally {
		}
	}
}
