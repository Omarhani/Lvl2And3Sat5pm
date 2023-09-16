package login;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataDrivenFromJson;

import java.io.IOException;

public class LoginTests extends BaseTests {
    ReadDataDrivenFromJson readDataDrivenFromJson;

    @DataProvider
    public Object[] testDataForSuccessfulLogin() throws IOException, ParseException {
        readDataDrivenFromJson = new ReadDataDrivenFromJson();
        return readDataDrivenFromJson.testDataForSuccessfulLogin();
    }

    // Omar,123
    // Mohamed,456


    @Test(dataProvider = "testDataForSuccessfulLogin")
    public void t(String data){
        String users[]=data.split(",");

        LoginPage loginPage =homePage.clickOnLoginLink();
        loginPage.insertUsername(users[0]);
        loginPage.insertPassword(users[1]);
    }




}
