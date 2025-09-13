package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtilities {
	static String projectpath=System.getProperty("user.dir");
	
	public static String captureScreenshot(WebDriver driver, String TestName) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenpath = projectpath+"\\src\\test\\resources\\Orangehrm_Screenshots\\screenshot2.png";
		File dest = new File(screenpath);
		FileUtils.copyFile(src, dest);
		return screenpath;
	}
}
