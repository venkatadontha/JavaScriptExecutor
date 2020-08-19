package PavanKumar.JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import JavaScriptDemo.JavaScriptUtil;

public class TestScenario03_JSExecutor_CaptureTitleOfPage {
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com");
		
		String Title = driver.getTitle();
		System.out.println(Title);
		
		String TitleusingJS = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(TitleusingJS);
		Thread.sleep(2000);
		
		Assert.assertEquals(Title,TitleusingJS);
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\admin\\Desktop\\Screenshot\\TestCase03.jpg");
		FileUtils.copyFile(src, trg);
		
		driver.quit();
	}
	
}
