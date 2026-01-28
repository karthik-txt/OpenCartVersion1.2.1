/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class AccountRegisterationPage extends BasePage {

	
	
	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
	@FindBy(xpath="//input[@id='input-email']")WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirm;
	@FindBy(xpath="//input[@name='agree']") WebElement policy_check_box;
	@FindBy(xpath="//input[@class='btn btn-primary']") WebElement btn_submit;
	@FindBy(xpath="//div[@id='content']/h1") WebElement msg_confirmation;
	@FindBy(xpath="//div[@class='list-group']/a[text()='Login']")WebElement login_link;
	
	public void setFirstName(String firstname) {
		txt_firstname.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		txt_lastname.sendKeys(lastname);
	}
	
	public void setEmail_textbox(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setTelephone_textbox(String telephone) {
		txt_telephone.sendKeys(telephone);
	}
	
	public void setPassword_textbox(String password) {
		txt_password.sendKeys(password);
	}
	
	public void setconfPassword_textbox(String password) {
		txt_confirm.sendKeys(password);
	}
	
	public void clickPolicycheckbox() {
		policy_check_box.click();
	}
	
	public void clickSubmit_btn() {
		btn_submit.click();
	}
	
	public String getConfirmMsg() {
		try {
			return msg_confirmation.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickLogin_link() {
		login_link.click();
	}
	
	
}
