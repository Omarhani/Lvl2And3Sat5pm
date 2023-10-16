package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class NotBooksPage extends MethodHandles {
    public NotBooksPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton = By.cssSelector(".button-2.product-box-add-to-cart-button");
    private By addToCartButton2 = By.id("add-to-cart-button-4");

    private By productName = By.cssSelector("[class='product-name'] > h1");

    private By shoppingCart = By.cssSelector(".ico-cart");
    private By barNotification = By.id("bar-notification");

    private By closeButton = By.xpath("//span[@title='Close']");

    public void clickOnAddToCartButton(){
        click(addToCartButton);
    }
    public void clickOnAddToCartButton2(){
        click(addToCartButton2);
    }
    public String getProductName(){
        return getText(productName);
    }
    public CartPage clickOnShoppingCart(){
//        invisibilityOf(barNotification);
        click(closeButton);
        click(shoppingCart);
        return new CartPage(driver);
    }
}
