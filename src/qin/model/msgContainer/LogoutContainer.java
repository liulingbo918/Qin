package qin.model.msgContainer;

import java.io.Serializable;

public class LogoutContainer implements Serializable {
	private static final long serialVersionUID = 1L;

	private int uid;
	private String password;
	
	public LogoutContainer(int id, String pw){
		uid = id;
		password = pw;
	}
	
	public int getUid(){
		return uid;
	}
	
	public void setUid(int id){
		uid = id;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String pw){
		password = pw;
	}
}
