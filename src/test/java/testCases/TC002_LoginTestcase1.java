/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

/**
 * 
 */
public class TC002_LoginTestcase1 extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void Verify_Login() {
		logger.info("**************Started TC002_LoginTestcase1************");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Click the MyAccount link from the homepage");
		hp.clickMyAccount();
		logger.info("Click the Login link from the homepage");
		hp.clickLoginLink();
		logger.info("After Clicking  the Login link and it is navigated to the Login Page");
		LoginPage lp=new LoginPage(driver);
		logger.info("Enterthe below details from the Login Page");
		lp.setLogin_Email_ID(property.getProperty("email"));
		lp.setLogin_Password(property.getProperty("password"));
		logger.info("Click the login button from the Login Page");
		lp.clickLogin_btn();
		Thread.sleep(3000);
		logger.info("After clicking the login button and it has to navigate to MyAccount Page");
		MyAccountPage accountpage=new MyAccountPage(driver);
		boolean status=accountpage.is_Account_page_Exist();
		logger.info("Verify the Heading the msg from the MyAccount Page, So the MyAccount page exists");		
		Assert.assertTrue(status,"Login Failed");
		}
		catch(Exception e) {
			Assert.fail("Login Failed");
		}
		
		logger.info("**************Finished TC002_LoginTestcase1************");

		
	}
	
}
