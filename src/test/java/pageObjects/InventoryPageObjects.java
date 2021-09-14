package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPageObjects {
	WebDriver driver;
	
	public InventoryPageObjects(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "add-to-cart-sauce-labs-backpack")
	WebElement Saucelab_Backpack;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement Saucelab_bikelight;
	
	@FindBy(css = "#shopping_cart_container > a > span")
	WebElement cartElements;
	
	@FindBy(className = "shopping_cart_link")
	WebElement Shoppingcart;
	
	
	public void AddtoCart(String s) {
		
		switch (s) {
		case "BackPack":
			Saucelab_Backpack.click();
			break;
		case "BikeLight":
			Saucelab_bikelight.click();
			break;
		default:
			Saucelab_Backpack.click();
			break;
		}
		
	}
	
	public String CartCount() {
		
		return cartElements.getText();
	}
	
	public void TapOnCart() {
		Shoppingcart.click();
	}
}
