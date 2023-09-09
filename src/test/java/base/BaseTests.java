package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class BaseTests {

    WebDriver driver;
    protected HomePage homePage;
    protected ReadDataFromJson readDataFromJson;

    @BeforeClass
    public void setUp() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get(readDataFromJson.readJsonFile().URL);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
