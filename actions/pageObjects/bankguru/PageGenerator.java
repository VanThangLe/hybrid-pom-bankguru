package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
/*	public static AddAccountPageObject getAddAccountPage(WebDriver driver) {
		return new AddAccountPageObject(driver);
	}
	
	public static AccountListPageObject getAccountListPage(WebDriver driver) {
		return new AccountListPageObject(driver);
	}

	public static DetailAccountPageObject getDetailAccountPage(WebDriver driver) {
		return new DetailAccountPageObject(driver);
	}

	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}
	
	public static AddCardPageObject getAddCardPage(WebDriver driver) {
		return new AddCardPageObject(driver);
	}
	
	public static CardListPageObject getCardListPage(WebDriver driver) {
		return new CardListPageObject(driver);
	}

	public static DetailCardPageObject getDetailCardPage(WebDriver driver) {
		return new DetailCardPageObject(driver);
	}

	public static EditCardPageObject getEditCardPage(WebDriver driver) {
		return new EditCardPageObject(driver);
	}
	
	public static AddCardReaderPageObject getAddCardReaderPage(WebDriver driver) {
		return new AddCardReaderPageObject(driver);
	}
	
	public static CardReaderListPageObject getCardReaderListPage(WebDriver driver) {
		return new CardReaderListPageObject(driver);
	}

	public static DetailCardReaderPageObject getDetailCardReaderPage(WebDriver driver) {
		return new DetailCardReaderPageObject(driver);
	}

	public static EditCardReaderPageObject getEditCardReaderPage(WebDriver driver) {
		return new EditCardReaderPageObject(driver);
	}
	
	public static AddCardStandardPageObject getAddCardStandardPage(WebDriver driver) {
		return new AddCardStandardPageObject(driver);
	}
	
	public static CardStandardListPageObject getCardStandardListPage(WebDriver driver) {
		return new CardStandardListPageObject(driver);
	}

	public static DetailCardStandardPageObject getDetailCardStandardPage(WebDriver driver) {
		return new DetailCardStandardPageObject(driver);
	}

	public static EditCardStandardPageObject getEditCardStandardPage(WebDriver driver) {
		return new EditCardStandardPageObject(driver);
	}
	
	public static AddControllerPageObject getAddControllerPage(WebDriver driver) {
		return new AddControllerPageObject(driver);
	}
	
	public static ControllerListPageObject getControllerListPage(WebDriver driver) {
		return new ControllerListPageObject(driver);
	}

	public static DetailControllerPageObject getDetailControllerPage(WebDriver driver) {
		return new DetailControllerPageObject(driver);
	}

	public static EditControllerPageObject getEditControllerPage(WebDriver driver) {
		return new EditControllerPageObject(driver);
	}
	
	public static AddEntryPageObject getAddEntryPage(WebDriver driver) {
		return new AddEntryPageObject(driver);
	}
	
	public static EntryListPageObject getEntryListPage(WebDriver driver) {
		return new EntryListPageObject(driver);
	}

	public static DetailEntryPageObject getDetailEntryPage(WebDriver driver) {
		return new DetailEntryPageObject(driver);
	}

	public static EditEntryPageObject getEditEntryPage(WebDriver driver) {
		return new EditEntryPageObject(driver);
	}
	
	public static AddFaceReaderPageObject getAddFaceReaderPage(WebDriver driver) {
		return new AddFaceReaderPageObject(driver);
	}
	
	public static FaceReaderListPageObject getFaceReaderListPage(WebDriver driver) {
		return new FaceReaderListPageObject(driver);
	}

	public static DetailFaceReaderPageObject getDetailFaceReaderPage(WebDriver driver) {
		return new DetailFaceReaderPageObject(driver);
	}

	public static EditFaceReaderPageObject getEditFaceReaderPage(WebDriver driver) {
		return new EditFaceReaderPageObject(driver);
	}
	
	public static AddPermissionPageObject getAddPermissionPage(WebDriver driver) {
		return new AddPermissionPageObject(driver);
	}
	
	public static PermissionListPageObject getPermissionListPage(WebDriver driver) {
		return new PermissionListPageObject(driver);
	}

	public static DetailPermissionPageObject getDetailPermissionPage(WebDriver driver) {
		return new DetailPermissionPageObject(driver);
	}

	public static EditPermissionPageObject getEditPermissionPage(WebDriver driver) {
		return new EditPermissionPageObject(driver);
	}
	
	public static AddProjectPageObject getAddProjectPage(WebDriver driver) {
		return new AddProjectPageObject(driver);
	}
	
	public static ProjectListPageObject getProjectListPage(WebDriver driver) {
		return new ProjectListPageObject(driver);
	}

	public static DetailProjectPageObject getDetailProjectPage(WebDriver driver) {
		return new DetailProjectPageObject(driver);
	}

	public static EditProjectPageObject getEditProjectPage(WebDriver driver) {
		return new EditProjectPageObject(driver);
	}
	
	public static AddUserPageObject getAddUserPage(WebDriver driver) {
		return new AddUserPageObject(driver);
	}
	
	public static UserListPageObject getUserListPage(WebDriver driver) {
		return new UserListPageObject(driver);
	}

	public static DetailUserPageObject getDetailUserPage(WebDriver driver) {
		return new DetailUserPageObject(driver);
	}

	public static EditUserPageObject getEditUserPage(WebDriver driver) {
		return new EditUserPageObject(driver);
	}
	
	public static AddUserGroupPageObject getAddUserGroupPage(WebDriver driver) {
		return new AddUserGroupPageObject(driver);
	}
	
	public static UserGroupListPageObject getUserGroupListPage(WebDriver driver) {
		return new UserGroupListPageObject(driver);
	}

	public static DetailUserGroupPageObject getDetailUserGroupPage(WebDriver driver) {
		return new DetailUserGroupPageObject(driver);
	}

	public static EditUserGroupPageObject getEditUserGroupPage(WebDriver driver) {
		return new EditUserGroupPageObject(driver);
	}
	
	public static AddUserTypePageObject getAddUserTypePage(WebDriver driver) {
		return new AddUserTypePageObject(driver);
	}
	
	public static UserTypeListPageObject getUserTypeListPage(WebDriver driver) {
		return new UserTypeListPageObject(driver);
	}

	public static DetailUserTypePageObject getDetailUserTypePage(WebDriver driver) {
		return new DetailUserTypePageObject(driver);
	}

	public static EditUserTypePageObject getEditUserTypePage(WebDriver driver) {
		return new EditUserTypePageObject(driver);
	}

	public static AssignUserPageObject getAssignUserPage(WebDriver driver) {
		return new AssignUserPageObject(driver);
	}*/
}
