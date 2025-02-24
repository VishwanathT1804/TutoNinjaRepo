package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver = null;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
	WebElement loginPageConfirmation;
	
	@FindBy(xpath = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	WebElement invalidCredAlert;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getLoginPageConfirmation() {
		return loginPageConfirmation;
	}
	
	public WebElement getInvalidCredAlert() {
		return invalidCredAlert;
	}

}
