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
 * valid data---loginsuccessful--logout-pass
 * Valid date---login failed---testcase failed
 * 
 * Invalid data-login successful---logout---testcase failed
 * Invalid data--login failed-----testcase Pass
 * 
 */
public class TC_LF_001_005_LoginTestCasesDDT extends BaseClass{

	

	@Test(dataProvider="login_data",dataProviderClass=DataProviders.class)
	public void VerifyLoginDDT(String username, String password, String exp_result) {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		LoginPage lp=new LoginPage(driver);
		lp.setLogin_Email_ID(username);
		lp.setLogin_Password(password);
		lp.clickLogin_btn();
		MyAccountPage Accountpage=new MyAccountPage(driver);
		boolean targetpage=Accountpage.is_Account_page_Exist();
		if(exp_result.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				Accountpage.click_logout_link();
				Assert.assertTrue(true);
			}else {
				Assert.assertEquals(lp.getLoginalertmsg(), "Warning: No match for E-Mail Address and/or Password.");
				Assert.assertTrue(false);
			}
		}
		if(exp_result.equalsIgnoreCase("InValid")) {
			if(targetpage==true) {
				Accountpage.click_logout_link();
				Assert.assertTrue(false);
			}else {
				Assert.assertEquals(lp.getLoginalertmsg(), "Warning: No match for E-Mail Address and/or Password.");
			}
		}
		
		
		
	}
	
}
