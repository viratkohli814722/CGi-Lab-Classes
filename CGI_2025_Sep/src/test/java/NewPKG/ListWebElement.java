package NewPKG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links in website: " + allLinks.size());
		
		for(WebElement link:allLinks) {
			System.out.println("page totle of each link: " + link.getText());
		}
	}

}
