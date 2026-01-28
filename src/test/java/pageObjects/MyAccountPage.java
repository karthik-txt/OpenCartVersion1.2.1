/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h2") WebElement msg_heading;
	@FindBy(xpath="//div[@class='list-group']/a[text()='Logout']") WebElement logout_link;
	
	public boolean is_Account_page_Exist() {
		
		try {
		return msg_heading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void click_logout_link() {
		logout_link.click();
	}

	
}
