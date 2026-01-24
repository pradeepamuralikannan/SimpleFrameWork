package com.orangeHRM.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GenericMethods;

public class OrangeHRM_DashboardPage {

	public WebDriver driver;
	GenericMethods gm;
	public static WebDriverWait wait;


	public OrangeHRM_DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.gm = new GenericMethods(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickProfileDropDown() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//li[@class='--active oxd-userdropdown']"))))
				.click();
	}

	public void clickUpgradeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.className("class=\"oxd-glass-button orangehrm-upgrade-button\"")))).click();
	}

	public void pendingSelfReview() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//p[text()='(1) Pending Self Review']")))).click();
	}

	public void candidateToInterview() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//p[text()='(1) Candidate to Interview']"))))
				.click();
	}

	public void leaveList() {
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Leave List']"))))
				.click();
	}

	public void timeSheets() {
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Timesheets']"))))
				.click();
	}

	public void applyLeave() {
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Apply Leave']"))))
				.click();
	}

	public void myLeave() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='My Leave']"))))
				.click();
	}

	public void myTimeSheet() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//button[@title='My Timesheet']")))).click();
	}

	public void assignLeave() {
		
		gm.waitForVisibility(By.xpath("//p[text()='Quick Launch']"));
		gm.click((By.xpath("//button[@title='Assign Leave']")));
		
		gm.waitForVisibility(By.xpath("//a[text()='Assign Leave']"));
		gm.sendText(By.xpath("//input[@placeholder='Type for hints...']"), "Radha Gupta");
		
		gm.click(By.xpath("//label[text()='Leave Type']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']"));
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[normalize-space()='CAN - Personal']"));
		
		gm.js_sendTextToAnElement(gm.getElement(By.xpath("//label[text()='From Date']/parent::div/following-sibling::div//input[@placeholder='yyyy-dd-mm']")),"2026-30-01");

//		gm.sendText(By.xpath("//label[text()='From Date']/parent::div/following-sibling::div//input[@placeholder='yyyy-dd-mm']"), "2026-27-01");
		
//		gm.sendText(By.xpath("//label[text()='To Date']/parent::div/following-sibling::div//input[@placeholder='yyyy-dd-mm']"), "2026-30-01");
		
		gm.js_sendTextToAnElement(gm.getElement(By.xpath("//label[text()='To Date']/parent::div/following-sibling::div//input[@placeholder='yyyy-dd-mm']")),"2026-30-01");
		
		gm.click(By.xpath("//button[@type='submit']"));
		gm.waitAndClick(By.xpath("//button[@type='button' and normalize-space()='Ok']"));
	}
}
