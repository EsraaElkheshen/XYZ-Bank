package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankMangerPage {
   WebDriver driver;
   private final By ADD_CUSTOMER_BTN = By.xpath("//button[normalize-space()='Add Customer']");
   private final By FIRSTNAME = By.xpath("//input[@placeholder='First Name']");
   private final By LASTNAME = By.xpath("//input[@placeholder='Last Name']");
    private final By POSTCODE = By.xpath("//input[@placeholder='Post Code']");
    private final By ADD_BTN = By.xpath("//button[@type='submit']");
    private final By OPEN_ACCOUNT = By.xpath("//button[normalize-space()='Open Account']");
    private final By CUSTOMER_NAME = By.id("userSelect");
    private final By CURRENCY = By.id("currency");
    private final By PROCESS_BTN = By.xpath("//button[@type='submit']");
    private final By CUSTOMERS_BTN = By.xpath("//button[normalize-space()='Customers']");
    private final By SEARCH_CUSTOMER = By.xpath("//input[@placeholder='Search Customer']");


    public BankMangerPage(WebDriver driver){
        this.driver= driver;
    }

    public BankMangerPage addCustomer(){
        driver.findElement(this.ADD_CUSTOMER_BTN).click();
        return this;
    }

    public BankMangerPage enterFirstName(String value){
        driver.findElement(this.FIRSTNAME).sendKeys(value);
        return this;
    }
    public BankMangerPage enterLastName(String value){
        driver.findElement(this.LASTNAME).sendKeys(value);
        return this;
    }
    public BankMangerPage enterPostCode(String value){
        driver.findElement(this.POSTCODE).sendKeys(value);
        return this;
    }
    public BankMangerPage clickOnAddBtn(){
        driver.findElement(this.ADD_BTN).click();
        return this;
    }

    public BankMangerPage clickOnOpenAccount(){
        driver.findElement(this.OPEN_ACCOUNT).click();
        return this;
    }

    public BankMangerPage selectCustomerNameFromDrpDwn(String value){
        new PageBase(driver).selectByVisibleText(this.CUSTOMER_NAME,value);
        return this;
    }

    public BankMangerPage selectCurrencyFromDrpDwn(String value){
        new PageBase(driver).selectByVisibleText(this.CURRENCY,value);
        return this;
    }
    public BankMangerPage clickOnProcessBtn(){
        driver.findElement(this.PROCESS_BTN).click();
        return this;
    }
    public BankMangerPage clickOnCustomers(){
        driver.findElement(this.CUSTOMERS_BTN).click();
        return this;
    }

    public BankMangerPage enterSearchData(String name){
        driver.findElement(this.SEARCH_CUSTOMER).sendKeys(name);
        return this;
    }

    public String getSearchResult(int number){
       return driver.findElement(By.xpath("//tr[1]/td[@class='ng-binding']["+number+"]")).getText();
    }
}
