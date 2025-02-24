package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetter {
	
	WebDriver driver = null;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	WebElement yesNewsLetter;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	WebElement noNewsLetter;
	
	public NewsLetter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getYesNewsLetter() {
		return yesNewsLetter;
	}
	
	public WebElement getNoNewsLetter() {
		return noNewsLetter;
	}

}
