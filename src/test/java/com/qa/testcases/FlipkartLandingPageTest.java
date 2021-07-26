package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlipkartLandingPage;
import com.qa.pages.FlipkartSearchResultsPage;

public class FlipkartLandingPageTest extends TestBase {

	FlipkartLandingPage FlipkartLandingPage;
	FlipkartSearchResultsPage FlipkartSearchResultPage;

	public FlipkartLandingPageTest() {
		super(); // Calling Test Base Class Constructor

	}

	@BeforeMethod
	public void Setup() throws IOException {
		intialization();
		FlipkartLandingPage = new FlipkartLandingPage();

	}

	@Test(priority = 1)
	
	public void enterProduct() throws InterruptedException, IOException {
		FlipkartLandingPage.clearLoginPopUp();
		FlipkartLandingPage.enterProductName(prop.getProperty("ProductName"));
		FlipkartSearchResultPage = FlipkartLandingPage.clickSearch();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
