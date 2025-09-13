package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.Base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.ExcelUtilities;
import com.orangehrm.utilities.ScreenshotUtilities;

public class Login_orangehrm extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	
  @Test(dataProvider = "logindata")
  public void verifyLogin(String username, String password) throws IOException, InterruptedException {
	  test = extent.createTest("Login with the User: "+username);
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  LoginPage obj = new LoginPage(driver);
	  obj.enterUsername(username);
	  obj.enterPassword(password);
	  obj.SubmitButton();
	  
	  
	  if (obj.DashisDisplayed()) {
		    System.out.println("Login success");
		    test.pass("Login is success for User " + username);
		} else if (obj.isInvalidLoginDisplayed()) {
		    System.out.println("Invalid login");
		    test.fail("Login failed for User " + username + " due to invalid credentials");
		} else {
		    System.out.println("Login failed - unknown reason");
		    test.fail("Login failed for User " + username)
		        .addScreenCaptureFromPath(ScreenshotUtilities.captureScreenshot
		        		(driver, "Verify Login"));
		}
  }
  
  @DataProvider
  public Object[][] logindata() throws IOException {
	  return ExcelUtilities.getData(projectpath+"\\src\\test\\resources\\Orangehrm_TestData\\Data.xlsx", "sheet1");
  }
}
