package cn.glaryroad.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class KeyBoardUtil {

	 //按tab健的封装方法
	public static void pressTabKey(){
		Robot robot=null;
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//调用keypress方法实现按下tab健
		robot.keyPress(KeyEvent.VK_TAB);
		//调用keyPRealease方法实现释放tab键
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	 //按Enter健的封装方法
		public static void pressEnterKey(){
			Robot robot=null;
			try {
				robot=new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			//调用keypress方法实现按下Enter健
			robot.keyPress(KeyEvent.VK_ENTER);
			//调用keyPRealease方法实现释放tab键
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		/*
		 将指定字符串设为剪贴板的内容，然后执行粘贴操作
		 将页面焦点切换到输入框后，调用此函数key将指定的字符串粘贴到输入框中
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
			//以下4行代码表示按下和释放Ctrl+v组合键
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
 
