package NewPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By uname = By.name("username");
	By pwd = By.name("password");
	By submit = By.xpath("//button[@type='submit']");
	By dashboard = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
	
	public void enterUsername(String username) {
		driver.findElement(uname).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void SubmitButton() {
		driver.findElement(submit).click();
	}
	
	public boolean UnameisDisplayed() {
		return driver.findElement(uname).isDisplayed();
	}
	
	public boolean DashisDisplayed() {
		return driver.findElement(dashboard).isDisplayed();
	}
	
	public String getAttribute() {
		return driver.findElement(uname).getAttribute("placeholder");
	}
	
}
