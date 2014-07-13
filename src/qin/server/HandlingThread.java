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
	 * ���캯�����ÿһ��socketʵ��
	 */
	public HandlingThread(Socket socket) {
		this.client = socket;
	}

	/*
	 * �߳�ִ�з���
	 */
	public void run() {
		ObjectInputStream is = null;
		ObjectOutputStream out = null;
		try {
			System.out.println("线程开启");
			//����������Ļ�ȡ�뷵��
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
