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

	public UserController(LoginContainer lc){
		this.user = lc.getUser();
	}
	
	public String doLogin(){
		dbop = new DBOperator();
		String sql = "SELECT password FROM user WHERE uid = " + user.getUid();
		ResultSet rs = null;
		String pw = "";
		try {
			rs = dbop.query(sql);
			if (rs.next()){
				pw = rs.getString("password");
			}
		} catch (SQLException e) {
			
		}
		if (pw.equals(user.getPassword())){
			Date d = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			String datetime = df.format(d);
			
			String u_update = "UPDATE user SET IPAddr = \'" + user.getIPAddr() + "\', "
					+ "port = " + user.getPort() + ", isOnline = '1', "
					+ "lastOnline = \'" + datetime + "\'";
			if (dbop.update(u_update))
				return Command.LOGINSUCCESS;	
			else
				return Command.LOGINFAIL;
		}
		else
			return Command.LOGINFAIL;
	}
}
