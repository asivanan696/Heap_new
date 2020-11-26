package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;

import pompages.LoginPage;

public class TestValidLoginPage extends BaseTest{
	 

 @Test
	public void logintitle() throws InterruptedException, EncryptedDocumentException, IOException {
	 LoginPage login =new LoginPage();

	 String s = Lib.getcelldata("login", "student Details", 1, 2);
	 login.group(s);
		String un = Lib.getcelldata("login", "student Details", 1, 0);
		System.out.println("value is " + un);
		String pwd = Lib.getcelldata("login", "student Details", 1, 1);
		System.out.println("value is " +pwd);
		login.login(un, pwd);
		login.clicklogin();
		
		
		login.login2(un, pwd);
		login.contilogin();
	//String s = Lib.getcelldata("gfgcontribute", "login", 1, 2);

		//		AssertJUnit.assertEquals(title,"I Don't know");
		
		String fdate = Lib.getcelldata("login", "student Details", 1, 3);
		login.fromdate(fdate);
		Thread.sleep(5000);
		String tdate = Lib.getcelldata("login", "student Details", 1, 4);
		login.todate(tdate);
		
		login.dateclick();
		login.addtask();
 }


		public void Entry() {
		String data="";
		for (int i=1;i<=6;i++) {
			while(data!=null)
		data = Lib.getcelldata("login", "student Details", i, 5);
		System.out.println(data);
		
		}
		}
}
	//	}
		

 

	

