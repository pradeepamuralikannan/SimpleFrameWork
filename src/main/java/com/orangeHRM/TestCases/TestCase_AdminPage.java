package com.orangeHRM.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHRM.Pages.OrangeHRMAdminPage;
import com.orangeHRM.Pages.OrangeHRM_CommonPage;
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
	
	@Test(priority=0)
	public void loginTest() throws Exception {
		OrangeHRM_LoginPage log = new OrangeHRM_LoginPage(driver);
		log.login();
	}
	
	@Test(priority=1)
	public void clickAdminPage() {
		OrangeHRM_CommonPage com = new OrangeHRM_CommonPage(driver);
		com.goToAnyPage("Admin");
	}
	
	@Test(priority=2)
	public void adminPageTest() {
		OrangeHRMAdminPage adm = new OrangeHRMAdminPage(driver);
//		adm.searchByUserName("Admin");
//		adm.searchUserByNameandRole("Admin", "Admin");
//		adm.getEntireUsersList();
//		adm.deleteUserByName("casper");
//		adm.addUser("Admin", "TestUser", "Radha  Gupta", "Raha@145", "Enabled");
//		adm.isUserDisplayedInTable("TestUser");
//		adm.clickAndDelete("FMLName");
	}

	@AfterTest
	public void closebrowser() {
		GenericMethods gm = new GenericMethods(driver);
		gm.close();
	}
}
