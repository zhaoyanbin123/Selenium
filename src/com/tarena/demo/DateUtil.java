package com.tarena.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// ʱ�䣺Date��ù����࣬������ʱ����и��ֲ���
	// Date����: ��ʾ��ǰ��ϵͳʱ��
	// SimpleDateFormat:����ʱ��ĸ�ʽ
	// ���췽����SimpleDateFormat(��ʽ)
	// ��ʽ�� yyyy-MM-dd / yyyy-MM-dd HH:mm:ss
	// ������format(date);
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println("��ǰϵͳ��ʱ���ǣ�" + date1);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String message = dateFormat.format(date1);
		System.out.println("�޸ĺ��ϵͳʱ�䣺" + message);

		/*  SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
		  //�����̨�����ʱ�䣬һ��Ҫת����Ӧ��String
		  
		  String message =teFormat.format(date1);
		  System.out.println("�޸ĺ�ĵ�ǰʱ�䣺"
		  +message);*/

	}
}
