package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.DemoPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class ValidateLogin extends Base {

	WebDriver driver = null;

	@BeforeMethod
	public void openBrowser() {
		driver = initialiszeBrowserAndOpenUrl();
		DemoPage demo = new DemoPage(driver);
		demo.getMyAccount().click();
		demo.getLogin().click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=0)
	public void loginWithValidCred() {

		LoginPage login = new LoginPage(driver);

		Assert.assertTrue(login.getLoginPageConfirmation().isDisplayed());

		login.getEmail().sendKeys("qafoxqafox@gmail.com");
		login.getPassword().sendKeys("Qafox@123");
		login.getLoginButton().click();

		HomePage page = new HomePage(driver);

		Assert.assertTrue(page.getHomePageConfirmation().isDisplayed());

	}
	
	@Test(priority=1)
	public void loginWithInValidCred() {

		LoginPage login = new LoginPage(driver);

		Assert.assertTrue(login.getLoginPageConfirmation().isDisplayed());

		login.getEmail().sendKeys("1qfoxqafox@gmail.com");
		login.getPassword().sendKeys("Qafox@1231");
		login.getLoginButton().click();

		Assert.assertTrue(login.getInvalidCredAlert().isDisplayed());

	}

}
