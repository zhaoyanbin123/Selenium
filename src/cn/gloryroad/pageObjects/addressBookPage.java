package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.glaryroad.util.ObjectMap;

public class addressBookPage {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap("");//配置文件绝对路径
	private WebDriver driver;
	public addressBookPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	//获取新建联系人页面中的确定按钮
			public WebElement createContactPersonButton() throws Exception{
				 element=driver.findElement(objectMap.getLocator("126mail.Addresspage.createContactPersonButton"));
				 return element;
				  
			}
	//获取新建联系人页面中的电子邮件输入框
	public WebElement createPersonEmail() throws Exception{
		 element=driver.findElement(objectMap.getLocator("126mail.homepage.Email"));
		 return element;
		  
	}
	//获取新建联系人页面中手机号输入框
		public WebElement createPersonMoblie() throws Exception{
			 element=driver.findElement(objectMap.getLocator("126mail.homepage.Moblie"));
			 return element;
			  
		}
		//获取新建联系人页面中的姓名输入框
		public WebElement createPersonName() throws Exception{
			 element=driver.findElement(objectMap.getLocator("126mail.homepage.addressbook"));
			 return element;
			  
		}
		//获取新建联系人页面中的确定按钮
		public WebElement saveButton() throws Exception{
			 element=driver.findElement(objectMap.getLocator("126mail.homepage.saveButton"));
			 return element;
			  
		}

}
