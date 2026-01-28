/**
 * 
 */
package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * 
 */
public class BaseClass {
	
	public static WebDriver driver;
	public  Logger logger;
	public Properties property;
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		FileInputStream file=new FileInputStream("./src//test//resources//config.properties");
		property=new Properties();
		property.load(file);
		//The above 3 lines of code to load config property file
		logger=LogManager.getLogger(this.getClass());//log4j.xml
		if(property.getProperty("execution_env").equals("Remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")) {
				
				capabilities.setPlatform(Platform.LINUX);
			}else {
				System.out.println("No Matching OS");
				return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("chrome"); break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			case "edge":capabilities.setBrowserName("edge");break;
			default: System.out.println("Invalid browser");return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		}
		
		if(property.getProperty("execution_env").equals("local")) {
			switch(br.toLowerCase()) {
			case "chrome":driver=new ChromeDriver(); break;
			case "firefox":driver=new FirefoxDriver(); break;
			case "edge":driver=new EdgeDriver(); break;
			default: System.out.println("Invalid browser"); return;
			}
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
		driver.get(property.getProperty("appurl2"));
	
	}
	
	@AfterClass(groups={"Regression","Master","Sanity"})
	public void tearDown() {
		driver.quit();
	}
	
	
	public String RandomString() {
		String generatestring =RandomStringUtils.randomAlphabetic(6);
		return generatestring;
	}
	
	public String RandomNumber() {
		String generatenumber=RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	public String RandomAplanumeric() {
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		String generatenumber=RandomStringUtils.randomNumeric(5);
		return generatestring+"@%*$"+generatenumber;
	}
	
	public String captureScreen(String tname)throws IOException {
		String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String filepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		File target=new File(filepath);
//		try {
//		FileUtils.copyFile(source, target);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return filepath;
		source.renameTo(target);
//		
		return filepath;
	}
	
	public String getTitle() {
		String Title=driver.getTitle();
		return Title;
	}
	
	public String getUrl() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	
}
