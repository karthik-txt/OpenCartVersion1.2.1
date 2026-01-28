/**
 * 
 */
package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/**
 * 
 * Scenario1:
 * 
 * Valid data---Login success---- Test pass----Logout
 * Valid data---Login Failed-----Test Failed
 * 
 * Scenario2:
 * 
 * Invalid data----Login success--- Test fail----logout
 * Invalid data----Login Failed----Test Pass
 * 
 * 
 */
public class TC003_LoginTestcaseDDT extends BaseClass {

	//WebDriver driver;
	@Test(dataProvider = "loginData", dataProviderClass=DataProviders.class,groups= {"DatadrivenTesting","Master"})
	public void verifyLogin_TestCaseDDT(String emailID, String password, String exp_result) {
		//logger.info("*************Started verifyLogin_TestCaseDDT***************");
//		driver=new ChromeDriver();
//		driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
		try {
		HomePage hp=new HomePage(driver);		
		//logger.info("Click the MyAccount link from the homepage");
		hp.clickMyAccount();
		//logger.info("Click the Login link from the homepage");
		hp.clickLoginLink();
		//logger.info("After Clicking  the Login link and it is navigated to the Login Page");
		LoginPage lp=new LoginPage(driver);
		//logger.info("Enterthe below details from the Login Page");
		lp.setLogin_Email_ID(emailID);
		lp.setLogin_Password(password);
		lp.clickLogin_btn();
		MyAccountPage account=new MyAccountPage(driver);
		boolean targetpage=account.is_Account_page_Exist();
		
		if(exp_result.equalsIgnoreCase("valid")) {
		if(targetpage==true) {
			account.click_logout_link();
			Assert.assertTrue(targetpage);
		}else {
			Assert.assertTrue(false);
		}
	}
	
		if(exp_result.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				account.click_logout_link();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		//logger.info("**************Finished verifyLogin_TestCaseDDT************");

	
	}
}
