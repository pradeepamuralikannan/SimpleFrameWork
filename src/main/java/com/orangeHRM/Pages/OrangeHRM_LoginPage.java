package com.orangeHRM.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.GenericMethods;

public class OrangeHRM_LoginPage extends GenericMethods {
	
	 public OrangeHRM_LoginPage(WebDriver driver) {
		    super(driver);
	    }

	public void login() throws Exception {

		WebElement userName = getElement(By.name("username"));
		WebElement passWord = getElement(By.name("password"));
		WebElement loginButton = getElement(By.xpath("//button[@type='submit']"));

		userName.sendKeys(readAPropertyFile("username"));
		passWord.sendKeys(readAPropertyFile("password"));
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardHeader =
		        wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//h6[text()='Dashboard']")
		        ));
//		if(dashboardHeader.getText().equals("Dashboard"))
//			System.out.println("Login Successfull");
//		else
//			System.out.println("Login Failed");
		
//		Assert.assertEquals(dashboardHeader.getText().equals("Dashboard"), "Dashboard");

	}

}
