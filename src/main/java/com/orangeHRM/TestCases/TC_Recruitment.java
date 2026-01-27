package com.orangeHRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.orangeHRM.Pages.OrangeHRM_CommonPage;
import com.orangeHRM.Pages.OrangeHRM_LoginPage;

import util.GenericMethods;

public class TC_Recruitment extends GenericMethods {
	

	public TC_Recruitment(WebDriver driver) {
		super(driver);
	}

	@Test
	public void searchAnEmployeeByNameTitle() throws Exception {
		browsers("chrome");
		launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		OrangeHRM_LoginPage loginPage = new OrangeHRM_LoginPage(driver);
		loginPage.login();
		OrangeHRM_CommonPage commonPage = new OrangeHRM_CommonPage(driver);
		commonPage.goToAnyPage("Recruitment");
	}
}
