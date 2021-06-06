package com.training.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.bean.DBBean;
/*
 * this class is for estalishing the connection to the database.The method used to establish the connect 
 * will accept the DB bean object as its arguments.
 * 
 */
public class GetConnection {
	static Connection connection; 
	public PreparedStatement ps1, ps2; 
	public ResultSet rs1, rs2; 
	
	public static Connection getMySqlConnection(DBBean dbBean) {
		
		try {
			// load 
			Class.forName(dbBean.getDriver());
			connection = DriverManager.getConnection(dbBean.getUrl() , 
					dbBean.getUserName(), dbBean.getPassword());
			
			return connection; 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static Connection getOracleConnection(DBBean dbBean) {
		return null;
	}
}
