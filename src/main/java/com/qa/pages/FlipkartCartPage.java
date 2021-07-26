package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FlipkartCartPage extends TestBase {

	@FindBy(xpath = "(//button[text()='+'])[1]")
	WebElement addQuantity;

	@FindBy(xpath = "(//div[text()='Total Amount']//parent::div)[1]//following::span[2]")
	WebElement totalAmount;

	public FlipkartCartPage() throws IOException {
		PageFactory.initElements(driver, this); // Initialize all @FindBy Page Factory elements

	}

	// Actions to be Performed:

	public void increaseQuantity() throws InterruptedException {
		addQuantity.click();
		Thread.sleep(10000);
	}

	public double totalAmount() {
		String price = totalAmount.getText();
		String priceReplaced = price.replaceAll("[^0-9]", "");
		double totalamount = Double.parseDouble(priceReplaced);
		return totalamount;

	}

}
