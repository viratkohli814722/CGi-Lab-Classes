package NewPKG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("accept")).click();
		Alert simpAlert = driver.switchTo().alert();
		System.out.println("The alert is " + simpAlert.getText());
		simpAlert.accept();
		
		driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
		Alert confAlert = driver.switchTo().alert();
		System.out.println("The alert is " + confAlert.getText());
		confAlert.accept();
		
		driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("The alert is " + promptAlert.getText());
		promptAlert.sendKeys("Rohith");
		promptAlert.accept();
		
		WebElement modAlert = driver.findElement(By.xpath("//*[@id=\"modern\"]"));
		modAlert.click();
		System.out.println("The alert is " + modAlert.getText());
		driver.findElement(By.xpath("/html/body/app-root/app-alert/section/div/div/div[1]/div/div/div[5]/button")).click();
		
	}
}
