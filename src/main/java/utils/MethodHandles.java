package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;
    Actions actions;

    WebDriverWait wait;
    private By loader = By.cssSelector(".ajax-loading-block-window");

    public MethodHandles(WebDriver driver){
        this.driver =driver;
    }

    private void loaderWait(){
        try {
            wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        }catch (NoSuchElementException e){

        }

    }

    protected void moveToElement(By locator){
        loaderWait();
        for (int i = 0 ;i<10;i++) {
            try {

                explicitWait(locator, 10);
                actions = new Actions(driver);
                actions.moveToElement(driver.findElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected String getText(By locator){
        loaderWait();
        String text = null;
        for (int i = 0 ;i<10;i++){
            try {

                explicitWait(locator,10);
                text = webElement(locator).getText();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return text;

    }

    protected void click(By locator){
        loaderWait();

        for (int i = 0 ;i<10;i++){
            try {
                explicitWait(locator,10);
                webElement(locator).click();
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }

    protected void sendKeys(By locator,String text){
        loaderWait();

        for (int i = 0;i<10;i++){
            try {
                explicitWait(locator,15);
                webElement(locator).sendKeys(text);
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    private void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
    }

    protected void invisibilityOf(By locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(driver.findElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)));
    }
    protected void wait1(By locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(locator,"Thank you"));
    }

    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }



}
