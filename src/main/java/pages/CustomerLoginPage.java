package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.fail;
import static pages.PageBase.shortWait;

public class CustomerLoginPage {
   WebDriver driver;
   private final By NAME = By.id("userSelect");
   private final By LOGIN_BTN = By.xpath("//button[@type='submit']");
   private final By TEXT = By.xpath("//label[text()='Your Name :']");
   private final By NAME_VALUE = By.xpath("(//span [contains(@class,'ng-binding')])[1]");
   private final By DEPOSIT = By.xpath("//button[@ng-class='btnClass2']");
   private final By AMOUNT = By.xpath("//input[@type='number']");
   private final By DEPOSIT_BTN = By.xpath("//button[@type='submit']");
   private final By DEPOSIT_MSG = By.xpath("//span[text()='Deposit Successful']");
   private final By WITH_DRAW_BTN = By.xpath("//button[@type='submit']");
   private final By WITH_DRAW = By.xpath("//button[normalize-space()='Withdrawl']");
   private final By TRANS_MSG = By.xpath("//span[text()='Transaction successful']");
   private final By AMOUNT_WITHDRAWAL = By.xpath("//input[@ng-model='amount']");
    private final By WITHDRAWAL_TEXT = By.xpath("//*[text()='Amount to be Withdrawn :']");

    public boolean withDrawTextIsDisplay(){
        System.out.println(driver.findElement(this.WITHDRAWAL_TEXT).getText());
        return driver.findElement(this.WITHDRAWAL_TEXT).isDisplayed();
    }
    public String getName(){
        System.out.println(driver.findElement(this.NAME_VALUE).getText());
        return driver.findElement(this.NAME_VALUE).getText();
    }

    public CustomerLoginPage clickOnWithDraw(){
        driver.findElement(this.WITH_DRAW).click();
        return this;
    }
    public CustomerLoginPage clickOnWithDrawBTN(){
        driver.findElement(this.WITH_DRAW_BTN).click();
        return this;
    }

   public boolean dropDownNameIsDisplay(){
        System.out.println(driver.findElement(this.TEXT).getText());
       return driver.findElement(this.TEXT).isDisplayed();
   }

    public CustomerLoginPage(WebDriver driver){
        this.driver= driver;
    }

    public CustomerLoginPage selectName(String value){
        new PageBase(driver).selectByVisibleText(this.NAME,value);
        return this;
    }

    public CustomerLoginPage clickOnLogin(){
        driver.findElement(this.LOGIN_BTN).click();
        return this;
    }

    public CustomerLoginPage openDepositPage(){
        driver.findElement(this.DEPOSIT).click();
        return this;
    }

    public CustomerLoginPage enterAmount(String amount){
        driver.findElement(this.AMOUNT).sendKeys(amount);
        return this;
    }

    public CustomerLoginPage clickOnDepositBtn(){
        driver.findElement(this.DEPOSIT_BTN).click();
        return this;
    }

    public String getResult(int number){
       return  driver.findElement(By.xpath("(//div[@ng-hide='noAccount']/strong)["+number+"]")).getText();
    }

    public String getDepositMsg(){
        return  driver.findElement(this.DEPOSIT_MSG).getText();
    }

    public String getTransactionMsg(){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.TRANS_MSG));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }
        return  driver.findElement(this.TRANS_MSG).getText();
    }

    public CustomerLoginPage enterAmountOFWithDrawl(String amount){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.AMOUNT_WITHDRAWAL));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }
        driver.findElement(this.AMOUNT_WITHDRAWAL).sendKeys(amount);
        System.out.println(driver.findElement(this.AMOUNT_WITHDRAWAL).getText());
        return this;
    }






}
