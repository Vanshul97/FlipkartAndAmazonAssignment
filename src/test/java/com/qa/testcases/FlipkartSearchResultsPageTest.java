package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlipkartCartPage;
import com.qa.pages.FlipkartLandingPage;
import com.qa.pages.FlipkartSearchResultsPage;

public class FlipkartSearchResultsPageTest extends TestBase {
	FlipkartLandingPage FlipkartLandingPage;
	FlipkartSearchResultsPage FlipkartSearchResultsPage;
	FlipkartCartPage FlipkartCartPage;

	public FlipkartSearchResultsPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		intialization();
		FlipkartLandingPage = new FlipkartLandingPage();
		FlipkartSearchResultsPage = new FlipkartSearchResultsPage();
		FlipkartLandingPage.clearLoginPopUp();
		FlipkartLandingPage.enterProductName(prop.getProperty("ProductName"));
		FlipkartSearchResultsPage = FlipkartLandingPage.clickSearch();

	}

	@Test(priority = 1)
	public void clickProductAndPrintPrice() throws InterruptedException, IOException {

		FlipkartSearchResultsPage.clickFirstItem();
		FlipkartSearchResultsPage.switchTab();
		int priceFlipkart = FlipkartSearchResultsPage.printPrice();
		System.out.println("Price of First Product is: " + "Rs."+priceFlipkart);
		FlipkartSearchResultsPage.addProductToCart();
//		Thread.sleep(10000);
//		FlipkartCartPage = FlipkartSearchResultsPage.clickOnCartIcon();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
