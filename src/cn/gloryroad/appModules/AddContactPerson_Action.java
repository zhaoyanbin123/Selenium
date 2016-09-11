package cn.gloryroad.appModules;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import cn.gloryroad.pageObjects.HomePage;
import cn.gloryroad.pageObjects.addressBookPage;

public class AddContactPerson_Action {

	 public static void execute(WebDriver driver,String userName,String password
			 ,String contactName,String contactEmail,String contactMobile)throws Exception{
		 Login_Action.execute(driver, userName, password);
		 Thread.sleep(3000);
		 Assert.assertTrue(driver.getPageSource().contains("Î´¶ÁÓÊ¼þ"));
		 HomePage homepage=new HomePage(driver);
		 homepage.addressLink().click();
		 addressBookPage addressBookPage=new addressBookPage(driver);
		 Thread.sleep(3000);
		 addressBookPage.createContactPersonButton().click();
		 Thread.sleep(3000);
		 addressBookPage.createPersonName().sendKeys(contactName);
		 addressBookPage.createPersonEmail().sendKeys(contactEmail);
		 addressBookPage.createPersonMoblie().sendKeys(contactMobile);
		 addressBookPage.saveButton().click();
		 Thread.sleep(3000);

		 
		 
		 
		 
	 }

}
