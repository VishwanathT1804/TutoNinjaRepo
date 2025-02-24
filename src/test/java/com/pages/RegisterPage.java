package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver = null;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement telePhone;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement cnfPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkBox;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement continueButton;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement firstLogout;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueAfterRegister;

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	WebElement noRadio;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	WebElement yesRadio;

	@FindBy(id = "content")
	WebElement expectedText;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement text1;

	@FindBy(xpath = "//p[normalize-space()='Congratulations! Your new account has been successfully created!']")
	WebElement text2;

	@FindBy(xpath = "//p[normalize-space()='You can now take advantage of member privileges to enhance your online shopping experience with us.']")
	WebElement text3;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	WebElement alertFirstName;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	WebElement alertLastName;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement alertEmail;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	WebElement alertTelephone;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	WebElement alertPassword;

	@FindBy(xpath = "//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]")
	WebElement alertMain;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getlastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTelePhone() {
		return telePhone;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCnfPassword() {
		return cnfPassword;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getFirstLogout() {
		return firstLogout;
	}

	public WebElement getContinueAfterRegister() {
		return continueAfterRegister;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getNoRadio() {
		return noRadio;
	}
	
	public WebElement getYesRadio() {
		return yesRadio;
	}

	public WebElement getExpectedText() {
		return expectedText;
	}

	public WebElement getText1() {
		return text1;
	}

	public WebElement getText2() {
		return text2;
	}

	public WebElement getText3() {
		return text3;
	}

	public WebElement getAlertFirstName() {
		return alertFirstName;
	}

	public WebElement getAlertLastName() {
		return alertLastName;
	}

	public WebElement getAlertEmail() {
		return alertEmail;
	}

	public WebElement getAlertTelephone() {
		return alertTelephone;
	}

	public WebElement getAlertPassword() {
		return alertPassword;
	}

	public WebElement getAlertMain() {
		return alertMain;
	}

}
