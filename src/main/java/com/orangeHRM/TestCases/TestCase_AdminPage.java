package com.orangeHRM.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHRM.Pages.OrangeHRMAdminPage;
import com.orangeHRM.Pages.OrangeHRM_LoginPage;

import util.GenericMethods;

public class TestCase_AdminPage {

	WebDriver driver;
	GenericMethods gm;
	
	@BeforeTest
	public void browserLaunch() {
		gm = new GenericMethods(driver);
		driver=gm.browsers("Edge");
		gm.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		gm.maximizeWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=-1)
	public void loginTest() throws Exception {
		OrangeHRM_LoginPage log = new OrangeHRM_LoginPage(driver);
		log.login();
	}
	
	@Test(priority=0)
	public void adminPageTest() {
		OrangeHRMAdminPage adm = new OrangeHRMAdminPage(driver);
		adm.clickAdminPage();
		adm.searchUser("Admin", "Admin");
		adm.isUserDisplayedInTable("Admin");
		adm.addUser("Admin", "TestUser", "Priya", "Priya@145", "Enabled");
	}

	@AfterTest
	public void closebrowser() {
		GenericMethods gm = new GenericMethods(driver);
		gm.close();
	}
}
