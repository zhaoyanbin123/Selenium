package cn.gloryroad.appModules;

import org.openqa.selenium.WebDriver;

import cn.gloryroad.pageObjects.LoginPage;

public class Login_Action {
	public static void execute(WebDriver driver,String userName,String passWord) throws Exception{
		driver.get("http://mail.126.com");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.userName().sendKeys("testman1978");
		loginPage.passWord().sendKeys("wulaoshi1978");
		loginPage.loginButton().click();
		Thread.sleep(5000);
		
	}
 
}
