package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilits {
	public static class ExcelUtility {

	    public static FileInputStream fi;
	    public static FileOutputStream fo;
	    public static XSSFWorkbook wb;
	    public static XSSFSheet ws;
	    public static XSSFRow row;
	    public static XSSFCell cell;

	  
	    // Get the number of rows in a sheet
	    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
	    	
	        fi = new FileInputStream(xlfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);
	        int rowcount = ws.getLastRowNum();
	        wb.close();
	        fi.close();
	        return rowcount;
	    }

	    // Get the number of columns in a specific row
	    public static int getCellCount(String xlfile,String xlsheet, int rownum) throws IOException {
	        fi = new FileInputStream(xlfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);
	        row = ws.getRow(rownum);
	        int cellcount = row.getLastCellNum();
	        wb.close();
	        fi.close();
	        return cellcount;
	    }

	    // Read data from a specific cell
	    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
	        fi = new FileInputStream(xlfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);
	        row = ws.getRow(rownum);
	        cell = row.getCell(colnum);

	        String data;
	        try {
	            DataFormatter formatter = new DataFormatter(); // Format data as text
	            String cellData=formatter.formatCellValue(cell);
	            return cellData;
	        } catch (Exception e) {
	            data = ""; // Return empty string if cell is null
	        }

	        wb.close();
	        fi.close();
	        return data;
	    }

	    // Write or update data in a specific cell
	    public static void setCellData(String xlfile, int xlsheet, int rownum, int colnum, String data) throws IOException {
	       

	        fi = new FileInputStream(xlfile);
	        wb = new XSSFWorkbook(fi);

	       

	        ws = wb.getSheet(xlfile);
	        row = ws.getRow(rownum);

	      
	        cell = row.getCell(colnum);

	      

	        cell.setCellValue(data);

	        fo = new FileOutputStream(xlfile);
	        wb.write(fo);
	        wb.close();
	        fi.close();
	        fo.close();
	    }

	    
	    
	}

	
}
