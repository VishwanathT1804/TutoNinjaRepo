package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
	
	WebDriver driver = null;
	
	public DemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(linkText = "Login")
	WebElement login;
	
	
	public WebElement getMyAccount() {
		return myAccount;
	}
		
	public WebElement getRegister() {
		return register;
	}
	
	public WebElement getLogin() {
		return login;
	}

}
