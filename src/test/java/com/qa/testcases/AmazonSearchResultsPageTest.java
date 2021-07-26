package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AmazonSearchResultsPage;
import com.qa.pages.AmazonLandingPage;
import com.qa.pages.AmazonCartPage;

public class AmazonSearchResultsPageTest extends TestBase {
	AmazonLandingPage AmazonLandingPage;
	AmazonSearchResultsPage AmazonSearchResultsPage;
	AmazonCartPage AmazonCartPage;

	public AmazonSearchResultsPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		intialization();
		AmazonLandingPage = new AmazonLandingPage();
		AmazonSearchResultsPage = new AmazonSearchResultsPage();
		AmazonCartPage = new AmazonCartPage();
		driver.get(prop.getProperty("AmazonURL"));
		AmazonLandingPage.enterProductName(prop.getProperty("ProductName"));
		AmazonSearchResultsPage = AmazonLandingPage.clickSearch();

	}

	@Test(priority = 1)
	public void clickProductAndPrintPrice() throws InterruptedException, IOException {

		Double priceFlipkart = AmazonSearchResultsPage.printPrice();
		System.out.println("Price of First Product in Amazon is: " + "Rs." + priceFlipkart);
		AmazonSearchResultsPage.clickFirstItem();
		AmazonSearchResultsPage.switchTab();
		AmazonSearchResultsPage.addProductToCart();
		driver.navigate().refresh();
		Thread.sleep(5000);
		AmazonSearchResultsPage.clickOnCartIcon();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
