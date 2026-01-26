package com.orangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericMethods;

public class OrangeHRM_CommonPage {

	public WebDriver driver;
	GenericMethods gm;
	
	public OrangeHRM_CommonPage(WebDriver driver) {
		this.driver = driver;
		this.gm = new GenericMethods(driver);
	}
	
	public void goToAnyPage(String pageName) {

		 gm = new GenericMethods(driver);

		List<WebElement> pageList = gm.getListOfElements(By.xpath("//ul[@class='oxd-main-menu']//span"));

		for (WebElement eachPage : pageList) {
			if (eachPage.getText().equalsIgnoreCase(pageName))
				eachPage.click();
			break;
		}

	}
	
	public void getPageTitle() {
		 gm = new GenericMethods(driver);
		System.out.println(gm.getText(By.tagName("h6")));
	}
}
