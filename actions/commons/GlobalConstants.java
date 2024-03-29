package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";
	
	public static final String REGISTER_EMAIL = "thanglevan0001@gmail.com";
	
	public static final String REGISTER_LINK = "https://demo.guru99.com/";
	public static final String LOGIN_LINK = "https://demo.guru99.com/v4/";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
}
