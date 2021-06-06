package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs") 
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); //getLogins is returning object of LoginBean stored into the ArrayList
		
		Object[][] result = new Object[list.size()][]; //list.size() defines now of rows in the table
		int count = 0; //means ist row..
		for(LoginBean temp : list){// we are iterating through list of loginBean Objects.
			Object[]  obj = new Object[2]; // depending on the columns we are defining size of the Object array.
			obj[0] = temp.getUserName(); //setting the elements of the Object array.
			obj[1] = temp.getPassword(); 
			result[count ++] = obj; //storing that object into result.
		}
		
		
		return result;//returning the entire record from the database
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\MDAHMAD\\Desktop\\New.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\MDAHMAD\\Desktop\\New.xls", "Sheet1"); 
	}
}
