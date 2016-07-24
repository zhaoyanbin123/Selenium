package com.glen.demo;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class ContactsTest {
	private AndroidDriver driver;

	@Before
	public void setUp() throws Exception {
		// ����apk��·��
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "Apps");
		File app = new File(appDir, "app-bug.apk");
		// �����Զ�����ز���
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		// ���ð�׿ϵͳ�汾
		capabilities.setCapability("platformVersion", "4.4");
		// ����apk·��
		capabilities.setCapability("app", app.getAbsolutePath());
		// ����app����������������
		capabilities.setCapability("appPackage", "com.lthealth.iwo");
		capabilities.setCapability("appActivity",
				"com.lthealth.iwo.ui.activity.third.SplashActivity");
         //��������������������appium �����в鿴
		// ��ʼ��
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@Test
	public void addContact() {
		for (int i = 0; i < 3; i++) {
			driver.swipe(787, 1245, 200, 0, 800);

		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}