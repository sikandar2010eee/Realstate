package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RETC_067Bean;
import com.training.dao.ELearningDAO;
import com.training.dao.RETC67DAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RETC67_DataProvider {

	@DataProvider(name = "db-inputs") 
	public Object [][] getDBData() {

		List<RETC_067Bean> list = new RETC67DAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RETC_067Bean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getusername(); 
			obj[1] = temp.getemail(); 
			obj[2] = temp.getsubject(); 
			obj[3] = temp.gettext();
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\RETD_004_TC1.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
