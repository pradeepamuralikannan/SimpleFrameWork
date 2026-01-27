package com.orangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericMethods;

public class OrangeHRM_TimePage extends GenericMethods {
	
	public OrangeHRM_TimePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	List<WebElement> topBarMenu = driver.findElements(By.xpath("//nav[@class='oxd-topbar-body-nav']//ul"));
	
	public void chooseMenuItem() {
		for(WebElement eachMenu:topBarMenu) {
			System.out.println(eachMenu.getText());
		}
	}
}
