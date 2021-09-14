package org.yukesh;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pageObjects.CartPageObjects;
import pageObjects.InventoryPageObjects;
import pageObjects.LoginPageObjects;
import utility.TestListener;

@Listeners(TestListener.class)
@Epic("Login ")
@Feature("Login Scenarios")
public class LoginTest extends BaseClass{
	LoginPageObjects loginPageObjects;
	InventoryPageObjects inventoryPageObjects;
	CartPageObjects cartPageObjects;
	WebDriver driver= BaseClass.setup();
	String ErrorString;
	
	
	
	@Test(groups = "Smoke",description = "Verify User should not login with invalid creds")
	@Description("UN: Invalid, Pwd: secure")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Login Scenario - Negative")
	@Step("Login step with UN: Invalid, Pwd: secure")
	
	public void Invalid_Login() throws IOException {
		loginPageObjects = new LoginPageObjects(driver);
		inventoryPageObjects = new InventoryPageObjects(driver);
		
		
		driver.get(getProp("URL"));
		loginPageObjects.siginin("Invalid");
		ErrorString =loginPageObjects.getError();
		Assert.assertEquals(ErrorString, "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	@Test(groups = "Smoke",description = "Verify User should login with valid creds")
	@Description("UN: valid, Pwd: secure")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Login Scenario - Positive")
	@Step("Login step with UN: valid, Pwd: secure")
	public void valid_Login() throws IOException {
		loginPageObjects = new LoginPageObjects(driver);
		inventoryPageObjects = new InventoryPageObjects(driver);
		
		
		driver.get(getProp("URL"));
		loginPageObjects.siginin("Standard");
		String titleString = driver.getTitle();
		Assert.assertEquals(titleString, "Swag Labs");
		
	}
	
	@Description("UN: valid, Pwd: no")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Login Scenario - Negative")
	@Test(groups = "Regression",description = "Verify User should not login with invalid creds")
	@Step("Login step with UN: Invalid, Pwd: no ")
	public void Invalid_Login_No_Pwd() throws IOException {
		loginPageObjects = new LoginPageObjects(driver);
		inventoryPageObjects = new InventoryPageObjects(driver);
		
		
		driver.get(getProp("URL"));
		loginPageObjects.siginin("NoPwd");
		ErrorString =loginPageObjects.getError();
		Assert.assertEquals(ErrorString, "Epic sadface: Password is required");
	}
	
	@Description("UN: No, Pwd: valid")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Login Scenario - Negative")
	@Test(groups = "Regression",description = "Verify User should not login with invalid creds")
	@Step("Login step with UN: no, Pwd: secure")
	public void Invalid_Login_No_User() throws IOException {
		loginPageObjects = new LoginPageObjects(driver);
		inventoryPageObjects = new InventoryPageObjects(driver);
		
		
		driver.get(getProp("URL"));
		loginPageObjects.siginin("NoUser");
		ErrorString =loginPageObjects.getError();
		Assert.assertEquals(ErrorString, "Epic sadface: Username is required");
	}
	
	@Description("UN: valid, Pwd: no")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Login Scenario - Negative")
	@Test(groups = "Regression",description = "Verify User should not login with invalid creds",dataProvider = "getData")
	@Step("Login step with UN: {0}, Pwd: {1}")
	public void Many_Login(String un, String pwd) throws IOException {
		loginPageObjects = new LoginPageObjects(driver);
		inventoryPageObjects = new InventoryPageObjects(driver);
		
		
		driver.get(getProp("URL"));
		loginPageObjects.multiSiginin(un, pwd);
		String titleString = driver.getTitle();
		Assert.assertEquals(titleString, "Swag Labs");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] dataObjects = new Object[3][2];
		
		dataObjects[0][0] = "locked_out_user";
		dataObjects[0][1] = "secret_sauce";
		
		dataObjects[1][0] = "locked_out_user";
		dataObjects[1][1] = "secret_sauce";
		
		dataObjects[2][0] = "locked_out_user";
		dataObjects[2][1] = "secret_sauce";
		
		return dataObjects;
	}
	
		

}
