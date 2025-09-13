package NewPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB_05d {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php");
        driver.manage().window().maximize();
   
        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]")).click();
        driver.findElement(By.linkText("Register")).click();
        
        WebElement Name = driver.findElement(By.xpath("//*[@id='input-firstname']"));
		Name.sendKeys("Rohith");
		
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Kumar");
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("rohithkumar814722@gmail.com");
		
		WebElement PhoneNumber = driver.findElement(By.id("input-telephone"));
		PhoneNumber.sendKeys("Kumar");
        
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("rohit1254");  

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("rohit1254");
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
        
        driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();
        
        WebElement content = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        
        if(content.equals("Your Account Has Been Created!")) {
            System.out.println("Password and Confirm Password match correctly.");
        } 
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
        
        driver.quit();
        
	}
}
