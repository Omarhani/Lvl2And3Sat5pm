package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By loginLink = By.cssSelector(".ico-login");

    private By computers = By.partialLinkText("Computers");

    private By noteBooks = By.partialLinkText("Notebooks");

    public LoginPage clickOnLoginLink(){
        click(loginLink);
        return new LoginPage(driver);
    }
    private void hoverOverComputers(){
        moveToElement(computers);
    }
    private void clickOnNoteBooks(){
        click(noteBooks);
    }

    public NotBooksPage moveToNoteBook(){
        hoverOverComputers();
        clickOnNoteBooks();
        return new NotBooksPage(driver);
    }


}
