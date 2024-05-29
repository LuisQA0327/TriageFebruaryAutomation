package Automation_AI07;

import Day11_050724.ReusableMethods;
import Day13_051424.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Automation_AI07 extends TestParent {
    @Test
    public static void tc_001() {
        driver.navigate().to("https://www.fideliscare.org/");
        ReusableMethods.clickMethod(driver, "//*[contains(text() , 'Search')]", "Search Button");
        ReusableMethods.sendKeysMethod(driver, "//*[@class= 'form-control search-input']", "get dental coverage", "searchfield");
        ReusableMethods.clickMethod(driver, "//*[@class= 'btn btn-primary btn-search']", "Search Icon");
        String searchResults = ReusableMethods.captureText(driver, "//*[@class= 'gsc-result-info-container']", "Search results");
        String[] searchResultsSplit = searchResults.split(" ");
        System.out.println("The search result amount is " + searchResultsSplit[1]);
        ReusableMethods.clickMethod(driver, "//*[text() = 'Get Dental Coverage']", "Get Dental Coverage link");
    }//end of test case 1

    @Test(dependsOnMethods = "tc_001")
    public static void tc_002() {
        ReusableMethods.switchToTabByIndex(driver, 1);
        ReusableMethods.clickMethod(driver, "//*[@id= 'firstName']", "FirstName Input");
        ReusableMethods.sendKeysMethod(driver, "//*[@id= 'firstName']", "Papi", "FirstName Box");
        ReusableMethods.clickMethod(driver, "//*[@id= 'lastName']", "LastName Input");
        ReusableMethods.sendKeysMethod(driver, "//*[@id= 'lastName']", "Chulo", "LastName Box");
        ReusableMethods.clickMethod(driver, "//*[@id='zipCode']", "zipCode Input");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "11423", "zipCode Box");
        ReusableMethods.clickMethod(driver, "//*[@id= 'phoneNumber']", "phoneNumber Input");
        ReusableMethods.selectByText(driver, "//*[@id'=county']", "Queens", "CountyDropDown");
        ReusableMethods.sendKeysMethod(driver, "//*[@id= 'phoneNumber']", "0123456789", "phoneNumber Box");
        ReusableMethods.clickMethod(driver, "//*[@id= 'email']", "email Input");
        ReusableMethods.sendKeysMethod(driver, "//*[@id= 'email']", "papichulo@gmail.com", "email Box");
        ReusableMethods.clickMethod(driver, "//*[contains (text(), 'By checking this box')]", "CheckBox");
        ReusableMethods.clickMethod(driver, "//*[@type='submit']", "Submit Button");
        String afterMessage = ReusableMethods.captureText(driver, "//*[@class='alert alert-success']", "Message");
        System.out.println(afterMessage);
        driver.close();
    }//end of test case 2

    @Test(dependsOnMethods = {"tc_001", "tc_002"}, priority = 3)
    public static void tc_003() {
        ReusableMethods.switchToTabByIndex(driver, 0);
        ReusableMethods.clickMethod(driver, "//*[contains(text(), 'Login')]", "Login Button");
        ReusableMethods.clickMethod(driver, "//*[contains(text(), 'Member Online Portal')]", "Member Online Portal Link");
        ReusableMethods.switchToTabByIndex(driver, 1);
        String hintsMessage = ReusableMethods.captureText(driver, "//*[@id='helpful-hints']", "Helpful Hints Text");
        System.out.println(hintsMessage);
        driver.close();
        ReusableMethods.switchToTabByIndex(driver, 0);
    }//end of test case 3
}//end of class
