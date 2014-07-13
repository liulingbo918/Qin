package qin.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperator {

	private Connection getDBconnection(){
		Connection db = null;
		try{
			String url = "jdbc:mysql://localhost:3306/qin";
			Class.forName("com.mysql.jdbc.Driver");
			db = DriverManager.getConnection(url,"root","admin");
		} catch(Exception e){
			System.out.println("database connect faild!" + e.getMessage());
		} 
		return db;
	}
	
	public ResultSet query(String sql){
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) getDBconnection().prepareStatement(sql);
			rs = pst.executeQuery(sql);
		} catch (SQLException e) {
			
		}
		return rs;
	}
	
	public boolean update(String sql){
		Statement stmt = null;
		try{
			stmt = getDBconnection().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch(SQLException e){
	        return false;
		}
	}
	
	public boolean insert(String sql){
		Statement stmt = null;
		try{
			stmt = getDBconnection().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch(SQLException e){
			return false;
		}
	}
}
