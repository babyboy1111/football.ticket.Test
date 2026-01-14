
/**

 Scenario:
 - Navigate to the Champions League Final 2025 page
 - Accept cookies
 - Click Buy Now on homepage
 - Redirect to ticket page
 - Click Buy button on ticket page
 - Handle single-seat popup if present
 - Verify redirection to checkout/cart page
 */
package com.footballticket.tescase;

import commons.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.TicketSelectPageObject;

import java.time.Duration;


public class TC_03_TicketSelection extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {

        driver = getBrowserDriver(browser);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.footballticketnet.com/champions-league/champions-league-final-2025");

        acceptCookie(driver);
    }

    @Test
    public void testTicketPurchaseFlow() {

        // Step 1: Click Buy Now on homepage
        HomePageObject homePage = new HomePageObject(driver);
        TicketSelectPageObject ticketPage = homePage.clickToBuyButton();

        // Step 2: Click Buy button on ticket page
        switchToCurrentWindow(driver);


        ticketPage.clickBuyButton();

        // Step 3: Wait for checkout page
        wait.until(ExpectedConditions.urlContains("checkout"));

        // Step 4: Verify checkout page loaded
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),
                "Checkout page did not load correctly.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}