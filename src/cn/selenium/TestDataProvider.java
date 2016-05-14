package cn.selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class TestDataProvider {

	// �����߼���
	// 1.���ѹ���ҳ
	// 2.��csv�ļ��ж�ȡÿ����ǰ��ÿ�����ŷָ������Ĵ���Ϊ������������������ؼ���
	// 3.����������ť
	// 4.�����������ҳ���Ƿ����csv�ļ���ÿ�еĵ������ʻ㣬��������Ϊ����ִ�гɹ���������Ϊ����ִ��ʧ��

	public WebDriver driver;
	String url = "http://www.sogou.com/";

	// ʹ��ע��DataProvider,�����Լ�����Ϊ��testData��
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		// �������еľ�̬���� getTestdata����ȡcsv�ļ��Ĳ�������
		return getTestData("E:\\", "testData.xlsx", "Sheet1");//ע��Excel�ļ���sheet�����Ƿ�ΪSheet1

	}

	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1, String searchWord2,
			String searchResult) {

		driver.get(url + "/");
		driver.findElement(By.id("query")).sendKeys(
				searchWord1 + "" + searchWord2);
		driver.findElement(By.id("stb")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			// @Override������������仰�±ߵķ����Ǽ̳и���ķ��������串��
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("s_footer")).getText()
						.contains("��������");
			}

		});

		// ��Excel�ļ�ÿ�е�ǰ2����Ԫ��������Ϊ�����ʻ������£������������ҳ���Ƿ����Excel�ļ�ÿ���е�������Ԫ�����ݵĹؼ���
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

	// ��Excel�ļ���ȡ�������ݵľ�̬����
	
	public static Object[][] getTestData(String filePath, String fileName,
			String sheetName) throws IOException {
		// ���ݲ�������������ļ�·�����ļ����ƣ���ϳ�Excel�����ļ��ľ���·��
		// ����һ��file�ļ�����
		File file=new File(filePath+"\\"+fileName);
		//����FileInputStream�������ڶ�ȡExcel�ļ�
		FileInputStream inputStream=new FileInputStream(file);
		//����Workbook����
		Workbook Workbook = null;
		// ��ȡ�ļ�����������չ�����ж���.xlsx�ļ�����.xls�ļ�
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// �ж��ļ����������.xlsx����ʹ��XSSFWorkbook�������ʵ����
		// �ж��ļ����������.xls,��ʹ��SSFWorkbook�������ʵ����
		if (fileExtensionName.equals(".xlsx")) {
			Workbook = new XSSFWorkbook(inputStream);

		} else if (fileExtensionName.equals(".xls")) {
			Workbook = new HSSFWorkbook(inputStream);

		}

		// ͨ��sheetName����������Sheet����
		Sheet Sheet = Workbook.getSheet(sheetName);
		// ��ȡExcel�ļ�sheet1�����ݵ�������getLastRowNum������ȡ���ݵ����һ���к�
		// getFirstRowNum������ȡ���ݵĵ�һ���кţ����֮��������ݵ�����
		// ע�⣺Excel�ļ����кź��кŶ��Ǵ�0��ʼ��
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		 
		// ������Ϊrecords��list�������洢��Excel�����ļ���ȡ������
		List<Object[]> records = new ArrayList<Object[]>();
		// ʹ������forѭ������Excel�����ļ����������ݣ������˵�һ�У���һ�������������ƣ�
		// ����i��1��ʼ�������Ǵ�0��ʼ
		for (int i = 1; i <rowCount+1 ; i++) {//rowCount+1
			// ʹ��getRow������ȡ�ж���
			Row row = Sheet.getRow(i);
			// ����һ�����飬�����洢Excel�����ļ�ÿ���е�3�����ݣ�����Ĵ�С��
			// getLastCellNum�취�����ж�̬������ʵ�ֲ������ݸ����������С��һ��
			String fileds[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// ����getCell��getStringCellValue������ȡExcel�ļ��еĵ�Ԫ������
				fileds[j] = row.getCell(j).getStringCellValue();

			}
			// ��fileds�����ݶ���洢��records��list��
			records.add(fileds);

		}
		// ���庯������ֵ����Object[][]
		// ���洢�������ݵ�listת��Ϊһ��Object�Ķ�ά����
		Object[][] results = new Object[records.size()][];
		// ���ö�ά����ÿ�е�ֵ��ÿ����һ��Object����
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);

		}
		return results;
	}

}
