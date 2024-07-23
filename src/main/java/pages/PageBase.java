package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.fail;

public class PageBase {

    WebDriver driver;
    private final By CUSTOMER_LOGIN_BTN = By.xpath("//button[normalize-space()='Customer Login']");
    private final By BANK_MANAGER_BTN = By.xpath("//button[normalize-space()='Bank Manager Login']");
    private final By LOG_OUT_BTN = By.xpath("//button[@class='btn logout']");
    private final By HOME = By.xpath("//button[text()='Home']");


    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public PageBase selectByVisibleText(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
        return this;
    }

    public PageBase logOut() {
        driver.findElement(this.LOG_OUT_BTN).click();
        return this;
    }

    public PageBase returnHome() {
        driver.findElement(this.HOME).click();
        return this;
    }

    public PageBase clickOnCustomerLogin() {
        driver.findElement(this.CUSTOMER_LOGIN_BTN).click();
        return this;
    }

    public PageBase clickOnBankManagerLogin() {
        driver.findElement(this.BANK_MANAGER_BTN).click();
        return this;
    }

    public PageBase scrollIntoView(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
        return this;
    }

    public PageBase handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    // handel explicit wait
    public static void explicitWaitForClickable(WebDriver driver, By element) {
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void explicitWaitForVisibility(WebDriver driver, By element) {
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    // handel fluent wait
    public static void fluentWaitHandling(WebDriver driver, By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void fail(String message) {
        if (message == null) {
            throw new AssertionError();
        } else {
            throw new AssertionError(message);
        }
    }

    // long explicit wait
    public static WebDriverWait longWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // short explicit wait
    public static WebDriverWait shortWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // TODO: hover over web element
    public void hoverWebElement(WebDriver driver, WebElement element) {
        // Creating object of an Actions class
        Actions action = new Actions(driver);
        // Performing the mouse hover action on the target element.
        action.moveToElement(element).perform();
    }

    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/screenShoots/" + screenshotName + System.currentTimeMillis() + ".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //wait for java script running
    public static void waitForPageLoad(WebDriver driver) {
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                //System.out.println("Ready State: " + readyState);
                return (Boolean) readyState.equals("complete");
            }
        });
    }

}


