/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * 
 */
public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='input-email']") WebElement txt_LoginEmail_Id;
	@FindBy(how=How.XPATH, using="//input[@id='input-password']") WebElement txt_LoginPwd;
	@FindBy(xpath="//input[@value='Login']") WebElement txt_Login_btn;
	@FindBy(how=How.XPATH,using="//div[@class='list-group']/a[text()='Login']")WebElement Login_link;
	@FindBy(xpath="//span[text()='My Account']") WebElement txt_myaccount_link;
	@FindBy(how=How.XPATH, using="//a[text()='Login']") WebElement txt_login_link;//login link
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement login_alert_msg;
	
	
	public void setLogin_Email_ID(String emailID) {
		txt_LoginEmail_Id.sendKeys(emailID);
	}
	
	public void setLogin_Password(String pwd) {
		txt_LoginPwd.sendKeys(pwd);
	}
	
	public void clickLogin_btn() {
		txt_Login_btn.click();
	}
	
	public void clickLogin_link() {
		Login_link.click();
	}
	
	public void clickMyAccount() {
		txt_myaccount_link.click();
	}
	
	public void clickLoginlink() {
		txt_login_link.click();
	}
	
	public String getLoginalertmsg() {
	
		try {
			return login_alert_msg.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

}
