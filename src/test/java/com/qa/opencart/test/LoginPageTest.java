package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opecart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


// @Listeners({ExtentReportListeners.class, AnnotationTransformer.class})



@Epic("Epic 100 : design open cart login Page")
@Feature("feature 101 : Login feature")
@Story("story 120 : features related to login page")
@Owner("Pratik Automation")
public class LoginPageTest extends BaseTest {
	
	@Severity(SeverityLevel.MINOR)
	@Description("Login page title test")
	@Feature("Feature 400 : title test feature")
	@Test
	public void loginPageTitleTest() {
		String actualtitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Login page url test")
	@Feature("Feature 401 : url test feature")
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("forgot password test")
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("Login page logo test")
	@Test
	public void isLogoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("user is able to login test")
	@Test(priority = Integer.MAX_VALUE)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("emailId"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}

}
