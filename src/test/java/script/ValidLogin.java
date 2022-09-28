package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{

	@Test(priority = 1)
	public void testValidLogin() {
//		get the data from excel file
		String un=Utility.getXlData(XLPATH, "ValidLogin",1, 0);
		String pw=Utility.getXlData(XLPATH, "ValidLogin",1, 1);
		
//		1. Enter valid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		test.info("Enter valid user name:"+un);
		
//		2. Enter Valid password
		loginPage.setPassword(pw);
		test.info("Enter Valid password:"+pw);
		
//		3. click on login button
		loginPage.clickLoginButton();
		test.info("click on login button");
		
//		4. Verify that home page should be displayed
		EnterTimeTrackPage ettPage=new EnterTimeTrackPage(driver);
		boolean result = ettPage.verifyLogoutLinkIsDisplayed(wait);
		Assert.assertEquals(result, true,"Home page is not displayed");
		test.pass("Home page is displayed");

	}
}
