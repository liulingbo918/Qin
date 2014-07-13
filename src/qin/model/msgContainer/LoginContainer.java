package qin.model.msgContainer;

import java.io.Serializable;

import qin.model.domainClass.*;

public class LoginContainer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private User user;

	/***
	 * �ͻ��� --> �����
	 * ��Ҫ�ύ �˺� �� ����
	 * QinMessagePacket.command = LOGIN
	 * @param id
	 * @param passeord
	 */
	public LoginContainer(int id, String password, String IP, int listenPort) {
		user = new User();
		
		user.setUid(id);
		user.setPassword(password);
		user.setIPAddr(IP);
		user.setPort(listenPort);
	}
	
	/***
	 * ����� --> �ͻ���
	 * ���������֤�˺š�������ȷ�󣬷��ص�¼�û�����ϸ��Ϣ
	 * QinMessagePacket.command = LOGINSUCCESS
	 * @param _user
	 */
	public LoginContainer(User _user) {
		user = _user;
	}
		
	/***
	 * ����� --> �ͻ���(��¼�û������ߺ���)
	 * QinMessagePacket.command = FRIENDLOGIN
	 * @param id
	 */
	public LoginContainer(int id) {
		user = new User();
		user.setUid(id);
	}
	
	/***
	 * ��1������ˣ���ȡ��¼�û����˺�ID
	 * ��2���ͻ���(��¼�û������ߺ���) : ��ȡ��¼���ѵ��˺�ID
	 * @return
	 */
	public int getLoginUserID() {
		return user.getUid();
	}
	
	
	/***
	 * ����� ��ȡ��¼�û�������password 
	 * @param 
	 */
	public String getLoginUserPassword() {
		return  user.getPassword();
	} 
	
	
	/***
	 * �ͻ��� ��ȡ���û���Ϣ
	 * @return
	 */
	public User getUser() {
		return user;
	}
}

