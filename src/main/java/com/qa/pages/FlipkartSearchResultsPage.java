package com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FlipkartSearchResultsPage extends TestBase {
	// Page Factory- Object Repository
	@FindBy(xpath = "(//div[@class='_4rR01T'])[1]")
	WebElement flipkartFirstItem;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addProductToCart;

	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	WebElement priceProductPage;

	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	WebElement cartIcon;
	
	@FindBy(xpath = "//input[@placeholder='Enter Delivery Pincode']")
	WebElement deliveryPincode;
	
	@FindBy(xpath = "//a[@class='_3SkBxJ']")
	WebElement checkButton;

	public FlipkartSearchResultsPage() throws IOException {

		PageFactory.initElements(driver, this); // Initialize all @FindBy Page Factory elements
	}

	// Actions to be Performed:

	

	public void switchTab() {

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

	}

	public void closeTab() {
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tab2.get(0));
	}

	public int printPrice() {

		String strPrice = priceProductPage.getText();
		String strPriceReplaced = strPrice.replaceAll("[^0-9]", "");
		int price = Integer.parseInt(strPriceReplaced);
		return price;

	}

	public void addProductToCart() throws InterruptedException {
//		deliveryPincode.sendKeys(Pincode);
//		checkButton.click();
//		Thread.sleep(5000);
		addProductToCart.click();
		Thread.sleep(40000);
	}

	public FlipkartCartPage clickOnCartIcon() throws IOException, InterruptedException {
		Thread.sleep(4000);
		cartIcon.click();
		return new FlipkartCartPage();
	}

	public void clickFirstItem() {
		// TODO Auto-generated method stub
		flipkartFirstItem.click();
		
	}

	


}
