package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
/*this class will do return DB data as a list.
 * 
 */

public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); //creating object of GetConnection
		List<LoginBean> list = null;//list of type LoginBean objects----
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); //created an object of ArrayList of type LoginBean.
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {// here u r checking the records in the DB
			
				LoginBean temp = new LoginBean(); //here u have created an object of Loginbean which is call used to hold the values from DB.
				temp.setUserName(gc.rs1.getString(1));// here username from the DB is passed to the DB bean variable.from column 1
				temp.setPassword(gc.rs1.getString(2));//another variable password from the DB is stored in DB bean variable.from column2
				

				list.add(temp); //storing the LoginBean objects in the List.
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; //the whole method is returning object of Login bean that is all values from the database.
	}
	
	public static void main(String[] args) {
		new ELearningDAO().getLogins().forEach(System.out :: println);
	}
	
	
}
