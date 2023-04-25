package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		this.driver = _driver;
	}
	
	
}
