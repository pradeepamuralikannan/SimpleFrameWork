package com.orangeHRM.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHRM.Pages.OrangeHRM_DashboardPage;
import com.orangeHRM.Pages.OrangeHRM_LoginPage;

import util.GenericMethods;

public class TestCase_DashBoardPage {
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
	public void DashBoardTestcases() {
		OrangeHRM_DashboardPage db = new OrangeHRM_DashboardPage(driver);
		db.assignLeave();
	}
}
