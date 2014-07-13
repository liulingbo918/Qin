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
	private String ErrMsg = null;

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
				ErrMsg = "用户不存在";
				return Command.LOGINFAIL;
			}
		} catch (SQLException e) {
			
		}
		if (pw.equals(user.getPassword())){
			if (online.equals("0"))
				return Command.LOGINSUCCESS;
			else{
				ErrMsg = "不允许重复登录";
				return Command.LOGINFAIL;
			}
		}
		else{
			ErrMsg = "密码错误";
			return Command.LOGINFAIL;
		}
	}
	
	public String getLastOnline(){
		return lastOnline;
	}
	
	public String getErrMsg(){
		return ErrMsg;
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
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String datetime = df.format(d);
		
		String sql = "INSERT INTO user(nickName, password, age, email, gender, address, IPAddr, port, isOnline, lastOnline)"
				+ "VALUES(\'" + user.getNickName() + "\', \'" + user.getPassword()
				+ "\', " + user.getAge() + ", \'" + user.getEmail()
				+ "\', \'" + user.getGender() + "\', \'" + user.getAddress()
				+ "\', \'" + user.getIPAddr() + "\', " + user.getPort()
				+ ", \'0\', \'" + datetime  + "\')";
		System.out.println(sql);
		if (dbop.insert(sql)){
			return true;
		}
		else {
			return false;
		}
	}
}
