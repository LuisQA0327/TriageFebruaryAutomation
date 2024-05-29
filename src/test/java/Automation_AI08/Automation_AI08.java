package Automation_AI08;

import Day13_051424.TestParent;
import Day14_052024.ReusableMethods_Loggers;
import org.testng.annotations.Test;

import static Day14_052024.ReusableMethods_Loggers.clickElementByJavaScript;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.elementName;

public class Automation_AI08 extends TestParent {

    @Test
    public static void overDraftFee () throws InterruptedException {
        //navigate to Capital One Bank website
        driver.navigate().to("https://www.capitalone.com/");
        //click on Checking & Savings on top header
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= 'Checking & Savings']","C&S Button");
        //scroll to Compare all accounts and then click
        ReusableMethods_Loggers.scrollByView(driver, logger,"//*[text()= ' Compare all accounts ']","Compare all accounts button");
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= ' Compare all accounts ']","Compare all accounts button");
        //click on Learn more link on the 360 Checking Box
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[contains(@class, 'grv-button--text')]","Checking Learn More Button");
        //click scroll and click on See your overdraft options link
        ReusableMethods_Loggers.scrollByView(driver, logger,"//*[text()= 'See your overdraft options']", "Overdraft options");
        ReusableMethods_Loggers.clickMethod(driver, logger,"//a[contains(text(), 'See your overdraft options')]","See your overdraft options link");
        //sleep 2 seconds
        Thread.sleep(2000);
        //scroll to FAQ box and print out entire box
        ReusableMethods_Loggers.scrollByView(driver, logger,"//*[contains(@class, 'dion ng-star-inserted')]","FAQ Table ");
        ReusableMethods_Loggers.captureText(driver, logger, "//*[contains(@class, 'dion ng-star-inserted')]","FAQ Table ");
    }//end of overDraftFee case

    @Test (dependsOnMethods = "overDraftFee")
    public static void chosingCDs () throws InterruptedException {
        //navigate to Capital One Bank website
        driver.navigate().to("https://www.capitalone.com/");
        //click sign in and open in new tab
        ReusableMethods_Loggers.openLinkInNewTab(driver, logger,"//*[@href='https://www.capitalone.com/bank/']","C&S Link");
        //click on 360 CDs on the selection bar
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= '360 CDs']","360 CDs");
        //click on 'Rates' on the selection
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()= ' Rates ']", "Rates");
        //click on currency selection, type 25000 and print the whole table
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[@class='currency-input']","Currency selection");
        ReusableMethods_Loggers.sendKeysMethod(driver, logger,"//*[contains(@class, 'grv-textfield__i')]","25000","Currency selection");
        ReusableMethods_Loggers.captureText(driver, logger, "//*[@id='rates-calculator-table']","Table");
        //sleep 2 seconds
        Thread.sleep(2000);
        //close tab #2
        driver.close();
    }//end of chosingCDs


    @Test (dependsOnMethods = {"overDraftFee", "chosingCDs"}, priority = 3)
    public static void logInPage () throws InterruptedException {
        //navigate to Capital One Bank website
        driver.navigate().to("https://www.capitalone.com/");
        //click on Checking & Savings on top header
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= 'Checking & Savings']","C&S Button");
        //scroll down to 'YOUR BANK IN THE PALM OF YOUR HAND' and select each of the four elements, wait 2 seconds per element
        ReusableMethods_Loggers.scrollByView(driver, logger, "//*[@id='activeImage0']", "Phone View");
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= ' A top-rated mobile app ']", "Left-Top Element");
        Thread.sleep(2000);
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= ' Debit card lock/unlock ']", "Left-Bottom Element");
        Thread.sleep(2000);
        ReusableMethods_Loggers.clickMethod(driver, logger," //*[text()= ' Mobile deposit ']", "Right-Top Element");
        Thread.sleep(2000);
        ReusableMethods_Loggers.clickMethod(driver, logger," //*[text()= ' Money movement ']", "Right-Bottom Element");
        //click sign in and open in new tab
        ReusableMethods_Loggers.openLinkInNewTab(driver, logger, "//*[@href='https://verified.capitalone.com/auth/signin']","Sign-in link");
        //type fake email and password wait for an error
        ReusableMethods_Loggers.sendKeysMethod(driver,logger,"//*[@id='usernameInputField']","papichulo1923@gmail.com","Email insert");
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@id='pwInputField']", "Password12345", "Password insert");
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[contains(@class, 'c1-ease-button')]","Submit button");
        //print error message
        ReusableMethods_Loggers.captureText(driver, logger,"//*[@class='error-warning']","Error message");
        //close tab
        driver.close();
    }//end of logInPage case
}//end of class