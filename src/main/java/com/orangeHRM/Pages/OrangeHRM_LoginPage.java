package com.orangeHRM.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GenericMethods;

public class OrangeHRM_LoginPage {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		GenericMethods gm = new GenericMethods();
		driver = gm.browsers("Edge");
		gm.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		gm.maximizeWindow();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		gm.takeScreenshot("./Screenshots");

		OrangeHRM_LoginPage obj = new OrangeHRM_LoginPage();
		obj.login();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h6[text()='Dashboard']")));
		gm.takeScreenshot("./Screenshots");
	}

	public void login() throws Exception {
		WebElement header = driver.findElement(By.tagName("h5"));
		WebElement userName = driver.findElement(By.name("username"));
		WebElement passWord = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

		GenericMethods gm = new GenericMethods();

		userName.sendKeys(gm.readAPropertyFile("username"));
		passWord.sendKeys(gm.readAPropertyFile("password"));
		loginButton.click();
	}

}
