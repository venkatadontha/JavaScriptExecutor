package PavanKumar.JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import JavaScriptDemo.JavaScriptUtil;

public class TestScenario08_JSExecutor_ScrollingDownPageUntilEndOfThePage {
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com");
		
		JavaScriptUtil.scrollPageDown(driver);
		Thread.sleep(2000);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\admin\\Desktop\\Screenshot\\TestCase08.jpg");
		FileUtils.copyFile(src, trg);
		
		driver.quit();
	}
	
}
