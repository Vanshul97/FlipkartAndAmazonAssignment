package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.AmazonSearchResultsPage;
import com.qa.pages.AmazonLandingPage;

import com.qa.base.TestBase;

public class AmazonLandingPageTest extends TestBase {

	AmazonLandingPage AmazonLandingPage;
	AmazonSearchResultsPage AmazonSearchResultsPage;

	public AmazonLandingPageTest() {
		super();

	}

	@BeforeMethod
	public void Setup() throws IOException {
		intialization();
		AmazonLandingPage = new AmazonLandingPage();
		driver.get(prop.getProperty("AmazonURL"));

	}

	@Test(priority = 1)

	public void enterProduct() throws InterruptedException, IOException {
		AmazonLandingPage.enterProductName(prop.getProperty("ProductName"));
		AmazonSearchResultsPage = AmazonLandingPage.clickSearch();

	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
