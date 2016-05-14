package cn.selenium;

import org.testng.AssertJUnit;

 
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test public class TestDemoFrame {
	public WebDriver driver;
	public String BaseUrl="http://127.0.0.1:1080/WebTours/";
  public void Selenium() {
	 
	  driver=new FirefoxDriver();
	  driver.get(BaseUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	
	 /**/
	  List<WebElement> frames=driver.findElements(By.tagName("frame" ));
	  
	  for(WebElement frame:frames){
		  
		  driver.switchTo().frame("=="+frame);
		  System.out.println(frame);
		  if(driver.getPageSource().contains("username")){
			  WebElement FrameText=driver.findElement(By.name("username"));
			  FrameText.sendKeys("jojo");
			  AssertJUnit.assertEquals("Username", FrameText.getText());
			  break;
		  }else{
			  driver.switchTo().defaultContent();
		  }
	  }
	  driver.switchTo().defaultContent();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	//  driver=new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
  }

}