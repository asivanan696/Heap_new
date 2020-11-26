package pompages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BaseTest;

public class LoginPage extends BaseTest{

	//	declare the elements

	@FindBy(xpath="//*[@id='form_title_text']/img")
	private WebElement logo;


	@FindBy(xpath="//*[@id='group_list']")
	private WebElement grp;

	@FindBy(xpath="//*[@id='username']")
	private WebElement username;

	@FindBy(xpath="//*[@id='password_input']")
	private WebElement password;


	@FindBy(name="username")
	private WebElement  Sun;

	@FindBy(name="password")
	private WebElement Spwd;

	@FindBy(name="Login")
	private WebElement loginbtn;
	@FindBy(name="Continue")
	private WebElement Continuebtn;

	@FindBy(id="fromDate")
	private WebElement frmdate;

	@FindBy(id="toDate")
	private WebElement todate;
	@FindBy(xpath="//*[@id='btnSearch']/i")
	private WebElement dateclick;

////
	
	@FindBy(xpath="//*[contains(@id,'dated_')]")
	private WebElement Mon;
	

	

	
	@FindBy(xpath="(//*[contains(@id,'dated_')])[3]")
	private WebElement Tue;
	
	@FindBy(xpath="(//*[contains(@id,'dated_')])[5]")
	private WebElement Wed;
	
	@FindBy(xpath="(//*[contains(@id,'dated_')])[7]")
	private WebElement Thu;
	
	@FindBy(xpath="(//*[contains(@id,'dated_')])[9]")
	private WebElement Fri;

	
	
	//initialize the elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginpagetitle() {
		return driver.getTitle();

	}
	public boolean logoimg() {
		
		return logo.isDisplayed();

	}
	public void group(String s) {	
		Select list=new Select (grp);
		//List<WebElement> options =list.getOptions();
		list.selectByVisibleText(s);
		grp.click();



	}

	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);

	}

	public void login2(String un, String pwd) {
		Sun.sendKeys(un);
		Spwd.sendKeys(pwd);

	}

	public void clicklogin() {
		loginbtn.click();

	}
	public void contilogin() {
		Continuebtn.click();
	}

	public void fromdate(String fdate) {

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(frmdate));

		frmdate.clear();
			frmdate.sendKeys(fdate);

	}
	public void todate(String tdate) {

			todate.clear();
			todate.sendKeys(tdate);

	}
	public void dateclick() {
		dateclick.click();

	}
	public void addtask() throws InterruptedException {
		Thread.sleep(5000);
		Mon.click();
		
		
		Tue.click();
		Wed.click();
		Thu.click();
		Fri.click();

	}
	
}