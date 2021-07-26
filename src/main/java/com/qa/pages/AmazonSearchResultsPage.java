package com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AmazonSearchResultsPage extends TestBase {
	// Page Factory- Object Repository

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement amazonFirstItem;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement priceAmazonProduct;

	@FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
	WebElement cartIcon;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCart;

	public AmazonSearchResultsPage() throws IOException {

		PageFactory.initElements(driver, this); // Initialize all @FindBy Page Factory elements
	}

	// Actions to be Performed:

	public double printPrice() {

		String strPrice = priceAmazonProduct.getText();
		String strPriceReplaced = strPrice.replaceAll("[^0-9]", "");
		double price = Double.parseDouble(strPriceReplaced);
		return price;

	}

	public void clickFirstItem() {

		amazonFirstItem.click();

	}

	public void switchTab() {

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

	}

	public void addProductToCart() throws InterruptedException {

		addToCart.click();

	}

	public AmazonCartPage clickOnCartIcon() throws IOException, InterruptedException {
		cartIcon.click();
		return new AmazonCartPage();
	}

}
