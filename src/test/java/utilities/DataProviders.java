/**
 * 
 */
package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;

/**
 * 
 */
public class DataProviders {

	@DataProvider(name="loginData")
	public String [][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtilityFile xlutil=new ExcelUtilityFile(path);
		int rowcount=xlutil.getRowcount("Sheet1");
		int cellcount=xlutil.getCellcount("Sheet1", 1);
		String logindata [][] =new String[rowcount][cellcount];
		
		for(int r=1;r<=rowcount;r++) {
			for(int c=-0;c<cellcount;c++) {
				logindata[r-1][c]=xlutil.getCelldata("Sheet1", r, c);//row=1 and cell=0
			}
		}
		return logindata;
		
	}
	
	
	@DataProvider(name="login_data")
	public String[][]getLoginData() throws IOException{
		//String path=System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx";
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtilityFile xlutility=new ExcelUtilityFile(path);
		int rowcount=xlutility.getRowcount("sheet1");
		int cellcount=xlutility.getCellcount("sheet1", 1);
		String[][]logindata=new String[rowcount][cellcount];
		for(int r=1;r<=rowcount;r++) {
			for(int c=0;c<cellcount;c++) {
				logindata[r-1][c]=xlutility.getCelldata("sheet1", r, c);//1,0
			}
		}
		return logindata;
	}
	
}
