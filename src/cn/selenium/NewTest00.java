package cn.selenium;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class NewTest00 {
  @Test
  public void f() {
	  System.out.println("����һ������");
	  Reporter.log("���÷���һ");
  }
  @Test
  public void g(){
	  System.out.println("������������");
	  Reporter.log("���÷�����");
	  
  }
  @Test
  public void h(){
	  System.out.println("������������");
	  Reporter.log("���÷�����");
  }
}
