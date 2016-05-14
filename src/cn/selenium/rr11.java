package cn.selenium;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class rr11 {
	
	public WebElement driver;
	public void SelectTest(){
		
		//���������б�
		Select select=new Select(driver.findElement(By.id("XXX")));//��λ�����б�
		select.isMultiple();//��ʾ�������б��Ƿ������ѡ,���������ҳ�������б���һ�����������б�
		//�˺������ؽ��Ϊfalse
		Assert.assertFalse(select.isMultiple());//�����Ƿ�Ϊfalse
		select.getFirstSelectedOption().getText();//������ʾ��ȡ��ǰ��ѡ�е������б�ѡ����ı�
		Assert.assertEquals("VVV", select.getFirstSelectedOption().getText());
		//���Ե�ǰ��ѡ��������б��Ƿ�Ϊvvv
		select.selectByIndex(0);//ͨ�������б�ѡ����±�ѡ�� ��0��ʼ
		select.selectByValue("");//ͨ�������б�ѡ���valueֵѡ��
		select.selectByVisibleText("");//ͨ�������б�ѡ����ı�ѡ��
		
		
		//��������б��ѡ�������Ƿ��������
		/*
		 �ȶ�λ�����б�����ͬ��
		����һ��list����  �洢�����б��������������ֵ�����ѡ�����ͨ������<String>�޶�list����
		�еĴ洢����ʱstring
		Arrays.asList ��ʾ��һ������ת����һ��list����
		
		 
		 */
		
		Select droplist=new Select(driver.findElement(By.id("xxx")));
		List<String> except_option=Arrays.asList((new String[]{"xx","xxx","xxxx"}));
		//����һ���µ�list�������ڴ洢��ҳ���ϻ�ȡ������ѡ������
		List<String> actual_option=new ArrayList<String>();
		 for(WebElement option: droplist.getOptions()){
			 //droplist.getOptions();�������ڻ�ȡҳ���������б��е�����ѡ�����
	
			 actual_option.add(option.getText());
			 //actual_options.add(option.getText());�������ڽ�ʵ�ʴ򿪵�
			 //��ÿ��ѡ����ӵ�actual_option�б���
			 
			 /*
			    toArray()��JAVA��������ʹ��ArrayListʱ����ʱ����һ��ʵ�ʵ����飬
			 �������������б�����ݡ�����ͨ�����÷���toArray()��ʵ�֡���actual_optionֱ��תΪObject[] ����
			 
			 toString ��������һ�������ı���ʽ��ʾ���˶�����ַ���
			 */
		 }
		 
		 Assert.assertEquals(except_option.toString(), actual_option.toArray());
		
	}
}
