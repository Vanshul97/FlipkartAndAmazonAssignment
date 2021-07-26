package com.qa.util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static int IMPLICIT_WAIT = 20;

//	public static void explicitWait(WebElement element, long time) {
//		WebDriverWait wait = new WebDriverWait(driver, time);
//		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
//	}
}
