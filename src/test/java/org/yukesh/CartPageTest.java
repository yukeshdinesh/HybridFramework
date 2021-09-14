package org.yukesh;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPageObjects;
import pageObjects.InventoryPageObjects;
import pageObjects.LoginPageObjects;

public class CartPageTest extends BaseClass{
	
	LoginPageObjects loginPageObjects;
	InventoryPageObjects inventoryPageObjects;
	CartPageObjects cartPageObjects;
	WebDriver driver= BaseClass.setup();
	
	@Test(groups = "Regression")
	public void Login_Addtocart_Gotocart() throws IOException {
		loginPageObjects = new LoginPageObjects(driver);
		inventoryPageObjects = new InventoryPageObjects(driver);
		cartPageObjects = new CartPageObjects(driver);
		
		//Launch the browser and webpage then login with standard login
		driver.get(getProp("URL"));
		loginPageObjects.siginin("Standard");
		String titleString = driver.getTitle();
		Assert.assertEquals(titleString, "Swag Labs");
		
		//Add product 1 to cart and check
		inventoryPageObjects.AddtoCart("BackPack");
		System.out.println(inventoryPageObjects.CartCount());
		Assert.assertEquals(inventoryPageObjects.CartCount(), "1");
		
		//Add product 2 to cart and check
		inventoryPageObjects.AddtoCart("BikeLight");
		System.out.println(inventoryPageObjects.CartCount());
		Assert.assertEquals(inventoryPageObjects.CartCount(), "2");
		
		//Tap on shopping cart 
		inventoryPageObjects.TapOnCart();
		
		//Verify the cart page
		cartPageObjects.verifyCartPage();
		cartPageObjects.VerifyProducts("BackPack");
		cartPageObjects.VerifyProducts("BikeLight");
		cartPageObjects.SelectCheckout();
		
		
	}
	

}
