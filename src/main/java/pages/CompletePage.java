package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CompletePage extends MethodHandles {
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    private By validationMessage = By.xpath("//h1[contains(text(),'Thank you')]");

    public String getValidationMessage(){
        wait1(validationMessage);
        return getText(validationMessage);
    }
}
