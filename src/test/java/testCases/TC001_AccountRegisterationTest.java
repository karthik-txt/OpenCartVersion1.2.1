/**
 * 
 */
package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

/**
 * 
 */
public class TC001_AccountRegisterationTest extends BaseClass {

	
	
	@Test(groups={"Regression","Master","Sanity"})
	public void verify_account_registeration() {
		logger.info("***************Started TC001_AccountRegisterationTest***********");
		try {
		HomePage hp= new HomePage(driver);
		logger.info("Click the MyAccount Link from the hompage");
		hp.clickMyAccount();
		logger.info("Click the Registeration Link from the hompage");
		hp.clickRegisterLink();
		logger.info("After Clicking the Registeration Link it is navigated to the Account Registeration Page");
		AccountRegisterationPage regpage= new AccountRegisterationPage(driver);
		logger.info("Add the below details in the Registeraion page for the Registeration purpose");
		regpage.setFirstName(RandomString());
		regpage.setLastName(RandomString());
		regpage.setEmail_textbox(RandomString()+"@gmail.com");
		regpage.setTelephone_textbox(RandomNumber());
		String password=RandomAplanumeric();
		regpage.setPassword_textbox(password);
		regpage.setconfPassword_textbox(password);
		regpage.clickPolicycheckbox();
		regpage.clickSubmit_btn();
		logger.info("Validating the Confirmation message");
		
		
		String confmsg=regpage.getConfirmMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("Test Passed:"+confmsg);
			Assert.assertTrue(true);
		}else {
			logger.info("Test failed ");
			logger.debug("Test failed....");
			Assert.assertTrue(false);
		}
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***********Completed TC001_AccountRegisterationTest***********");
		
		
	}
	
	
	
	
}
