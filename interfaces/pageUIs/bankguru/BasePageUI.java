package pageUIs.bankguru;

public class BasePageUI {
	public static final String BUTTON_BY_ID_NAME = "//input[@name='%s']";
	public static final String TEXTBOX_BY_ID_NAME = "//input[@name='%s']";
	public static final String VALUE_TEXT_BY_LABEL = "//td[contains(text(),'%s')]//following-sibling::td";
	public static final String DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String CHECKBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input";
	public static final String RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
	public static final String TABLE_HEADER_BY_NAME = "//tr/th[string()='%s']";
	public static final String TABLE_LIST_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tr['%s']/td['%s']";
	public static final String TABLE_ASSIGN_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//div[@dusk='%s']//tr['%s']/td['%s']";
	public static final String MENU_BY_PAGE_NAME = "//div[@class='sidebar-menu pb-24 space-y-6']//span[contains(text(),'%s')]";
	public static final String UPLOAD_FILE = "//input[@type='file']"; 
}
