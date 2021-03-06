package PavanKumar.JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import JavaScriptDemo.JavaScriptUtil;

public class TestScenario01_JSExecutor_FlashingOfAnElement {
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com");
		
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg1 = new File("C:\\Users\\admin\\Desktop\\Screenshot\\TestCase01-BeforeColorChange.jpg");
		FileUtils.copyFile(src1, trg1);
		WebElement joinfree = driver.findElement(By.xpath("//ul[@class='control-bar']//li[2]//a[1]"));
		JavaScriptUtil.flash(joinfree, driver);
		Thread.sleep(2000);
		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg2 = new File("C:\\Users\\admin\\Desktop\\Screenshot\\TestCase01-AfterColorChange.jpg");
		FileUtils.copyFile(src2, trg2);
		
		driver.quit();
		
	}
	
}
