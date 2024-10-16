package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opecart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	
	public String getRandomEmail() {
		return "uiautomation" + System.currentTimeMillis() + "@gmail.com";
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		return new Object[][] {
			{"Pratik","Truth","9999999999","Admin@123","yes"},
			{"Rahul","Arora","7777777777","Admin@123","no"},
			{"Veena","Pushpa","8888888888","Admin@123","no"},
			{"Tom","Cruise","5555555555","Admin@123","yes"},
			{"Manisha","Well","3333333333","Admin@123","no"}
		};
	}
	
	
	@DataProvider
	public Object[][] getRegData() {
		return ExcelUtil.getTestData(AppConstants.REG_SHEET_NAME);
	}
	
	
	
	@Test(dataProvider = "getRegData")
	public void registerUserTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		regPage = loginPage.doNavigateToRegisterPage();
		Assert.assertTrue(regPage.registerUser(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
	}
	
	
	
}
