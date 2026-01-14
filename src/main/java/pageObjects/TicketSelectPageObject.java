package pageObjects;

import commons.BasePage;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.TicketSelectPageUI;

import java.time.Duration;

public class TicketSelectPageObject extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    TicketSelectPageUI ticketSelectPageUI = new TicketSelectPageUI();
    public TicketSelectPageObject(WebDriver driver){
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void clickBuyButton() {
        WebElement buyBtn = waitForElementClickable(driver,ticketSelectPageUI.BUY_TICKET_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyBtn);
    }


    public static void selectHiddenDropdownByValue(WebDriver driver, String dropdownLocator, String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the form to be present
        WebElement form = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[contains(@action,'checkout')]")));



        WebElement dropdown = form.findElement(By.xpath(dropdownLocator));



        // Make the dropdown visible using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", dropdown);

        // Use Select to choose the value
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

}



