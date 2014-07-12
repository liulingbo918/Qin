package qin.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperator {

	public ResultSet query(String sql){
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) DBConnector.getDBconnection().prepareStatement(sql);
			rs = pst.executeQuery(sql);
		} catch (SQLException e) {
			
		}
		return rs;
	}
	
	public boolean update(String sql){
		Statement stmt = null;
		try{
			stmt = DBConnector.getDBconnection().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch(SQLException e){
	        return false;
		}
	}
}
