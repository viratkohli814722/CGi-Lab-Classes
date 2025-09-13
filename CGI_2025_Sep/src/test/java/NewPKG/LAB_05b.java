package NewPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;;

public class LAB_05b {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		WebElement element = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]"));
        element.click();		
        driver.findElement(By.linkText("Register")).click();
        WebElement firstName = driver.findElement(By.xpath("//*[@id='input-firstname']"));
        firstName.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijkl");
        firstName.clear();
        driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();
        
        String expectedWarning = "First Name must be between 1 and 32 characters!";
		WebElement warningElement = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div"));

		if (warningElement.getText().contains(expectedWarning)) {
		    System.out.println("✅ Warning message is displayed correctly.");
		} else {
		    System.out.println("❌ Warning message is missing or incorrect.");
		}
		
		
		WebElement Name = driver.findElement(By.xpath("//*[@id='input-firstname']"));
		Name.sendKeys("Rohith");
		
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Kumar");
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("rohithkumar90942@gmail.com");
		
		WebElement PhoneNumber = driver.findElement(By.id("input-telephone"));
		PhoneNumber.sendKeys("Kumar");
		
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();
		
		driver.quit();
		}
	}
