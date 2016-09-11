package cn.gloryroad.testScript;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cn.glaryroad.util.*;
import cn.gloryroad.appModules.AddContactPerson_Action;

public class TestMail126AddContactPerson {

	public WebDriver driver;
	// 调用Constan类中的常量Constant.url
	private String baseUrl = Constant.Url;

	// 定义dataProvider,并命名为testdata
	@DataProvider(name="testdata")
	 public static Object[][] data() throws Exception{
		Log.startTestCase(ExcelUtil.getCellData(1, 0));
		 return ExcelUtil.getTestData(Constant.TestDataExcelFilePath, Constant.TestDataExcelFileSheet);
		 
	}
	@Test(dataProvider="testData")
	public void testAddressBook(String CaseRowNumber,String testCaseName, String mailUserName,String mailPassWord,String contactPersonName,
	 String contactPersonEmail,String contactPersonMobile,String assertContactPersonName,String assertContactPersonEmail,String assertContactPersonMobile)
		 throws Exception{
		driver.get(baseUrl);
		try {
			AddContactPerson_Action.execute(driver, mailUserName, mailPassWord, contactPersonName, contactPersonEmail, contactPersonMobile);
			
		} catch (AssertionError error) {
			Log.info("添加联系人失败");
			/*
			 执行AddConstactPerson_action类的execute方法失败时，catch语句可以捕获AssertionError类型的异常
			 ，并设置Excel中测试数据执行的执行结果为“测试执行失败”，由于Excel中的序号格式被默认设定为带有一位小数，
			 所以使用spilt("[.]")[0]语句获取序号的整数部分，并传给setCellData函数在对应序号的参数数据行的最后一列设定“测试执行失败”*/
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "测试执行失败");
			Assert.fail("执行AddContactPerson_Action类的execute方法失败");
			
			
		}
		Log.info("调用AddContactPerson_Action类的execute方法后，休眠3秒");
		Thread.sleep(3000);
		Log.info("断言通讯录的页面是否包含联系人姓名的关键字");
		try {
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonName));
			
		} catch (AssertionError error) {
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "测试执行失败");
			Assert.fail("断言通讯录的页面是否包含联系人姓名的关键字失败");
		}
			 
		
		Thread.sleep(3000);
		Log.info("断言通讯录的页面是否包含联系人电子邮箱地址的关键字");
		try {
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonEmail));
			
		} catch (AssertionError error) {
			Log.info("断言通讯录的页面是否包含联系人电子邮箱地址的关键字失败");
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "测试执行失败");
			Assert.fail("断言通讯录的页面是否包含电子邮件地址的关键字失败");
		}
		
		Thread.sleep(3000);
		try {
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonMobile));
			
		} catch (AssertionError error) {
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "测试执行失败");
			Assert.fail("断言通讯录的页面是否包含联系人手机的关键字失败");
			
		}
		
		Log.info("新建联系人的全部断言成功，在Excel的测试数据文件的“测试执行结果”列中写入执行成功");
		
		ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "测试执行成功");
		Log.info("测试结果成功写入测试执行结果列中");
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

