package com.tourisz.Flows;

import com.tourisz.Locators.LoginPage_Locators;
import com.tourisz.Reporting.Extent_Reporting;
import com.tourisz.Utilities.Excel_Handling;
import com.tourisz.Utilities.WrapperMethods;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginFlow 
{
	AndroidDriver<MobileElement> driver;
	WrapperMethods method = new WrapperMethods();
	public void logintoApplication(AndroidDriver<MobileElement> driver, String TC_ID) throws Exception
	{
		try {
			method.inputTextByID(driver, LoginPage_Locators.username_TextField, Excel_Handling.Get_Data(TC_ID, "username"), "entering username");
			method.inputTextByID(driver, LoginPage_Locators.password_TextField, Excel_Handling.Get_Data(TC_ID, "password"), "entering password");
			driver.hideKeyboard();
			method.Clickbtn(driver, LoginPage_Locators.login_Button, "clicking on login button");
			Extent_Reporting.Log_Pass_with_Screenshot("Login", "login sucessfully", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("cathc block of  login is executed");
			Extent_Reporting.Log_Fail("Login", "login unsucessfull", driver);
		}
	}

}
