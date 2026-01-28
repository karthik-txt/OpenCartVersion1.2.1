/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

/**
 * 
 */
public class TC_LF_006 extends BaseClass {
	
	@Test(groups= {"Regression","Master","Sanity"})
	public void Forgotten_Password_link() {
		logger.info("*********Started TC_LF_006_Forgotten_Password_linkeTestcase*************");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Click the MyAccount link from the homepage");
		hp.clickMyAccount();
		logger.info("Click the Login link from the homepage");
		hp.clickLoginLink();
		logger.info("After Clicking  the Login link and it is navigated to the Login Page");
		LoginPage lp=new LoginPage(driver);
		String actual_login_title=getTitle();
		logger.info("Click the forget password link from the Login Page");
		lp.clickForgotPwdlink();
		logger.info("Validate the below steps");
		Assert.assertEquals(actual_login_title, property.getProperty("applogintitle"));
		Assert.assertTrue(lp.forgotpwdlinkvisible());
		Assert.assertEquals(getTitle(),property.getProperty("forgot_title"));
		}
		catch(Exception e) {
			Log.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		logger.info("*********Completed TC_LF_006_Forgotten_Password_linkeTestcase*************");

		
	}

}
