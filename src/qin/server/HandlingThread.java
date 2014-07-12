package qin.server;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import qin.control.UserController;
import qin.model.Command;
import qin.model.QinMessagePacket;
import qin.model.domainClass.User;

public class HandlingThread extends Thread {
	private Socket client;
	/*
	 * ���캯��������ÿһ��socketʵ��
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
			System.out.println("�߳̿���");
			//�����������Ļ�ȡ�뷵��
			is = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
			Object obj = is.readObject();
			QinMessagePacket ret = null;
			QinMessagePacket qmp = (QinMessagePacket) obj;
			String op = qmp.getCommand();
			
			if (Command.LOGIN.equals(op)){
				UserController lc = new UserController(qmp.getLoginContainer());
				String returnStr = lc.doLogin();
				ret = new QinMessagePacket(returnStr);
			}
			//User user = (User)obj;
			
			//User user = null;
			
			
			//System.out.println("user: "+user.getNickName() + "/" + user.getPassword());
			
			//user.setNickName(user.getNickName()+"_new");
			//user.setPassword(user.getPassword()+"_new");
			
			out = new ObjectOutputStream(client.getOutputStream());
			out.writeObject(ret);
			out.flush();
			is.close();
			out.close();
		} catch (Exception e) {
		} finally {
		}
	}
}
