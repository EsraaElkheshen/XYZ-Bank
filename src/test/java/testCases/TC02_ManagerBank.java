package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankMangerPage;
import pages.PageBase;

import static util.Utility.generateRandomFirstName;

public class TC02_ManagerBank extends TestBase{
  static String first_last_Name= generateRandomFirstName();
   String code = "123456";
    public static String name= "Harry Potter";

    @Test(priority =1 ,description = "click on Bank Manager Page")
    public void clickOnBankManagerPage() {
        new PageBase(driver).clickOnBankManagerLogin();
    }

    @Test(priority =2 ,description = "add New Customer")
    public void addNewCustomer() {
        new BankMangerPage(driver).addCustomer().enterFirstName(first_last_Name).enterLastName(first_last_Name).enterPostCode(code).clickOnAddBtn();
        new PageBase(driver).handleAlert();
    }

    @Test(priority =3 ,description = "open Account ")
    public void clickOnOpenAccount() {
        new BankMangerPage(driver).clickOnOpenAccount();
    }

    @Test(priority =4 ,description = "open New Account ")
    public void openNewAccount() {
        new BankMangerPage(driver).selectCustomerNameFromDrpDwn(name).selectCurrencyFromDrpDwn("Dollar")
                .clickOnProcessBtn();
        new PageBase(driver).handleAlert();
    }

    @Test(priority =5 ,description = "open Customers Page ")
    public void clickOnCustomers() {
        new BankMangerPage(driver).clickOnCustomers().enterSearchData(first_last_Name);
        Assert.assertEquals(new BankMangerPage(driver).getSearchResult(1),first_last_Name);
        Assert.assertEquals(new BankMangerPage(driver).getSearchResult(2),first_last_Name);
    }

    @Test(priority =6 ,description = "return Home")
    public void returnHome() {
        new PageBase(driver).returnHome();
    }

}
