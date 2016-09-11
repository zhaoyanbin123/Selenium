package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.glaryroad.util.ObjectMap;

public class HomePage {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap("");
	private WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		
	}
	//获取登录后主页中的“通讯录”连接
	public WebElement addressLink() throws Exception{
		 element=driver.findElement(objectMap.getLocator("126mail.homepage.addressbook"));
		 return element;
		 //如果要在HomePage页面操作更多的连接或元素，可以根据自定义
	}
 

}
