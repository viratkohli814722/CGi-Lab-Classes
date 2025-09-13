package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement dash = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
	        return dash.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	By invalidCreds = By.xpath("//p[contains(text(),'Invalid credentials')]");

	public boolean isInvalidLoginDisplayed() {
	    try {
	        return driver.findElement(invalidCreds).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}


	
	public String getAttribute() {
		return driver.findElement(uname).getAttribute("placeholder");
	}
	
}
