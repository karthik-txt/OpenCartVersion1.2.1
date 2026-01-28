/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

/**
 * 
 */
public class TC_LF_021_LoginPageTestcase extends BaseClass {

	@Test(priority=1,groups={"Sanity"})
	public void verify_LoginPage() throws InterruptedException {
		logger.info("*********Starter TC_LF_021_LoginPageTestcase*************");
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		logger.info("Click the MyAccount link from Home page");
		hp.clickMyAccount();
		logger.info("Click the Registeration link from Home page");
		hp.clickRegisterLink();
		logger.info("Navigated to account Registeration page");
		Thread.sleep(3000);

		AccountRegisterationPage page=new AccountRegisterationPage(driver);
		logger.info("Click login link from the Account Registration page");
		Thread.sleep(3000);
		page.clickLogin_link();
		if(getUrl().equals(property.get("apploginlink"))&& getTitle().equals(property.getProperty("applogintitle"))) {
			logger.info("Login page is displayed");
			Assert.assertTrue(true,"Login page is displayed");
		}else {
			logger.info("Login page is not displayed");
			Assert.fail("Not navigated to login page");
		}
		//verifyUrlAndTitle(property.getProperty("apploginlink"), property.getProperty("applogintitle"));
//		Thread.sleep(3000);
//		LoginPage lp=new LoginPage(driver);
//		logger.info("Click login link from the Login page");
//		lp.clickLogin_link();
//		if(driver.getCurrentUrl().equals(property.get("apploginlink"))&& driver.getTitle().equals(property.getProperty("applogintitle"))) {
//			logger.info("Login page is displayed");
//			Assert.assertTrue(true,"Login page is displayed");
//		}else {
//			logger.info("Login page is not displayed");
//			Assert.fail("Not navigated to login page");
//		}
//		verifyUrlAndTitle(property.getProperty("apploginlink"), property.getProperty("applogintitle"));
//		logger.info("Click MyAccount link from the Login page");
//		lp.clickMyAccount();
//		logger.info("Click login link from the MyAccount dropdown");
//		lp.clickLogin_link();
//		if(driver.getCurrentUrl().equals(property.getProperty("apploginlink"))&& driver.getTitle().equals(property.getProperty("applogintitle"))) {
//			logger.info("Login page is displayed");
//			Assert.assertTrue(true,"Login page is displayed");
//		}else {
//			logger.info("Login page is not displayed");
//			Assert.fail("Not navigated to login page");
//		}
//		verifyUrlAndTitle(property.getProperty("apploginlink"), property.getProperty("applogintitle"));
		
		
		
	}
	
	@Test(priority=2,dependsOnMethods = {"verify_LoginPage"},groups={"Sanity"})
	public void verifyLoginfromLoginPage() {
		LoginPage lp=new LoginPage(driver);
		logger.info("Click login link from the Login page");
		lp.clickLogin_link();
		if(getUrl().equals(property.getProperty("apploginlink"))&& getTitle().equals(property.getProperty("applogintitle")+"7568")) {
			logger.info("Login page is displayed");
			Assert.assertTrue(true,"Login page is displayed");
		}else {
			logger.error("Login page is not displayed");
			Assert.fail("Not navigated to login page");
		}
	}
	
	@Test(priority=3,dependsOnMethods= {"verifyLoginfromLoginPage"},groups = {"Sanity"})
	public void clickloginfromMyAccount() {
		LoginPage lp=new LoginPage(driver);
		logger.info("Click MyAccount link from the Login page");
		lp.clickMyAccount();
		logger.info("Click login link from the MyAccount dropdown");
		lp.clickLogin_link();
		if(getUrl().equals(property.getProperty("apploginlink"))&& getTitle().equals(property.getProperty("applogintitle"))) {
			logger.info("Login page is displayed");
			Assert.assertTrue(true,"Login page is displayed");
		}else {
			logger.info("Login page is not displayed");
			Assert.fail("Not navigated to login page");
		}
		logger.info("*********Completed TC_LF_021_LoginPageTestcase*************");
	}
}
