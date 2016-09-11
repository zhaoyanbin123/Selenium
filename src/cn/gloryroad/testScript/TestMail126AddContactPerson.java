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
	// ����Constan���еĳ���Constant.url
	private String baseUrl = Constant.Url;

	// ����dataProvider,������Ϊtestdata
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
			Log.info("�����ϵ��ʧ��");
			/*
			 ִ��AddConstactPerson_action���execute����ʧ��ʱ��catch�����Բ���AssertionError���͵��쳣
			 ��������Excel�в�������ִ�е�ִ�н��Ϊ������ִ��ʧ�ܡ�������Excel�е���Ÿ�ʽ��Ĭ���趨Ϊ����һλС����
			 ����ʹ��spilt("[.]")[0]����ȡ��ŵ��������֣�������setCellData�����ڶ�Ӧ��ŵĲ��������е����һ���趨������ִ��ʧ�ܡ�*/
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "����ִ��ʧ��");
			Assert.fail("ִ��AddContactPerson_Action���execute����ʧ��");
			
			
		}
		Log.info("����AddContactPerson_Action���execute����������3��");
		Thread.sleep(3000);
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�������Ĺؼ���");
		try {
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonName));
			
		} catch (AssertionError error) {
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "����ִ��ʧ��");
			Assert.fail("����ͨѶ¼��ҳ���Ƿ������ϵ�������Ĺؼ���ʧ��");
		}
			 
		
		Thread.sleep(3000);
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�˵��������ַ�Ĺؼ���");
		try {
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonEmail));
			
		} catch (AssertionError error) {
			Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�˵��������ַ�Ĺؼ���ʧ��");
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "����ִ��ʧ��");
			Assert.fail("����ͨѶ¼��ҳ���Ƿ���������ʼ���ַ�Ĺؼ���ʧ��");
		}
		
		Thread.sleep(3000);
		try {
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonMobile));
			
		} catch (AssertionError error) {
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "����ִ��ʧ��");
			Assert.fail("����ͨѶ¼��ҳ���Ƿ������ϵ���ֻ��Ĺؼ���ʧ��");
			
		}
		
		Log.info("�½���ϵ�˵�ȫ�����Գɹ�����Excel�Ĳ��������ļ��ġ�����ִ�н��������д��ִ�гɹ�");
		
		ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNUm(), "����ִ�гɹ�");
		Log.info("���Խ���ɹ�д�����ִ�н������");
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

