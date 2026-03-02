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
public class TC_LF_008_OpenCartLoginPlaceholderTest extends BaseClass  {
	
	@Test
	public void verifyLoginPlaceholders() {
		logger.info("==============Started the TC_LF_008_OpenCartLoginPlaceholderTest====================");
		HomePage hp=new HomePage(driver);
		logger.info("Click the MyAccount link from Home page");
		hp.clickMyAccount();
		logger.info("Click the login link from the MyAccount dropdown");
		hp.clickLoginLink();
		logger.info("After clicking the login link, Navigated to the login page");
		LoginPage lp=new LoginPage(driver);
		logger.info("capturing the placeholder for username and password");
		String email_placeholder=lp.getEmailField("placeholder");
		String pwd_placedholder=lp.getLoginPwdField("placeholder");
		//System.out.println(email_placeholder+"========="+pwd_placedholder);
		
		Assert.assertEquals(email_placeholder, "E-Mail Address","Email Placeholder Mismatch");
		Assert.assertEquals(pwd_placedholder, "Password","Password Placeholder Mismatch");

	}

}
