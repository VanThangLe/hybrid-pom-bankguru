package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.DashboardPageUI;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public LoginPageObject logoutToSystem() {
		waitForElementClickAble(driver, DashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, DashboardPageUI.LOGOUT_LINK);
		waitForElementClickAble(driver, DashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, DashboardPageUI.LOGOUT_BUTTON);
		return PageGenerator.getLoginPage(driver);
	}
}
