package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opecart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.staticMethods.Search;

public class AccountsPageTest extends BaseTest{

	
	/**
	 * This method is specific pre-condition only for AccountsPageTest.
	 * 
	 */
	@BeforeClass
	public void accSetUp() {
		accPage =  loginPage.doLogin(prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest() {
		String actualtitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageHeadersCountTest() {
		Assert.assertEquals(accPage.getTotalAccountsPageHeader(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.EXPECTED_ACCOUNT_PAGE_HEADERS_LIST);
	}
	
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook", 3},
			{"imac", 1},
			{"samsung", 2}	
		};
	}
	
	@Test(priority = Integer.MAX_VALUE-1, dataProvider = "getSearchKey")
	public void searchCountTest(String searchKey, int expectedCount) {
		resultsPage = accPage.doSearch(searchKey);
		Assert.assertEquals(resultsPage.getSearchResultsCount(), expectedCount);
	}
	
	
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"macbook","MacBook Pro"},
			{"imac", "iMac"},
			{"macbook", "MacBook Air"},
			{"samsung", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1"}	
		};
	}
	
	@Test(priority = Integer.MAX_VALUE, dataProvider = "getSearchData")
	public void SearchTest(String searchKey, String productName) {
		resultsPage = accPage.doSearch(searchKey);
		detailsPage = resultsPage.selectProduct(productName);
		Assert.assertEquals(detailsPage.getProductHeader(), productName);
	}
	
//	@Test
//	public void doSearchfromPDP() {
//		Search.doSearch("")
//	}
}
