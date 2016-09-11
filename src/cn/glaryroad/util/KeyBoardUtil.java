package cn.glaryroad.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class KeyBoardUtil {

	 //��tab���ķ�װ����
	public static void pressTabKey(){
		Robot robot=null;
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//����keypress����ʵ�ְ���tab��
		robot.keyPress(KeyEvent.VK_TAB);
		//����keyPRealease����ʵ���ͷ�tab��
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	 //��Enter���ķ�װ����
		public static void pressEnterKey(){
			Robot robot=null;
			try {
				robot=new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			//����keypress����ʵ�ְ���Enter��
			robot.keyPress(KeyEvent.VK_ENTER);
			//����keyPRealease����ʵ���ͷ�tab��
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		/*
		 ��ָ���ַ�����Ϊ����������ݣ�Ȼ��ִ��ճ������
		 ��ҳ�潹���л��������󣬵��ô˺���key��ָ�����ַ���ճ�����������
		 */
		public static void setAndctrVClipboardData(String str){
			StringSelection stringSelection=new StringSelection(str);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot=null;
			try {
				robot=new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			//����4�д����ʾ���º��ͷ�Ctrl+v��ϼ�
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
 
