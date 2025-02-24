package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver = null;
	Properties prop = null;
	String browser = null;

	public Base() {
		String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\utils\\config.properties";

		try {
			InputStream fis = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver initialiszeBrowserAndOpenUrl() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		}

		else {
			System.out.println("Only chrome browser will be supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
