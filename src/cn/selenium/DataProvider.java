package cn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvider {
	private static WebDriver driver;

	@org.testng.annotations.DataProvider(name = "serachWords")
	public static String[][] words() {

		return new String[][] { { "������", "����", "���˶�" }, { "����", "����", "����" },
				{ "����Σ��", "���", "����ɭ" } };

	}

	@Test(dataProvider = "serachWords")
	public void test(String searchword1, String searchword2, String searchresult) {
		driver = new FirefoxDriver();
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(
				searchword1 + "" + searchword2);
		driver.findElement(By.id("stb")).click();
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// �ж����������ҳ���Ƿ�������������������Ĺؼ���
		Assert.assertTrue(driver.getPageSource().contains(searchresult));
		driver.quit();

		/*
		   ���Խ���� PASSED: test("������", "����", "���˶�") PASSED: test("����", "����", "����")
		   PASSED: test("����Σ��", "���", "����ɭ")
		   ���Խű����Զ���������������ֱ��������鲻ͬ�Ĳ���������Ϊ�����ʽ��в�ѯ�� �������������Ľ�������Գɹ���
		  
		   @org.testng.annotations.DataProvider(name="serachWords") public
		   static String [][] words(){
		  
		   return new String [][]{{"������","����","���˶�"},
		   {"����","����","����"},{"����Σ��","���","����ɭ"}};
		   
		  ʹ�� @org.testng.annotations.DataProviderע�ⶨ�嵱ǰ�����еķ��ض�����Ϊ
		   ���Խű��Ĳ������ݼ������ҽ��������ݼ�����ΪsearchWords.
		   
		   @Test(dataProvider="serachWords") 
		   public void test(Stringsearchword1,String searchword2,String searchresult);
		   
		    ���������ʾ���Է����е����������ֱ�ʹ��searchWords�������ݼ��� ��ÿһ��һά�����е����ݽ��и�ֵ����
		    ���Է����ᱻ�������Σ��ֱ�ʹ�ò������ݼ��е���������
		 */

	}
}
