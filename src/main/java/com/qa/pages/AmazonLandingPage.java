package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AmazonLandingPage extends TestBase {

	@FindBy(xpath = "//input[@type='text']")
	WebElement amazonSearchTextBox;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement amazonSearchButton;

	public AmazonLandingPage() throws IOException {

		PageFactory.initElements(driver, this); // Initialize all @FindBy Page Factory elements

	}

	// Actions to be Performed:

	public void enterProductName(String product) {
		amazonSearchTextBox.sendKeys(product);
	}

	public AmazonSearchResultsPage clickSearch() throws IOException {
		amazonSearchButton.click();
		return new AmazonSearchResultsPage();
	}

}
