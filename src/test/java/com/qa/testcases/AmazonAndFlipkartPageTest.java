package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AmazonCartPage;
import com.qa.pages.AmazonLandingPage;
import com.qa.pages.AmazonSearchResultsPage;
import com.qa.pages.FlipkartCartPage;
import com.qa.pages.FlipkartLandingPage;
import com.qa.pages.FlipkartSearchResultsPage;

public class AmazonAndFlipkartPageTest extends TestBase {
	FlipkartLandingPage FlipkartLandingPage;
	FlipkartSearchResultsPage FlipkartSearchResultsPage;
	FlipkartCartPage FlipkartCartPage;
	AmazonLandingPage AmazonLandingPage;
	AmazonSearchResultsPage AmazonSearchResultsPage;
	AmazonCartPage AmazonCartPage;
	double flipkartTotalAmount;
	double amazonTotalAmount;

	public AmazonAndFlipkartPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		intialization();
		FlipkartLandingPage = new FlipkartLandingPage();
		FlipkartSearchResultsPage = new FlipkartSearchResultsPage();
		FlipkartCartPage = new FlipkartCartPage();
		AmazonLandingPage = new AmazonLandingPage();
		AmazonSearchResultsPage = new AmazonSearchResultsPage();
		AmazonCartPage = new AmazonCartPage();
		FlipkartLandingPage.clearLoginPopUp();
		FlipkartLandingPage.enterProductName(prop.getProperty("ProductName"));
		FlipkartSearchResultsPage = FlipkartLandingPage.clickSearch();
		FlipkartSearchResultsPage.clickFirstItem();
		FlipkartSearchResultsPage.switchTab();
		flipkartTotalAmount = FlipkartSearchResultsPage.printPrice();
		System.out.println("Amount from Flipkart is: " + flipkartTotalAmount);
		driver.get(prop.getProperty("AmazonURL"));
		AmazonLandingPage.enterProductName(prop.getProperty("ProductName"));
		AmazonSearchResultsPage = AmazonLandingPage.clickSearch();
		AmazonSearchResultsPage.printPrice();
		AmazonSearchResultsPage.clickFirstItem();
		AmazonSearchResultsPage.addProductToCart();
		AmazonSearchResultsPage.clickOnCartIcon();
		amazonTotalAmount = AmazonCartPage.totalAmount();
		System.out.println("Amount from Amazon is: " + amazonTotalAmount);

//			Thread.sleep(5000);
//			FlipkartSearchResultsPage.clickOnCartIcon();

	}

	@Test(priority = 1)
	public void compareAndPrintLowerPrice() throws InterruptedException, IOException {
		if (amazonTotalAmount > flipkartTotalAmount) {

			System.out.println("Flipkart price is cheaper for the same product");
		} else if (amazonTotalAmount < flipkartTotalAmount) {
			System.out.println("Amazon price is cheaper for the same product");
		} else {
			System.out.println("Prices in Amazon and Flipkart are same");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
