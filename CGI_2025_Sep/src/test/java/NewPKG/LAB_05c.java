package NewPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB_05c {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php");
        driver.manage().window().maximize();
   
        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]")).click();
        driver.findElement(By.linkText("Register")).click();
        
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("rohit1254");  

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("rohit1254");
    
        if(password.getAttribute("value").equals(confirmPassword.getAttribute("value"))) {
            System.out.println("Password and Confirm Password match correctly.");
        } else {
            System.out.println("Password mismatch");
        }
        driver.quit();
	}

}
