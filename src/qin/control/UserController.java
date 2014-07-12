package qin.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import qin.model.Command;
import qin.model.domainClass.User;
import qin.model.msgContainer.LoginContainer;

public class UserController {
	
	private User user = null;

	public UserController(LoginContainer lc){
		this.user = lc.getUser();
	}
	
	public String doLogin(){
		Connection conn = DBConnector.getDBconnection();
		String sql = "SELECT password FROM user WHERE uid = " + user.getUid();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String pw = "";
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			if (rs.next()){
				pw = rs.getString("password");
			}
		} catch (SQLException e) {
			
		}
		if (pw.equals(user.getPassword()))
			return Command.LOGINSUCCESS;
		else
			return Command.LOGINFAIL;
	}
}
