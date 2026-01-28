/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.implementation.bind.annotation.Super;

/**
 * 
 */
public class HomePage extends BasePage {

	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']") WebElement txt_myaccount_link;
	
	@FindBy(xpath="//a[text()='Register']") WebElement txt_register_link;
	
	@FindBy(how=How.XPATH, using="//a[text()='Login']") WebElement txt_login_link;//login link
	
	public void clickMyAccount() {
		txt_myaccount_link.click();
	}
	
	public void clickRegisterLink() {
		txt_register_link.click();
	}
	
	public void clickLoginLink() {
		txt_login_link.click();
	}
	
	
}
