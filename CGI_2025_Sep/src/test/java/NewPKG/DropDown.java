package NewPKG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		WebElement sort = driver.findElement(By.id("input-sort"));
		
		Select sort1 = new Select(sort);
		List<WebElement> all = sort1.getOptions();
		
		for(int i=0;i<all.size();i++) {
			System.out.println("Values are: " + all.get(i).getText());
		}
		driver.close();
	}
}
