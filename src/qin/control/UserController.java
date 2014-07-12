package qin.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import qin.model.Command;
import qin.model.domainClass.User;
import qin.model.msgContainer.LoginContainer;
import qin.control.DBOperator;

public class UserController {
	
	private User user = null;
	private DBOperator dbop = null;
	private String lastOnline = null;

	public UserController(LoginContainer lc){
		this.user = lc.getUser();
		dbop = new DBOperator();
	}
	
	public String doLogin(){
		String sql = "SELECT password, lastOnline FROM user WHERE uid = " + user.getUid();
		ResultSet rs = null;
		String pw = "";
		try {
			rs = dbop.query(sql);
			if (rs.next()){
				pw = rs.getString("password");
				lastOnline = rs.getString("lastOnline");
			}
		} catch (SQLException e) {
			
		}
		if (pw.equals(user.getPassword())){
			return Command.LOGINSUCCESS;
		}
		else
			return Command.LOGINFAIL;
	}
	
	public String getLastOnline(){
		return lastOnline;
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
}
