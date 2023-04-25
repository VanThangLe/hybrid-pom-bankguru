package com.bankguru.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGenerator;
import pageObjects.bankguru.RegisterPageObject;

public class Login extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	LoginPageObject loginPage;
	
	String userID, password;
	
	public static Set<Cookie> loginPageCookie;
	
	@Parameters({ "browserName", "appUrl" })
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "'and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		
		log.info("Pre-condition - Direct to register page");
		loginPage.openPageUrl(driver, GlobalConstants.REGISTER_LINK);
		registerPage = PageGenerator.getRegisterPage(driver);
		
		log.info("Pre-condition - Register account");
		registerPage.enterToTextboxByIDName(driver, "emailid", GlobalConstants.REGISTER_EMAIL);
		registerPage.clickToButtonByIDName(driver, "btnLogin");
		
		log.info("Pre-condition - Get value of userID and password");
		userID = registerPage.getValueTextByLabel(driver, "User ID :");
		password = registerPage.getValueTextByLabel(driver, "Password :");
		
		log.info("Pre-condition - Direct to login page");
		registerPage.openPageUrl(driver, GlobalConstants.LOGIN_LINK);
		loginPage = PageGenerator.getLoginPage(driver);
		
		log.info("Pre-condition - Login");
		loginPage.enterToTextboxByIDName(driver, "uid", userID);
		loginPage.enterToTextboxByIDName(driver, "password", password);
		loginPage.clickToButtonByIDName(driver, "btnLogin");
		homePage =  PageGenerator.getHomePage(driver);
		
		log.info("Login: Get login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
