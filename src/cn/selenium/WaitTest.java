package cn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest {
	
	WebDriver driver;
  @Test
  public void testwait() {
	  
	  //���õ���ʾ�ȴ�
	  //����һ��WebDriverWait �����趨������������ȴ�ʱ��Ϊ10��
	  
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  //����ExpectConditions��titleContains�����ж�ҳ��Title�����Ƿ����ˮ������
	  wait.until(ExpectedConditions.titleContains("ˮ��"));
	  System.out.println("��ҳ�������");
	  wait.until(ExpectedConditions.titleIs(""));//�ж�ҳ��title�Ƿ���ĳ����
	  
	  //��ȡ�����б��еġ����ӡ�ѡ�����
	  WebElement select=driver.findElement(By.id(""));
	  //����ExpectedConditions.elementToBeSelected();�����жϡ����ӡ��Ƿ��Ǵ���ѡ��״̬
	  
	  wait.until(ExpectedConditions.elementToBeSelected(select));
	  System.out.println("�����б��ѡ����תĽ�ݴ���ѡ��״̬");
	  /*
	   * ����ExpectedConditions.ElemntToBeClickable�����ж�
	   * ҳ��ĸ�ѡ������Ƿ�ɼ��������Ƿ�ɱ�����
	   * 
	   * */
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	  System.out.println("��ѡ������ʾ״̬�����ҿɱ�����");
	  //����ExpectedCpmditons.presenceOfElementLocated�����ж�һ����ǩ�����Ƿ���ҳ����
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@value='ii']")));
	  System.out.println("ҳ���input��ǩ����ʾ");
	  //����ExpectedConditions��textToBePresentInElement�����ж�p��ǩ�������Ƿ������dddd��
      //�⼸����
	  WebElement p=driver.findElement(By.xpath("//p"));
	  wait.until(ExpectedConditions.textToBePresentInElement(p,"ddd"));
	  System.out.println("ҳ��p��ǩԪ�ذ����ı�ddd");
	  
	  WebElement test=driver.findElement(By.id(""));
	  //�ж϶����ֵ�Ƿ�Ϊˮ��
	  wait.until(ExpectedConditions.textToBePresentInElementValue(test, "ˮ��"));
	  System.out.println("ֵ��ˮ��");
	  
	  //�ȴ�ĳ����ѡ�л�ȡ��ѡ��
	  
	 wait.until(ExpectedConditions.elementSelectionStateToBe(By.id(""),  true));
	 wait.until(ExpectedConditions.elementSelectionStateToBe(By.id(""),  false));
  }
 }
	  
	 /*
	    �����г����õ�waitFor����  ��(ide ����)

	    waitForElementPresent    locator    �ȴ�ֱ��ĳ��Ԫ����ҳ���д���
	     
	    waitForElementNotPresent   locator   �ȴ�ֱ��ĳ��Ԫ����ҳ���в�����
	     	
	    waitForTextPresent       text       �ȴ�ֱ��ĳ���ı���ҳ���д���
	    	  	
	     
	    waitForTextNotPresent    text      	�ȴ�ֱ��ĳ���ı���ҳ���в�����
	    
	    	
	    waitForText     locator   text   �ȴ�ֱ��locatorָ��Ԫ���ڵ��ı�����text
	     
	    	
	    waitForNotText    locator   text   	�ȴ�ֱ��locatorָ��Ԫ���ڵ��ı�������text
	    
	    waitForVisible   locator            �ȴ�ֱ��locatorָ��Ԫ����ҳ���пɼ�
	      
	    waitForNotVisible    locator        �ȴ�ֱ��locatorָ��Ԫ����ҳ���в��ɼ�
	     
	    waitForTitle      title      �ȴ�ֱ��ҳ����������ָ����title
	     
	    	
	    waitForNotTitle    title       �ȴ�ֱ��ҳ����ⲻ������ָ����title
	     
	    waitForLocation    url        �ȴ�ֱ��ҳ��ĵ�ַ������ָ����url
	     
	    	
	    waitForNotLocation  url       	�ȴ�ֱ��ҳ��ĵ�ַ��������ָ����url
	     
	    waitForValue    locator   value   �ȴ�ֱ��locatorָ����Ԫ�ص�valueֵ����ָ����ֵ
	   
	    waitForNotValue  locator  value   �ȴ�ֱ��locatorָ����Ԫ�ص�valueֵ������ָ����ֵ
	    
	    waitForAttribute   locator@attr  value  �ȴ�ֱ��locatorָ����Ԫ�ص�attr����ֵ����ָ����ֵ
	     
	    waitForNotAttribute locator@attr   value  �ȴ�ֱ��locatorָ����Ԫ�ص�attr����ֵ������ָ����ֵ
	    
	    waitForChecked   locator  �ȴ�ֱ��locatorָ����radio��checkbox��Ϊѡ��״̬
	     
	    waitForNotChecked  locator   �ȴ�ֱ��locatorָ����radio��checkbox��Ϊ��ѡ��״̬
	      
	    waitForEditable    locator   �ȴ�ֱ��locatorָ����input��textareaԪ�ؿɱ༭
	     
	    waitForNotEditable   locator  �ȴ�ֱ��locatorָ����input��textareaԪ�ز��ɱ༭
	      
	    waitForXpathCount   xpath   count   �ȴ�ֱ��ҳ�����xpath������Ϊcount
	     
	    waitForNotXpathCount  xpath  count   �ȴ�ֱ��ҳ�����xpath��������Ϊcount
	     
	    waitForEval   script   pattern    �ȴ�ֱ��script��ִ�н������pattern
	      
	    waitForNotEval  script  pattern   �ȴ�ֱ��script��ִ�н��������pattern 
	     
	   
	  */
 
