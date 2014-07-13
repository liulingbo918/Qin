package qin.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import qin.model.Command;
import qin.model.domainClass.User;
import qin.control.DBOperator;

public class UserController {
	
	private User user = null;
	private DBOperator dbop = null;
	private String lastOnline = null;
	private String responseMsg = null;

	public UserController(int uid, String pw){
		user = new User();
		user.setUid(uid);
		user.setPassword(pw);
		dbop = new DBOperator();
	}
	
	public UserController(User u){
		this.user = u;
		dbop = new DBOperator();
	}
	
	public String doLogin(){
		String sql = "SELECT password, isOnline, lastOnline FROM user WHERE uid = " + user.getUid();
		ResultSet rs = null;
		String pw = "";
		String online = "";
		try {
			rs = dbop.query(sql);
			if (rs.next()){
				pw = rs.getString("password");
				online = rs.getString("isOnline");
				lastOnline = rs.getString("lastOnline");
			}
			else{
				responseMsg = "用户不存在";
				return Command.LOGINFAIL;
			}
		} catch (SQLException e) {
			
		}
		
		System.out.println("receive: pw  "+pw);
		
		if (pw.equals(user.getPassword())){
			if (online.equals("0"))
				return Command.LOGINSUCCESS;
			else{
				responseMsg = "不允许重复登录";
				return Command.LOGINFAIL;
			}
		}
		else{
			responseMsg = "密码错误";
			return Command.LOGINFAIL;
		}
	}
	
	public String getLastOnline(){
		return lastOnline;
	}
	
	public String getResponseMsg(){
		return responseMsg;
	}
	
	public boolean updateState(){
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String datetime = df.format(d);
		
		String u_update = "UPDATE user SET IPAddr = \'" + user.getIPAddr() + "\', "
				+ "port = " + user.getPort() + ", isOnline = '1', "
				+ "lastOnline = \'" + datetime + "\' WHERE uid = " + user.getUid() + "";
		if (dbop.update(u_update)){
			return true;
		}
		else
			return false;
	}
	
	public boolean register(){
		//System.out.println("start register");
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String datetime = df.format(d);
		
		String sql = "INSERT INTO user(nickName, password, age, email, gender, address, IPAddr, port, isOnline, lastOnline)"
				+ "VALUES(\'" + user.getNickName() + "\', \'" + user.getPassword()
				+ "\', " + user.getAge() + ", \'" + user.getEmail()
				+ "\', \'" + user.getGender() + "\', \'" + user.getAddress().toString()
				+ "\', \'" + user.getIPAddr() + "\', " + user.getPort()
				+ ", \'0\', \'" + datetime  + "\')";
		
		if (dbop.insert(sql)){
			
			String sql2 = "SELECT uid FROM user WHERE nickName = \'" + user.getNickName() + "\'AND "
					+ "password = \'" + user.getPassword() + "\'AND age = \'" + user.getAge() + "\'AND "
					+ "email = \'" + user.getEmail() + "\'AND gender = \'" + user.getGender() + "\'AND "
					+ "address = \'" + user.getAddress().toString() + "\'";
			
			ResultSet rs = null;
			int uid = 0;
			try {
				rs = dbop.query(sql2);
				if (rs.next()){
					uid = rs.getInt("uid");
					responseMsg = Integer.toString(uid);
				}
			} catch (SQLException e) {
				
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void logout(){
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String datetime = df.format(d);
		
		String sql = "SELECT password FROM user WHERE uid = " + user.getUid();
		ResultSet rs = null;
		String pw = "";
		
		try {
			rs = dbop.query(sql);
			if (rs.next()){
				pw = rs.getString("password");
			}
			
			if (pw.equals(user.getPassword())){
				String sql2 = "UPDATE user SET IPAddr = null, port = null, isOnline = '0', "
						+ "lastOnline = \'" + datetime + "\' WHERE uid = " + user.getUid();
				dbop.update(sql2);
			}
		} catch (SQLException e) {
			
		}
	}
}
