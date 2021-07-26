package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AmazonCartPage extends TestBase {

	@FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']/span")
	WebElement subtotal;

	public AmazonCartPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	// Actions to be Performed:

	public double totalAmount() {
		String price = subtotal.getText().trim();
		String priceReplaced = price.replaceAll("[^0-9]", "");
		double totalamount = Double.parseDouble(priceReplaced);
		return totalamount;

	}

}
