package com.training.readexcel;

import java.io.FileInputStream;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ApachePOIExcelReadBlankValues {
	
		try {
			InputStream ExcelFileToRead = new FileInputStream(EXCEL_FILE);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;	
			HSSFCell cell;

			Iterator rows = (Iterator) sheet.rowIterator();

			while (rows.hasNext()) {
				row = (HSSFRow) rows.next();
				
				for(int i=0; i<row.getLastCellNum(); i++) {
					cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
					System.out.print(cell.toString()+" ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
