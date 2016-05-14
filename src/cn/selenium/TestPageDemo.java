package cn.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPageDemo {
	
	WebDriver driver;
	String url="https://www.baidu.com/";
	
	 //     ===�ж�ҳ��Ԫ���Ƿ����===
	  //����һ���ж�ҳ��Ԫ���Ƿ���ڵĺ�����isElementPresent
	private boolean IsElementPresent(By by){
		try{
			//���ʹ�ô���Ĳ���by �ҵ�ҳ��Ԫ�أ���������true����ʾ�ɹ����ҵ�ҳ��Ԫ�أ�
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e){
			//�������Ĳ���byû���ҵ�ҳ��Ԫ�أ���������false����ʾû�гɹ����ҵ�ҳ��Ԫ��
			return false;
			
		}
		
	}
  @Test
  public void Testpage() {
	  
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  //����IsElementPresent��������ҳ��idΪkw��ҳ��Ԫ�ض���
	  if(IsElementPresent(By.id("kw"))){
		  //����ɹ���λ��ҳ��Ԫ�أ����ҳ��Ԫ�ض���洢��search������
		  WebElement search=driver.findElement(By.id("kw"));
		  
		  if(search.isEnabled()){
			  //�ж�search���������Ƿ��ڿ���״̬��������ã����ı���������Selenium
			  search.sendKeys("Selenium");
			  
		  }
		  
	  }else{
		  //������������û�б��ҵ�����Ὣ����������Ϊfail������ӡʧ��ԭ��
		  Assert.fail("�����û�б��ҵ�");
	  
	  }
	  
	 
	  
  }
  @BeforeMethod
  public void Before(){
	  
	  driver=new FirefoxDriver();
  }
  @AfterMethod
  public void After(){
	  driver.quit();
  }
 
}
