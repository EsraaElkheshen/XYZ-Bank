package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerLoginPage;
import pages.PageBase;

public class TC01_CustomerLogin extends TestBase{

  public static String name= "Harry Potter";

    @Test(priority =1 ,description = "Login On Customer Page")
    public void LoginOnCustomerPage() {
        new PageBase(driver).clickOnCustomerLogin();
        Assert.assertTrue(new CustomerLoginPage(driver).dropDownNameIsDisplay(), "Name is Displayed");
    }

    @Test(priority =2 ,description = "Open Customer Page")
    public void openCustomerPage() {
        new CustomerLoginPage(driver).selectName(name).clickOnLogin();
        Assert.assertEquals(new CustomerLoginPage(driver).getName(),name);
    }
    @Test(priority =3 ,description = "getResultDate")
    public void getResultData() {
        new CustomerLoginPage(driver).openDepositPage();
        System.out.println("Account Number is :" + new CustomerLoginPage(driver).getResult(1));
        System.out.println("Balance is :" + new CustomerLoginPage(driver).getResult(2));
        System.out.println("Currency is :" + new CustomerLoginPage(driver).getResult(3));
    }

    @Test(priority =4 ,description = "Add Deposit")
    public void addDeposit() {
        new CustomerLoginPage(driver).enterAmount("500").clickOnDepositBtn();
        Assert.assertEquals(new CustomerLoginPage(driver).getDepositMsg(),"Deposit Successful");
    }

    @Test(priority =5 ,description = "Open WithDraw")
    public void openWithDraw() {
        new CustomerLoginPage(driver).clickOnWithDraw();
        Assert.assertTrue(new CustomerLoginPage(driver).withDrawTextIsDisplay());
    }

    @Test(priority =6 ,description = "enter amount WithDraw")
    public void enterAmountOfWithDraw() {
        new CustomerLoginPage(driver).enterAmountOFWithDrawl("100").clickOnWithDrawBTN();
        Assert.assertEquals(new CustomerLoginPage(driver).getTransactionMsg(), "Transaction successful");
    }

    @Test(priority =7 ,description = "Logout")
    public void logOut() {
        new PageBase(driver).logOut();
    }




}
