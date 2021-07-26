package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlipkartCartPage;
import com.qa.pages.FlipkartLandingPage;
import com.qa.pages.FlipkartSearchResultsPage;

public class FlipkartCartPageTest extends TestBase {
	FlipkartLandingPage FlipkartLandingPage;
	FlipkartSearchResultsPage FlipkartSearchResultsPage;
	FlipkartCartPage FlipkartCartPage;

	public FlipkartCartPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		intialization();
		FlipkartLandingPage = new FlipkartLandingPage();
		FlipkartSearchResultsPage = new FlipkartSearchResultsPage();
		FlipkartCartPage = new FlipkartCartPage();
		FlipkartLandingPage.clearLoginPopUp();
		FlipkartLandingPage.enterProductName(prop.getProperty("ProductName"));
		FlipkartSearchResultsPage = FlipkartLandingPage.clickSearch();
		FlipkartSearchResultsPage.clickFirstItem();
		FlipkartSearchResultsPage.switchTab();
		FlipkartSearchResultsPage.printPrice();
		FlipkartSearchResultsPage.addProductToCart();
//		Thread.sleep(5000);
//		FlipkartSearchResultsPage.clickOnCartIcon();

	}

	@Test(priority = 1)
	public void printTotalAmount() throws InterruptedException {

		FlipkartCartPage.increaseQuantity();
		Thread.sleep(20000);
		double finalAmount = FlipkartCartPage.totalAmount();
		System.out.println("Price after increasing the quantity by one is: " + "Rs." + finalAmount);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
