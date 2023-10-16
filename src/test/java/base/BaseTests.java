package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTests {

    WebDriver driver;
    protected HomePage homePage;
    protected ReadDataFromJson readDataFromJson;
    UtilsTests utilsTests;
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
//        readDataFromJson = new ReadDataFromJson();
        setUpBrowser(browser);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        readDataFromJson = new ReadDataFromJson();
        ScreenRecorderUtil.startRecord(method.getName());
        driver.get(readDataFromJson.readJsonFile().URL);

    }

    @Parameters("browser")
    public void setUpBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("headlessChrome")){
            ChromeOptions options = new ChromeOptions();
//            options.setHeadless(true);
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("headlessFirefox")) {
            FirefoxOptions options = new FirefoxOptions();
//            options.setHeadless(true);
            driver = new FirefoxDriver(options);
        }
    }
    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method.getName());
        utilsTests.setStatus(method,result);
        ScreenRecorderUtil.stopRecord();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeSuite
    public void start(){
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }
    @AfterSuite
    public void end(){
        utilsTests = new UtilsTests(driver);
        utilsTests.flush();
    }

}
