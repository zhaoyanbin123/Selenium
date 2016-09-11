package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.glaryroad.util.ObjectMap;

public class LoginPage {

	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对路径
	private ObjectMap objectMap = new ObjectMap("");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 返回登录页面中的用户输入框页面元素对象
	public WebElement userName() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于用户名表达式的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("126mail.loginPage.username"));
		return element;
	}

	// 返回登录页面中的密码输入框页面元素对象
	public WebElement passWord() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于用户名表达式的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("126mail.loginPage.password"));
		return element;
	}

	// 返回登录页面中的密码输入框页面元素对象
	public WebElement loginButton() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于用户名表达式的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("126mail.loginPage.loginbutton"));
		return element;
	}
}
