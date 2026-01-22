package com.orangeHRM.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GenericMethods;

public class OrangeHRM_DashboardPage {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {

	}

	public OrangeHRM_DashboardPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	public void clickProfileDropDown() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//li[@class='--active oxd-userdropdown']")))).click();
	}
	
	public void clickUpgradeButton() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.className("class=\"oxd-glass-button orangehrm-upgrade-button\"")))).click();
	}
	
	
	public void pendingSelfReview() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//p[text()='(1) Pending Self Review']")))).click();
	}

	public void candidateToInterview() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//p[text()='(1) Candidate to Interview']")))).click();
	}

	public void assignLeave() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Assign Leave']")))).click();
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

}
