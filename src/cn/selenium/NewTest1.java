package cn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
	public WebDriver driver;
	String url1="http://www.sougou.com";
	String url2="http://www.baidu.com";
  @Test
  public void Test() {
	  WebDriver driver=new FirefoxDriver();
	  //������һ�����ʵ���ҳ
	  driver.navigate().to(url1);//�ȷ����ѹ���ҳ
	  driver.navigate().to(url2);//����ת���ٶ���ҳ
	  driver.navigate().back();//���ص���һ�η��ʵ��ѹ���ҳҳ��
	  //���ϴη�����ҳҳ��ǰ������һ����ҳ
	  driver.navigate().forward(); //���ѹ���ҳ��ת���ٶ���ҳ
	  
	  //ˢ�µ�ǰ��ҳ
	  driver.navigate().refresh();//ˢ�µ�ǰ��ҳ
	  
	  //��ȡҳ���title����
	  String title=driver.getTitle();
	  System.out.println(title);
	  //����ҳ���title�Ƿ��ǰٶ�һ�£����֪��
	  Assert.assertEquals("�ٶ�һ�£����֪��", title);
	  
	  //��ȡҳ���Դ��
	  String pageSource=driver.getPageSource();
	  System.out.println(pageSource);//��ӡԴ��
	  //����ҳ��Ĵ������Ƿ��С���ա��ؼ��֣��Դ��ж�ҳ�������Ƿ���ȷ
	   Assert.assertTrue(pageSource.contains("���"));
	   //��ȡ��ǰ��ҳ��URL
	   String  url=driver.getCurrentUrl();
	   System.out.println(url);
	   
	   //˫����ĳһԪ��
	   WebElement inputbox=driver.findElement(By.id("inputbox11"));
	   Actions builder=new Actions(driver);
	   //ʹ��doubleClick �����������Ԫ���н������˫������
	   builder.doubleClick(inputbox).build().perform();
	   
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
