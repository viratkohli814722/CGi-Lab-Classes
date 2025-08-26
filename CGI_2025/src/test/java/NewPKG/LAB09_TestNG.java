package NewPKG;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LAB09_TestNG {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
		
		driver.findElement(By.id("input-limit")).click();
		driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/i")).click();
		
  }
  
  @org.testng.annotations.Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String brow) {
	  System.out.println("This is Before Method");
	  if(brow.equalsIgnoreCase("chrome"))
	  {
	  WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	  }
	  if(brow.equalsIgnoreCase("edge"))
	  {
	  WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	  }
	  if(brow.equalsIgnoreCase("firefox"))
	  {
	  WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After class");
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