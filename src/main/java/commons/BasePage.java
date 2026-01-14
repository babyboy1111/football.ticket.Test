package commons;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.Set;

public class BasePage extends BaseTest {

    private WebDriver driver;

    WebDriverWait explicitWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public BasePage() {

    }




    public static BasePage getBasePage(){
        return new BasePage();
    }

    public WebElement getElement(WebDriver driver,String locator){
        return driver.findElement(By.xpath(locator));
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
       return  driver.getCurrentUrl();
    }

    public void waitAlertPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }


    public void switchToCurrentWindow(WebDriver driver ){
        Set<String> allWindows = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();

// Switch sang tab mới
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public void switchToWindowByID( WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowID : allWindows) {
            if (!windowID.equals(parentID)) {
                driver.switchTo().window(windowID);
                break;
            }
        }
        driver.switchTo().window(parentID);

    }



    public WebElement waitForElementClickable(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator).click();
    }

    public WebElement waitForElementVisible(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }



    public void acceptCookie(WebDriver driver){
        try {
           WebElement acceptButton = waitForElementClickable(driver,"//button[contains(text(),'Accept')]");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptButton);
        } catch (TimeoutException ignored) {}
    }
}
