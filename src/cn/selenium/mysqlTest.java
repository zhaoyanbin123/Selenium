package cn.selenium;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
 
public class mysqlTest {
	// �����߼���
	// 1.���ѹ���ҳ
	// 2.��MySQL���ݿ��ж�ȡÿ����ǰ���е����Ĵ���Ϊ������������������ؼ���
	// 3.����������ť
	// 4.�����������ҳ���Ƿ�������ݿ���ÿ�еĵ������ʻ㣬��������Ϊ����ִ�гɹ���������Ϊ����ִ��ʧ��

	public WebDriver driver;
	String url = "http://www.sogou.com/";
	// ʹ��ע��DataProvider,�����Լ�����Ϊ��testData��
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		// �������еľ�̬���� getTestdata����ȡmysql���ݿ��еĲ�������
		return getTestData("testdate");//���ݿ����

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

		//�����ݿ���ÿ�����ݵ�ǰ����������Ϊ�����ʻ������£������������ҳ���Ƿ����ÿ���������еĵ���������
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
	
	public static Object[][] getTestData(String tablename) throws IOException{
		//����MySQL���ݵ�����
		String driver1="com.mysql.jdbc.Driver";
		//�����������ݿ��IP��ַ�����ݿ�����
		String URL="jdbc:mysql://localhost:3306/test";//localhost
		//�������ݿ���û�����Ϊ�����ݿ�Ȩ���趨�Ȳ��� ����ʹ��root�û����в���
		//����ʽ��������ɾ�����ݿ��У�����ʹ�÷�root���û��˻������Զ������Ե���ز���
		String user="root";
		//�������ݿ�root�û��ĵ�¼���룬���MySQL��װʱ�趨��root�û�����Ҫ����һ��
		String password="1234";
		//�����洢�������ݵ�list����
		List<Object[]> records=new ArrayList<Object[]>();
		try {
			//�趨����
			Class.forName(driver1);
			//�����������ݿ�����Ӷ���ʹ�����ݿ��������ַ�㣬�û�����������Ϊ����
			Connection conn=DriverManager.getConnection(URL,user,password);
			//������ݿ����ӿ����ã���ӡ���ݿ����ӳɹ�����Ϣ
			if (!conn.isClosed()) {
				System.out.println("�������ݿ�ɹ�");
				//����statement����
				
			}
			Statement statement=conn.createStatement();
			//ʹ�ú�������ƴ��Ҫִ�е�SQL��䣬�����������ȡ���ݱ������������
			String Sql="select * from "+tablename;
			//����һ��ResultSet���󣬴洢ִ��sql���󷵻ص����ݽ����
			ResultSet rs=statement.executeQuery(Sql);
			//����һ��ResultSetMetaData����
			ResultSetMetaData rsMetaData=rs.getMetaData();
			//����ResultSetMetaData�����getColumnCount������ȡ�����е�����
			int cols=rsMetaData.getColumnCount();
			//ʹ��next�����������ݽ����������������
			while (rs.next()) {
				//����һ���ַ������ݣ������Сʹ�������е��и�����������
				String fields[]=new  String [cols];
				int col=0;
				//���������������е����������ݣ����洢���ַ�������
				for (int colIdx = 0; colIdx < cols; colIdx++) {
					fields[col]=rs.getString(colIdx+1);
					col++;
			 
				}
				//��ÿһ�е����ݴ洢���ַ����ݺ󣬴洢��records��
				records.add(fields);
				//����������е�ǰ�������ݣ�������֤���ݿ������Ƿ���ȷȡ��
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"	"+rs.getString(3));
			 
			}
			//�ر����ݽ��������
			rs.close();
			//�ر����ݿ�����
			conn.close();
			
		} catch(ClassNotFoundException e){
			System.out.println("δ���ҵ�MySQL�����������࣡");
			e.printStackTrace();
		}catch (SQLException e1) {
			 
			e1.printStackTrace();
		}catch (Exception e2) {
			 e2.printStackTrace();
			 
			
		}
		//���庯������ֵ ����Object[][]
		//���洢�������ݵ�listת��Ϊһ��Object�Ķ�ά����
		Object[][] results=new Object[records.size()][];
		//���ö�ά����ÿ�е�ֵ��ÿ����һ��Object����
		for(int i=0;i<records.size();i++){
			results[i]=records.get(i);
			
		}
		return results;
			
	}
}
