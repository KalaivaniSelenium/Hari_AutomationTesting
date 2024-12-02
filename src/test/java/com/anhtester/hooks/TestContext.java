package com.anhtester.hooks;

import java.time.Duration;

//import javax.xml.transform.Templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.driver.TargetFactory;
import com.anhtester.keywords.WebUI;
//import com.anhtester.projects.website.GeekLadder.pages.LoginPage;
import com.anhtester.utils.LogUtils;

public class TestContext {

	private WebDriver driver;

	public TestContext() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = ThreadGuard.protect(new TargetFactory().createInstance());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.WAIT_IMPLICIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		DriverManager.setDriver(driver);
		LogUtils.info("Driver in TestContext: " + getDriver());
	}


//	private LoginPage lo;
	

	
//	public LoginPage getLogin() {
//		if (lo == null) {
//			lo = new LoginPage();
//		}
//		return lo;
//	}
	

	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}

}
