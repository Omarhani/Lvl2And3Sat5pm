package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckOutPage extends MethodHandles {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private By continueButtonBillingAddress = By.cssSelector("#billing-buttons-container > [name='save']");

    private By continueButtonShippingMethod = By.cssSelector("#shipping-method-buttons-container > button");

    private By continueButtonPaymentMethod = By.cssSelector("#payment-method-buttons-container> button");

    private By continueButtonPaymentInfo  = By.cssSelector("#payment-info-buttons-container > button");
    private By confirmButton = By.cssSelector("#confirm-order-buttons-container >button");
    private void clickOnContinueButtonBillingAddress (){
        click(continueButtonBillingAddress);
    }
    private void clickOnContinueButtonShippingMethod(){
        click(continueButtonShippingMethod);
    }
    private void clickOnContinueButtonPaymentMethod(){
        click(continueButtonPaymentMethod);
    }
    private void clickOnContinueButtonPaymentInfo(){
        click(continueButtonPaymentInfo);
    }
    private CompletePage clickOnConfirmButton(){
        click(confirmButton);
        return new CompletePage(driver);
    }
    public CompletePage checkOut(){
        clickOnContinueButtonBillingAddress();
        clickOnContinueButtonShippingMethod();
        clickOnContinueButtonPaymentMethod();
        clickOnContinueButtonPaymentInfo();
        clickOnConfirmButton();
        return new CompletePage(driver);
    }
}
