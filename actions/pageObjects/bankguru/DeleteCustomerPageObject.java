package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DeleteCustomerPageObject extends BasePage {
	private WebDriver driver;
	
	public DeleteCustomerPageObject(WebDriver _driver) {
		this.driver = _driver;
	}
}
