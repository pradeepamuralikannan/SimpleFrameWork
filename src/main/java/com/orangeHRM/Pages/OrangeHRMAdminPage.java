package com.orangeHRM.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GenericMethods;

public class OrangeHRMAdminPage {

	public WebDriver driver;
	GenericMethods gm;

	public OrangeHRMAdminPage(WebDriver driver) {
		this.driver = driver;
		this.gm = new GenericMethods(driver);
	}

	public void goToAPageInAdminPage(String mainManu, String subMenu) throws InterruptedException {
		List<WebElement> TopdropDownMenus = null;

		if (mainManu.equalsIgnoreCase("Natioanalities") || mainManu.equalsIgnoreCase("Corporate Branding"))
			TopdropDownMenus = gm.getListOfElements(By.xpath("//nav[@aria-label='Topbar Menu']/ul/li/a"));
		else
			TopdropDownMenus = gm.getListOfElements(By.xpath("//nav[@aria-label='Topbar Menu']/ul/li/span"));

		for (WebElement each : TopdropDownMenus) {

			switch (each.getText()) {
			case "Job":
				each.click();
				Thread.sleep(2000);
				goToSubMenu(subMenu);
				break;

			case "Nationalities":
				each.click();
				break;
			}
		}

	}

	public void goToSubMenu(String subMenu) {
		List<WebElement> allSubMenus = gm.getListOfElements(By.xpath("//ul[@class='oxd-dropdown-menu']//a"));
		for (WebElement each : allSubMenus) {
			switch (each.getText()) {
			case "Job Titles":
				each.click();
				break;

			case "Pay Grade":
				each.click();
				break;
			}
		}

	}

	public void clickMenuInAdminPage(String menuName) {

		List<WebElement> TopdropDownMenus = gm
				.getListOfElements(By.xpath("//nav[@class='oxd-topbar-body-nav']//li//span"));

		for (WebElement eachMenu : TopdropDownMenus) {
			if (eachMenu.getText().equalsIgnoreCase(menuName))
				eachMenu.click();
		}

		List<WebElement> TopNormalMenus = gm.getListOfElements(By.xpath("//nav[@class='oxd-topbar-body-nav']//li//a"));

		for (WebElement eachMenu : TopNormalMenus) {
			if (eachMenu.getText().equalsIgnoreCase(menuName))
				eachMenu.click();

		}

	}

	public void addUser(String role, String username, String employeeName, String password, String status) {

		gm.click(By.xpath("//button[normalize-space()='Add']")); // Click Add button
		gm.waitForVisibility(By.xpath("//h6[text()='Add User']")); // Wait for Add User form
		gm.click(By.xpath(
				"//label[text()='User Role']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']")); // Select
																														// User
																														// Role

		// label[text() = 'User Role']//following::div[@role="option"]
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath(".//div[normalize-space()='" + role + "']"));

		gm.sendText(By.xpath("//input[@placeholder='Type for hints...']"), employeeName); // Enter Employee Name
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[1]"));

		gm.click(By
				.xpath("//label[text()='Status']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']")); // Select
																															// Status
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[normalize-space()='" + status + "']"));

		gm.sendText(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input"), username); // Enter
																													// Username

		gm.sendText(By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input"), password); // Enter
																													// Password

		gm.sendText(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div//input"), password); // Confirm
																															// Password

		gm.click(By.xpath("//button[@type='submit']")); // Click Save
	}

	public void searchByUserName(String userName) {

		gm.sendText(By.xpath("//label[text()='Username']//following::input[@class='oxd-input oxd-input--active']"),
				userName);
		gm.click(By.xpath("//button[@type='submit']"));
	}

	public void searchUserByNameandRole(String username, String role) {

		gm.sendText(By.xpath("//label[text()='Username']//following::input[@class='oxd-input oxd-input--active']"),
				username);
		gm.click(By.xpath("//label[text() = 'User Role']//following::div[@class='oxd-select-wrapper']"));
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[normalize-space()='" + role + "']"));
		gm.click(By.xpath("//button[@type='submit']"));
	}

	public boolean verifySearchResult(String searchedUsername) {

		List<WebElement> usernameCells = gm
				.getListOfElements(By.xpath("//div[@class='oxd-table-body']//div[@role='cell'][2]//div"));

		return usernameCells.size() == 1 && usernameCells.get(0).getText().equalsIgnoreCase(searchedUsername);
	}

	public boolean isUserDisplayedInTable(String username) {
		List<WebElement> users = driver.findElements(By
				.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[normalize-space()='" + username + "']"));
		return users.size() > 0;
	}

	public void getEntireUsersList() {

		List<WebElement> tableDataRows = gm
				.getListOfElements(By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-card')]"));

		for (WebElement eachRow : tableDataRows) {
			List<WebElement> tableDataCols = eachRow
					.findElements(By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell']"));
			for (int i = 1; i < tableDataCols.size(); i++) {
				tableDataCols.get(i).getText();
			}
		}
	}

	public void deleteUserByName(String userName) {
		List<WebElement> tableDataRows = gm
				.getListOfElements(By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-card')]"));

		for (WebElement each : tableDataRows) {
			List<WebElement> eachCell = each.findElements(By.xpath(".//div[contains(@class,'oxd-table-cell')]"));
			if (eachCell.size() < 2) {
				continue; // avoids NoSuchElementException
			}

			String eachUserName = eachCell.get(1).getText();
			if (userName.equalsIgnoreCase(eachUserName)) {
				each.findElement(By.xpath(".//i[contains(@class,'bi-trash')]")).click();
				gm.waitAndClick(By.xpath("//button[normalize-space()='Yes, Delete']"));
				return; // break only exit the loop. but return exit both loop and method immediately
			}
		}

	}

	public void clickAndDelete(String userName) {
		List<WebElement> tableDataRows = gm
				.getListOfElements(By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-card')]"));

		for (WebElement each : tableDataRows) {
			List<WebElement> eachCell = each.findElements(By.xpath(".//div[contains(@class,'oxd-table-cell')]"));
			if (eachCell.size() < 2) {
				continue;
			}

			String eachUserName = eachCell.get(1).getText();
			if (userName.equalsIgnoreCase(eachUserName)) {
				each.findElement(By.xpath(".//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
				gm.waitAndClick(By.xpath("//i[@class='oxd-icon bi-trash-fill oxd-button-icon']"));
				return;
			}
		}

	}
}
