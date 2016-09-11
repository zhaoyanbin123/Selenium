package cn.glaryroad.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	 public static void sleep(long millisecond){
		 try{
			 Thread.sleep(millisecond);
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	 }
	 
	 public static void waitWebElement(WebDriver driver,String xpathExpression){
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
	 }
	 
	 //显示等待页面元素出现的封装方法，参数表示元素的by对象，此函数可以支持更多的定位表达式
	 public static void waitWebElement(WebDriver driver,By by){
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(by));
	 }
}
