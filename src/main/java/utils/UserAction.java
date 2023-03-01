package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAction {

    WebDriver driver;

    public UserAction(WebDriver driver){
        this.driver=driver;

    }

    public void clickOnElement(WebElement element, long durationInSeconds){

        WebElement webElement = waitForElement(element,durationInSeconds);
        webElement.click();
    }

    public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {

        WebElement webElement = waitForElement(element,durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);

    }

    public WebElement waitForElement(WebElement element,long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch(Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    public String getTextFromElement(WebElement element,long durationInSeconds) {

        WebElement webElement = waitForElement(element,durationInSeconds);
        return webElement.getText();

    }

    public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {

        try {
            WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
            return webElement.isDisplayed();
        }catch(Throwable e) {
            return false;
        }

    }
}
