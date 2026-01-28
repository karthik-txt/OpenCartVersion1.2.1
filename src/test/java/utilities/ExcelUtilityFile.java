/**
 * 
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */
public class ExcelUtilityFile {

	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet xs;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle style;
	String path;
	
	public ExcelUtilityFile(String path) {
		this.path=path;
	}
	
	public int getRowcount(String sheet) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		xs=wb.getSheet(sheet);
		int rowcount=xs.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	public int getCellcount(String sheet, int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		xs=wb.getSheet(sheet);
		row=xs.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
	}
	
	public String getCelldata(String sheet, int rownum,int cellnum)throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		xs=wb.getSheet(sheet);
		row=xs.getRow(rownum);
		cell=row.getCell(cellnum);
		String data="";
		try {
			//data=cell.toString();
			DataFormatter formate=new DataFormatter();
			data=formate.formatCellValue(cell);
		}catch(Exception e) {
			data="";
		}
		
		return data;
	}
	
	public void setCelldata(String sheet, int rownum,int cellnum,String data) throws IOException {
		
		File xlfile=new File(path);
		if(xlfile.exists()) {// If the file is not exist then it will create a new file
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(xlfile);
			wb.write(fo);
		}
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		if(wb.getSheetIndex(sheet)==-1)// if the sheet is not available in the workbook the it will create a new sheet
			wb.createSheet(sheet);
			xs=wb.getSheet(sheet);
			
		if(xs.getRow(rownum)==null)//if row will exist the it will create a new row
			xs.createRow(rownum);
		row=xs.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public void fillGreen(String sheet, int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		xs=wb.getSheet(sheet);
		row=xs.getRow(rownum);
		cell=row.getCell(cellnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public void fillRed(String sheet, int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		xs=wb.getSheet(sheet);
		row=xs.getRow(rownum);
		cell=row.getCell(cellnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	
	
	
}
