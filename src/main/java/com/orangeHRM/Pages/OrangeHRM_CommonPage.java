package com.orangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericMethods;

public class OrangeHRM_CommonPage extends GenericMethods {

	public OrangeHRM_CommonPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToAnyPage(String pageName) {

		List<WebElement> pageList = getListOfElements(By.xpath("//ul[@class='oxd-main-menu']//span"));

		for (WebElement eachPage : pageList) {
			if (eachPage.getText().equalsIgnoreCase(pageName))
				eachPage.click();
			break;
		}

	}
	
	public void getPageTitle() {
		System.out.println(getText(By.tagName("h6")));
	}
}
