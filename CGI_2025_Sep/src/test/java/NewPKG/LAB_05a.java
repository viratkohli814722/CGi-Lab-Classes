package NewPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;;

public class LAB_05a {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]"));
        element.click();		
        driver.findElement(By.linkText("Register")).click();
        
        WebElement normal = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        
        if (normal.getText().contains("Register Account")) {
		    System.out.println("✅ Text Register Account is displayed correctly.");
		} else {
		    System.out.println("❌ Text Register Account is missing or incorrect.");
		}
		
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();
		
		String expectedWarning = "Warning: You must agree to the Privacy Policy!";
		WebElement warningElement = driver.findElement(By.xpath("//*[@id='account-register']/div[1]"));

		if (warningElement.getText().contains(expectedWarning)) {
		    System.out.println("✅ Warning message is displayed correctly.");
		} else {
		    System.out.println("❌ Warning message is missing or incorrect.");
		}

		driver.quit();
		}
	}
