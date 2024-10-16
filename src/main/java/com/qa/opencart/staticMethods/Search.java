package com.qa.opencart.staticMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.utils.ElementUtil;

public class Search {
	
	static WebDriver driver;
	static ElementUtil eleUtil;
	
	static By search = By.name("search");
	static By searchIcon = By.cssSelector("div#search button");
	
	
	public Search(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public static SearchResultsPage doSearch(String searchKey) {
		eleUtil.doSendKeys(search, searchKey, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
	}

}
