package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class FlipkartLandingPage extends TestBase {
	// Page Factory- Object Repository

	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement flipkartSearchTextBox;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement LoginPopUp;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement flipkartSearchButton;

	public FlipkartLandingPage() throws IOException {

		PageFactory.initElements(driver, this); // Initialize all @FindBy Page Factory elements

		// TODO Auto-generated constructor stub
	}

	// 	Actions to be Performed:
	
		public void clearLoginPopUp() throws InterruptedException {
			Thread.sleep(2000);
			LoginPopUp.click();	
		}
	public void enterProductName(String product) {
		flipkartSearchTextBox.sendKeys(product);
	}

	public FlipkartSearchResultsPage clickSearch() throws IOException {
		flipkartSearchButton.click();
		return new FlipkartSearchResultsPage();
	}

}
