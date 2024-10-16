package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opecart.base.BaseTest;

public class ProductDetailsPageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void productDetailsSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	@Test
	public void productHeaderTest() {
		resultsPage = accPage.doSearch("macbook");
		detailsPage = resultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(detailsPage.getProductHeader(), "MacBook Pro");
	}
	
	@Test
	public void productInfoTest() {
		resultsPage = accPage.doSearch("macbook");
		detailsPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductDataMap = detailsPage.getProductData();
		
		softAssert.assertEquals(actProductDataMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductDataMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductDataMap.get("Reward Points"), "800");
		softAssert.assertEquals(actProductDataMap.get("Availability"), "In Stock");
		softAssert.assertEquals(actProductDataMap.get("productprice"), "$2,000.00");
		softAssert.assertEquals(actProductDataMap.get("extaxprice"), "$2,000.00");
		softAssert.assertAll();
	}
	
	@DataProvider
	public Object[][] getProductImagesCountData() {
		return new Object[][] {
			{"macbook", "MacBook Pro", 4},
			{"imac", "iMac", 3},
			{"samsung", "Samsung SyncMaster 941BW", 1},
			{"samsung", "Samsung Galaxy Tab 10.1", 7},
			{"canon","Canon EOS 5D", 3}
		};
	}

	@Test(dataProvider = "getProductImagesCountData")
	public void productImagesCountTest(String searchKey, String productName, int imagesCount) {
		resultsPage = accPage.doSearch(searchKey);
		detailsPage = resultsPage.selectProduct(productName);
		Assert.assertEquals(detailsPage.getProductImagesCount(), imagesCount);  
	}

}
