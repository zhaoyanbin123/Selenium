package cn.gloryroad.testScript;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cn.gloryroad.appModules.Login_Action;
import cn.gloryroad.pageObjects.LoginPage;

public class TestMail126Login {
	public WebDriver driver;
	String baseUrl="http://mail.126.com/";
	@Test
	public void testMailLogin() throws Exception{
		driver.get(baseUrl+"/");
		Login_Action.execute(driver, "testman1978", "wulaoshi1978");
		 
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("Î´¶ÁÓÊ¼þ"));
		
	}
	@BeforeMethod
	public void beforeMethod(){
		System.setProperty("Webdriver.firefox.bin","c:\\Program File (X86)\\MozillaFirefox\\firefox.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	
 

}
