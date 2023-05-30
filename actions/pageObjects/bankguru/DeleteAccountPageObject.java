package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DeleteAccountPageObject extends BasePage {
	private WebDriver driver;
	
	public DeleteAccountPageObject(WebDriver _driver) {
		this.driver = _driver;
	}
}
