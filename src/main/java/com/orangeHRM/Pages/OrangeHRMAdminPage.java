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

	public void clickAdminPage() {
		gm.click(By.xpath("//span[text()='Admin']"));
		gm.waitForVisibility(By.xpath("//h6[text()='Admin']"));
	}

	public void goToAPageInAdminPage(String mainManu, String subMenu) throws InterruptedException {
		List<WebElement> TopdropDownMenus = null;

		if (mainManu.equalsIgnoreCase("Natioanalities") || mainManu.equalsIgnoreCase("Corporate Branding"))
			TopdropDownMenus = gm.getListOfElement(By.xpath("//nav[@aria-label='Topbar Menu']/ul/li/a"));
		else
			TopdropDownMenus = gm.getListOfElement(By.xpath("//nav[@aria-label='Topbar Menu']/ul/li/span"));

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
		List<WebElement> allSubMenus = gm.getListOfElement(By.xpath("//ul[@class='oxd-dropdown-menu']//a"));
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
				.getListOfElement(By.xpath("//nav[@class='oxd-topbar-body-nav']//li//span"));

		for (WebElement eachMenu : TopdropDownMenus) {
			if (eachMenu.getText().equalsIgnoreCase(menuName))
				eachMenu.click();
		}

		List<WebElement> TopNormalMenus = gm.getListOfElement(By.xpath("//nav[@class='oxd-topbar-body-nav']//li//a"));

		for (WebElement eachMenu : TopNormalMenus) {
			if (eachMenu.getText().equalsIgnoreCase(menuName))
				eachMenu.click();

		}

	}

//	public void searchUserInAdminPage() {
//
//		// entering username
//		gm.sendText(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input"), "Admin");
//
//		// Click dropdown (selected value container)
//		gm.getElement(By.xpath(
//				"//label[text()='User Role']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]"))
//				.click();
//
//		// Wait for listbox to appear
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));
//
//		// Click actual option from listbox
//		gm.getElement(By.xpath(
//				"//div[@role='listbox']//div[contains(@class,'oxd-select-option--text') and normalize-space()='Admin']"))
//				.click();
//
//		// clicking submit button to search the user
//		gm.getElement(By.xpath("//button[@type='submit']")).click();
//
//	}

	public void searchUser(String username, String role) {

		gm.sendText(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input"), username);

		gm.click(By.xpath(
				"//label[text()='User Role']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]"));

		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));

		gm.click(By.xpath("//div[@role='listbox']//div[normalize-space()='" + role + "']"));

		gm.click(By.xpath("//button[@type='submit']"));
	}

	public boolean verifySearchResult(String searchedUsername) {

		List<WebElement> usernameCells = gm
				.getListOfElement(By.xpath("//div[@class='oxd-table-body']//div[@role='cell'][2]//div"));

		return usernameCells.size() == 1 && usernameCells.get(0).getText().equalsIgnoreCase(searchedUsername);
	}

	public boolean isUserDisplayedInTable(String username) {
		List<WebElement> users = driver.findElements(By
				.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[normalize-space()='" + username + "']"));
		return users.size() > 0;
	}

	public void addUser(String role, String username, String employeeName, String password, String status) {

// Click Add button
		gm.click(By.xpath("//button[normalize-space()='Add']"));

// Wait for Add User form
		gm.waitForVisibility(By.xpath("//h6[text()='Add User']"));

// Select User Role
		gm.click(By.xpath(
				"//label[text()='User Role']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]"));
		
		//label[text() = 'User Role']//following::div[@role="option"]
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[normalize-space()='" + role + "']"));

// Enter Employee Name
		gm.sendText(By.xpath("//input[@placeholder='Type for hints...']"), employeeName);
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[1]"));

// Select Status
		gm.click(By.xpath(
				"//label[text()='Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]"));
		gm.waitForVisibility(By.xpath("//div[@role='listbox']"));
		gm.click(By.xpath("//div[@role='listbox']//div[normalize-space()='" + status + "']"));

// Enter Username
		gm.sendText(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input"), username);

// Enter Password
		gm.sendText(By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input"), password);

// Confirm Password
		gm.sendText(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div//input"), password);

// Click Save
		gm.click(By.xpath("//button[@type='submit']"));
	}

}
