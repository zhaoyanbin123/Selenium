package cn.selenium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideTest {
 
	
//�����߼���
//1.���ѹ���ҳ
//2.��csv�ļ��ж�ȡÿ����ǰ��ÿ�����ŷָ������Ĵ���Ϊ������������������ؼ��� 
//3.����������ť 
//4.�����������ҳ���Ƿ����csv�ļ���ÿ�еĵ������ʻ㣬��������Ϊ����ִ�гɹ���������Ϊ����ִ��ʧ��
	 

	public WebDriver driver;
	String url = "http://www.sogou.com/";

	// ʹ��ע��DataProvider,�����Լ�����Ϊ��testData��
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		// �������еľ�̬���� getTestdata����ȡcsv�ļ��Ĳ�������
		return getTestData("d:\\testData.csv");

	}

	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1, String searchWord2,
			String searchResult) {

		driver.get(url + "/");
		driver.findElement(By.id("query")).sendKeys(
				searchWord1 + "" + searchWord2);
		driver.findElement(By.id("stb")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(new ExpectedCondition<Boolean>() {
			@Override
			//@Override������������仰�±ߵķ����Ǽ̳и���ķ��������串��
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("s_footer")).getText()
						.contains("��������");
			}

		});

		// csv�ļ�ÿ��ǰ�����ʻ���Ϊ�����ʻ������£������������ҳ���Ƿ����csv�ļ�ÿ���е����һ���ʻ�Ĺؼ���
		Assert.assertTrue(driver.getPageSource().contains(searchResult));

		 

	}

	@BeforeMethod
	public void before() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	// ��ȡcsv�ļ��ľ�̬������ʹ��csv�ļ��ľ����ļ�·����Ϊ��������
	private static Object[][] getTestData(String fileName) throws IOException {
		List<Object[]> records = new ArrayList<Object[]>();
		String record;
		// �趨UTF-8�ַ�����ʹ�ô����������ַ�������BufferedReader��ȡ�ļ�����
		BufferedReader file = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		// ���Զ�ȡcsv�ļ��ı����У���һ�У�
		file.readLine();
		
		//������ȡ�ļ��г���һ������������������ݣ� ���洢����Ϊrecords�Ķ���Ϊһ��String����
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);

		}
		file.close();// �ر��ļ�����
		// ���庯������ֵ����Object[][]
		// ���洢�������ݵ�listת��Ϊһ��object�Ķ�ά����
		Object[][] results = new Object[records.size()][];
		// ���ö�ά����ÿ�е�ֵ��ÿ����һ��Object����
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);

		}
		return results;
	}
}
