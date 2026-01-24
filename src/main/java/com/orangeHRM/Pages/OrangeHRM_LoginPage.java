package com.orangeHRM.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GenericMethods;

public class OrangeHRM_LoginPage {
	
	GenericMethods gm;

	 public OrangeHRM_LoginPage(WebDriver driver) {
		    gm = new GenericMethods(driver);
	    }

	public void login() throws Exception {

		WebElement userName = gm.getElement(By.name("username"));
		WebElement passWord = gm.getElement(By.name("password"));
		WebElement loginButton = gm.getElement(By.xpath("//button[@type='submit']"));

		userName.sendKeys(gm.readAPropertyFile("username"));
		passWord.sendKeys(gm.readAPropertyFile("password"));
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(gm.driver, Duration.ofSeconds(10));
		WebElement dashboardHeader =
		        wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//h6[text()='Dashboard']")
		        ));
		if(dashboardHeader.getText().equals("Dashboard"))
			System.out.println("Login Successfull");
		else
			System.out.println("Login Failed");
	}

}
