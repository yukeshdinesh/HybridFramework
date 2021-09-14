package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPageObjects {
	WebDriver driver;
	
public  CartPageObjects(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}	

@FindBy(xpath = "(//*[@class='inventory_item_name'])[1]")
WebElement element1;

@FindBy(xpath = "(//*[@class='inventory_item_name'])[2]")
WebElement element2;

@FindBy(xpath = "(//*[starts-with(@id,'remove')])[1]")
WebElement remove;

@FindBy(id = "continue-shopping")
WebElement continueShopping;

@FindBy(id = "checkout")
WebElement checkout;

@FindBy(className = "title")
WebElement cartPageTitle;

public void verifyCartPage() {
	checkout.isDisplayed();
	continueShopping.isDisplayed();
	String titleString = cartPageTitle.getText();
	Assert.assertEquals(titleString, "YOUR CART");
	remove.isDisplayed();
	
}

public void VerifyProducts(String s) {
	
	switch (s) {
	case "BackPack":
		element1.isDisplayed();
		break;
		
	case "BikeLight":
		element2.isDisplayed();
		break;

	default:
		break;
	}
	
}

public void SelectCheckout() {
	checkout.click();
}


}
