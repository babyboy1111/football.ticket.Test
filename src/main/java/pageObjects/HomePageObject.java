package pageObjects;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.HomePageUI;

import java.time.Duration;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;


    HomePageUI homePageUI = new HomePageUI();
    public HomePageObject(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    }

    public TicketSelectPageObject clickToBuyButton() {
        WebElement buyNow = waitForElementClickable(driver,homePageUI.BUY_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyNow);
        return new TicketSelectPageObject(driver); // chuyển driver sang ticket page
    }


}
