package com.test;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.DemoPage;
import com.pages.HomePage;
import com.pages.NewsLetter;
import com.pages.RegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateRegister extends Base {

	WebDriver driver = null;
	RegisterPage register = null;
	DemoPage demo = null;
	HomePage home = null;
	NewsLetter newsLetter = null;
	
	

	public String getEmailId() {
		Date date = new Date();
		String email = date.toString().replaceAll("\\s", "").replaceAll("\\:", "");
		return email + "@gmail.com";
	}

	@BeforeMethod
	public void openBrowser() {
		driver = initialiszeBrowserAndOpenUrl();
		demo = new DemoPage(driver);

		demo.getMyAccount().click();
		demo.getRegister().click();

	}

	@Test(priority = 0)
	public void registerWithMandatoryfields() {

		register = new RegisterPage(driver);

		register.getFirstName().sendKeys("QA");
		register.getlastName().sendKeys("fox");
		register.getEmail().sendKeys(getEmailId());
		register.getTelePhone().sendKeys("0123456789");
		register.getPassword().sendKeys("qafox@123");
		register.getCnfPassword().sendKeys("qafox@123");
		register.getCheckBox().click();
		register.getContinueButton().click();

		Assert.assertTrue(register.getFirstLogout().isDisplayed());

		register.getContinueAfterRegister().click();

		Assert.assertTrue(register.getMyAccount().isDisplayed());

	}

	@Test(priority = 1)
	public void validateWithAllFields() {

		register = new RegisterPage(driver);

		register.getFirstName().sendKeys("QA");
		register.getlastName().sendKeys("fox");
		register.getEmail().sendKeys(getEmailId());
		register.getTelePhone().sendKeys("1234567890");
		register.getPassword().sendKeys("qafox@123");
		register.getCnfPassword().sendKeys("qafox@123");
		register.getNoRadio().click();
		register.getCheckBox().click();
		register.getContinueButton().click();

		String expectedStatus = register.getExpectedText().getText();

		String actual1 = register.getText1().getText();
		String actual2 = register.getText2().getText();
		String actual3 = register.getText3().getText();

		Assert.assertTrue(expectedStatus.contains(actual1));
		Assert.assertTrue(expectedStatus.contains(actual2));
		Assert.assertTrue(expectedStatus.contains(actual3));

		register.getContinueAfterRegister().click();

		Assert.assertTrue(register.getMyAccount().isDisplayed());

	}

	@Test(priority = 2)
	public void validateWithoutProvidingAnyfields() {

		register = new RegisterPage(driver);

		register.getContinueButton().click();

		Assert.assertEquals("First Name must be between 1 and 32 characters!", register.getAlertFirstName().getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", register.getAlertLastName().getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", register.getAlertEmail().getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", register.getAlertTelephone().getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", register.getAlertPassword().getText());
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", register.getAlertMain().getText());
	}

	@Test(priority = 3)
	public void validateRegisterBySelectingnewsLetterAsYes() {

		register = new RegisterPage(driver);

		register.getFirstName().sendKeys("qa");
		register.getlastName().sendKeys("fox");
		register.getEmail().sendKeys(getEmailId());
		register.getTelePhone().sendKeys("1234567890");
		register.getPassword().sendKeys("qafox@gmail.com");
		register.getCnfPassword().sendKeys("qafox@gmail.com");
		register.getYesRadio().click();
		register.getCheckBox().click();
		register.getContinueButton().click();
		;

		Assert.assertTrue(register.getFirstLogout().isDisplayed());

		register.getContinueAfterRegister().click();

		Assert.assertTrue(register.getMyAccount().isDisplayed());

		home = new HomePage(driver);

		home.getSubscribeOrUnsubscribeToNewsLetter().click();

		newsLetter = new NewsLetter(driver);

		Assert.assertTrue(newsLetter.getYesNewsLetter().isSelected());
	}

	@Test(priority = 4)
	public void validateRegisterBySelectingnewsLetterAsNo() {

		register = new RegisterPage(driver);

		register.getFirstName().sendKeys("qa1");
		register.getlastName().sendKeys("fox1");
		register.getEmail().sendKeys(getEmailId());
		register.getTelePhone().sendKeys("0980987656");
		register.getPassword().sendKeys("qa1fox@gmail.com");
		register.getCnfPassword().sendKeys("qa1fox@gmail.com");
		register.getNoRadio().click();
		register.getCheckBox().click();
		register.getContinueButton().click();

		Assert.assertTrue(register.getFirstLogout().isDisplayed());

		register.getContinueAfterRegister().click();

		home = new HomePage(driver);

		home.getSubscribeOrUnsubscribeToNewsLetter().click();

		newsLetter = new NewsLetter(driver);

		Assert.assertTrue(newsLetter.getNoNewsLetter().isSelected());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
