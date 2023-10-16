package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CartPage extends MethodHandles {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productName= By.cssSelector(".product-name");
    private By agreeCheckBox = By.id("termsofservice");

    private By checkOutButton= By.id("checkout");

    public String getProductName(){
        return getText(productName);
    }

    public void clickOnCheckBox(){
        click(agreeCheckBox);
    }
    public CheckOutPage clickOnCheckOutButton(){
        click(checkOutButton);
        return new CheckOutPage(driver);
    }
}
