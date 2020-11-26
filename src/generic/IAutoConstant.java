package generic;

public interface IAutoConstant {

	//Store path of all the project files
	
	String CONFIGFILEPATH=".\\config.properties";
	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE ="./Drivers/chromedriver.exe";
	
	String  EXCEL_FILE_PATH= "./testdata/";
	String SCREENSHOTS_PATH="./Screenshots/";
	static int PAGE_LOAD_TIMEOU = 20;
	static int IMPLICIT_WAIT = 20;
	
}
