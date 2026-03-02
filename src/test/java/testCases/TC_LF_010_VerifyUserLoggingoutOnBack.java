/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

/**
 * 
 */
public class TC_LF_010_VerifyUserLoggingoutOnBack extends BaseClass {

	
	@Test
	public void VerifyUserLoggingoutOnBack() throws InterruptedException {
		
		logger.info("==============VerifyUserLoggingoutOnBack===============");
		HomePage hp=new HomePage(driver);
		logger.info("Click the MyAccount link from Home page");
		hp.clickMyAccount();
		logger.info("Click the login link inside the MyAccount dropdown");
		hp.clickLoginLink();
		Thread.sleep(2000);
		logger.info("After clicking the login link navigated to login page");
		LoginPage lp=new LoginPage(driver);
		logger.info("Enter below details in the login page");
		lp.setLogin_Email_ID(property.getProperty("email"));
		lp.setLogin_Password(property.getProperty("password"));
		lp.clickLogin_btn();
		Thread.sleep(5000);
		logger.info("Navigate back to the login page");
		NavigateBack();
		logger.info(" validating the user should not get loggedin again");
		boolean emailstatus=lp.emailIdIsdisplayed();
		Assert.assertTrue(emailstatus, "Email text is not available !");
		
		
		

		
	}
}
