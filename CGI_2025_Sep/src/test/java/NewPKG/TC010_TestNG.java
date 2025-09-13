package NewPKG;
 
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class TC010_TestNG {
	WebDriver driver;
  @Test(dataProvider="logindata")

  public void f(String username, String password) {
	  System.out.println("This is the test");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		LoginPage obj = new LoginPage(driver);
		
		//WebElement uname=driver.findElement(By.name("username"));
		driver.findElement(obj.uname);
		
		if(obj.UnameisDisplayed())
		{
			obj.enterUsername(username);
		System.out.println("Get placeholder:"+obj.getAttribute());
		}
		else
		{
			System.out.println("username is not displayed");
		}

		//driver.findElement(By.name("password")).sendKeys(password);
		obj.enterPassword(password);

		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		obj.SubmitButton();

		//WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		driver.findElement(obj.dashboard);

		if(obj.DashisDisplayed())
		{
	Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method");
	  WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }
 
  @DataProvider
  public Object[][] logindata() {
	  
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "pooja", "welcome" },
    };
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class");
  }
 
  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class");
  }
 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test");
  }
 
  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test");
  }
 
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite");
  }
 
  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite");
  }
}
