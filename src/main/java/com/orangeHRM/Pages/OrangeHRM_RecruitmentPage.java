package com.orangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericMethods;

public class OrangeHRM_RecruitmentPage extends GenericMethods {

	public OrangeHRM_RecruitmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public List<WebElement> links_Recruitment_TopMenu = driver
			.findElements(By.xpath("//nav[@aria-label='Topbar Menu']//a"));

	public WebElement link_Help = driver.findElement(By.xpath("//button[@title='Help']"));

	public WebElement dropdown_JobTitle = driver.findElement(By.xpath(
			"//label[text() = 'Job Title']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::div[@class='oxd-select-wrapper']"));

	public WebElement dropdown_Vacancy = driver.findElement(By.xpath(
			"//label[text() = 'Vacancy']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::div[@class='oxd-select-wrapper']"));

	public WebElement dropdown_HiringManager = driver.findElement(By.xpath(
			"//label[text() = 'Hiring Manager']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::div[@class='oxd-select-wrapper']"));

	public WebElement dropdown_Status = driver.findElement(By.xpath(
			"//label[text() = 'Status']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::div[@class='oxd-select-wrapper']"));

	public WebElement textBox_CandidateName = driver.findElement(By.xpath(
			"//label[text() = 'Candidate Name']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input"));

	public WebElement textBox_KeyWords = driver.findElement(By.xpath(
			"//label[text() = 'Keywords']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::input"));

	public WebElement textBox_DateOfApplication_From = driver.findElement(By.xpath("//input[@placeholder='From']"));

	public WebElement textBox_DateOfApplication_To = driver.findElement(By.xpath("//input[@placeholder='To']"));

	public WebElement dropdown = driver.findElement(By.xpath(
			"//label[text() = 'Method of Application']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::div[@class='oxd-select-wrapper']"));

	public WebElement button_Reset = driver.findElement(By.xpath("//button[text() = ' Reset ']"));

	public WebElement button_Search = driver.findElement(By.xpath("//button[text() = ' Search ']"));

	public WebElement button_Add = driver.findElement(By.xpath("//button[text() = ' Add ']"));

	public WebElement textbox_FirstName = driver.findElement(By.xpath(
			"(//label[text() = 'Full Name']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input)[1]"));

	public WebElement textbox_MiddleName = driver.findElement(By.xpath(
			"(//label[text() = 'Full Name']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input)[2]"));

	public WebElement textbox_LastName = driver.findElement(By.xpath(
			"(//label[text() = 'Full Name']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input)[3]"));

	public WebElement textbox_Email = driver.findElement(
			By.xpath("//label[text() = 'Email']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input"));

	public WebElement textbox_ContactNumber = driver.findElement(By.xpath(
			"//label[text() = 'Contact Number']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input"));

	public WebElement button_ResumeUpload = driver.findElement(By.xpath("//div[text() = 'Browse']"));
	public WebElement textbox_ResumeUpload = driver.findElement(By.xpath("//input[@class='oxd-file-input']"));

	public WebElement text_UploadFileHint = driver.findElement(By.xpath("//div[@class='orangehrm-file-input']/p"));

	public WebElement text_Keywords = driver
			.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']"));

	public WebElement textbox_DateOfApplication = driver.findElement(By.xpath(
			"//label[text() = 'Date of Application']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input"));

	public WebElement textbox = driver.findElement(By.xpath("//textarea[@placeholder='Type here']"));

	public WebElement checkbox = driver.findElement(By.xpath("//label[text() = 'Consent to keep data']"));

	public WebElement text_Required = driver.findElement(By.xpath("//p[text() = ' * Required']"));

	public WebElement button_Cancel = driver.findElement(By.xpath("//button[text() = ' Cancel ']"));

	public WebElement button_Save = driver.findElement(By.xpath("//button[text() = ' Save ']"));

//	new to me
	public WebElement text_TotalRecords = driver.findElement(By.xpath("//*[text()[contains(.,'Records Found')]]"));

	public WebElement text_RowCount = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div"));

	public List<WebElement> text_allRows = driver
			.findElements(By.xpath("(//div[@class='oxd-table-body']//div[@role='row'])"));

	public void goToAPageInRecruitment(String pageName) {
		for (WebElement eachPage : links_Recruitment_TopMenu) {
			if (eachPage.getText().equalsIgnoreCase(pageName)) {
				eachPage.click();
				break;
			}
		}
	}
	
	public void searchCandidate(String fieldName, String value) {
		switch(fieldName) {
		case "Job Title":
			dropdown_JobTitle.sendKeys(value);
			break;
			
		case "Candidate Name":
			textBox_CandidateName.sendKeys();
			break;
		}
		
		button_Search.click();
		
	}
	
	public void searchCandidate(String candidateName, String fromDate, String toDate) {
		textBox_CandidateName.sendKeys(candidateName);
		textBox_DateOfApplication_From.sendKeys(fromDate);
		textBox_DateOfApplication_To.sendKeys(toDate);
		button_Search.click();
	}

}
