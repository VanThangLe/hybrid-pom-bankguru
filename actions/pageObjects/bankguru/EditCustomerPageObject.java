package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage {
	private WebDriver driver;
	
	public EditCustomerPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isEditCustomerPageDisplayed(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.TITLE_TEXT, value);
		return isElementDisplayed(driver, EditCustomerPageUI.TITLE_TEXT, value);
	}
}
