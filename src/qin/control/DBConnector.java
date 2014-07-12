package qin.control;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	public static Connection getDBconnection(){
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
}
