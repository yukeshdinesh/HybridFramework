package org.yukesh;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.InventoryPageObjects;
import pageObjects.LoginPageObjects;



public class InventoryTest extends BaseClass{
	LoginPageObjects loginPageObjects;
	InventoryPageObjects inventoryPageObjects;
	WebDriver driver= BaseClass.setup();
	
		@Test(groups = "Regression")
		public void Login_Addtocart() throws IOException {
			loginPageObjects = new LoginPageObjects(driver);
			inventoryPageObjects = new InventoryPageObjects(driver);
			
			
			driver.get(getProp("URL"));
			loginPageObjects.siginin("Standard");
			String titleString = driver.getTitle();
			Assert.assertEquals(titleString, "Swag Labs");
			
			inventoryPageObjects.AddtoCart("BackPack");
			System.out.println(inventoryPageObjects.CartCount());
			Assert.assertEquals(inventoryPageObjects.CartCount(), "1");
			
			
			inventoryPageObjects.AddtoCart("BikeLight");
			System.out.println(inventoryPageObjects.CartCount());
			Assert.assertEquals(inventoryPageObjects.CartCount(), "2");
		}
		
		

}
