package checkOut;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class CheckOutTests extends BaseTests {
    ReadDataFromJson readDataFromJson;


    @Test
    public void testEnd2End() throws FileNotFoundException, InterruptedException {
        readDataFromJson = new ReadDataFromJson();
        LoginPage loginPage = homePage.clickOnLoginLink();
        HomePage homePage1 = loginPage.loginFeature(readDataFromJson.readJsonFile().Login.ValidCredentials.Username
                ,readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
        NotBooksPage notBooksPage = homePage1.moveToNoteBook();
        notBooksPage.clickOnAddToCartButton();
        notBooksPage.clickOnAddToCartButton2();
        String expectedProduct = notBooksPage.getProductName();
        CartPage cartPage = notBooksPage.clickOnShoppingCart();
        assertEquals(expectedProduct,cartPage.getProductName());

        cartPage.clickOnCheckBox();
        CheckOutPage checkOutPage = cartPage.clickOnCheckOutButton();

        CompletePage completePage = checkOutPage.checkOut();
//        Thread.sleep(3000);
        assertEquals(completePage.getValidationMessage(),readDataFromJson.readJsonFile().ValidationMessage);


    }
}
