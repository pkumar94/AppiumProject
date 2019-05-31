package com.tourisz.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tourisz.Flows.LoginFlow;
import com.tourisz.Reporting.Report_Setup;
import com.tourisz.Utilities.Common_Functions;
import com.tourisz.Utilities.WrapperMethods;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login_Test extends Common_Functions {
	public AndroidDriver<MobileElement> driver;
	WrapperMethods method = new WrapperMethods();

	@Parameters({ "tcID"})
	@Test
	public void TC_04_Login(String TestCase_ID) throws Throwable {
		try {
			Common_Functions fun = new Common_Functions();
			LoginFlow page_Login = new LoginFlow();
			Report_Setup setup = new Report_Setup();
			setup.InitializeReport(TestCase_ID);
			driver = fun.setUp();
			fun.startRecording();
			page_Login.logintoApplication(driver, TestCase_ID);
			System.out.println("login passed");
			Report_Setup.extent.endTest(Report_Setup.test);
			Report_Setup.extent.flush();
		} catch (Exception e) {
			Report_Setup.extent.endTest(Report_Setup.test);
			Report_Setup.extent.flush();
			System.out.println("TC_04_Login failed");

		}

	}
}
