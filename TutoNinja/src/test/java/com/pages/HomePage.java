package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver = null;
	
	@FindBy(xpath = "//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
	WebElement subscribeOrUnsubscribeToNewsLetter;
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement homePageConfirmation;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSubscribeOrUnsubscribeToNewsLetter() {
		return subscribeOrUnsubscribeToNewsLetter;
	}
	
	public WebElement getHomePageConfirmation() {
		return homePageConfirmation;
	}

}
