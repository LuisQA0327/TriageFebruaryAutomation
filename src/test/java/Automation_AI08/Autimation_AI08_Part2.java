package Automation_AI08;

import Day13_051424.TestParent;
import Day14_052024.ReusableMethods_Loggers;
import org.testng.annotations.Test;

public class Autimation_AI08_Part2 extends TestParent {

    @Test
    public static void zelleFeature () throws InterruptedException {
        //navigate to Capital One Bank website
        driver.navigate().to("https://www.capitalone.com/");
        //click on Search Button, type "Zelle" and submit search
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[@id='unav-l1-search']","search button");
        ReusableMethods_Loggers.sendKeysMethod(driver,logger,"//*[@name='qt']","Zelle","search bar");
        ReusableMethods_Loggers.submitMethod(driver,logger, "//*[@name='qt']", "search bar");
        //scroll down find the 4 search result and then click the link
        ReusableMethods_Loggers.scrollByView(driver,logger,"//*[contains(text(), 'Zelle: Send')]","4th search option");
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[contains(text(), 'Zelle: Send')]","4th search link");
        //click on 'FAQ's' on the header
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[contains(text(),' FAQs ')]","FAQ");
        //click on the 3 option/question of the FAQ, then click on the second clickable link
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[contains(@id, 'p-can-i-send-money')]","3rd question");
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[text()= 'send money with Zelle®']","transfer link");
        //sleep 3 seconds
        Thread.sleep(3000);
        //scroll down by pixel to the survey, then scroll back up
        ReusableMethods_Loggers.scrollByPixel(driver, logger, "0", "800", "Survey");
        ReusableMethods_Loggers.scrollByPixel(driver, logger, "0", "-800", "Survey");
        //print out header
        ReusableMethods_Loggers.captureText(driver, logger, "//*[contains(text(), 'You can send funds using Zelle')]","Header");
    }//end of zelleFeature

    @Test (dependsOnMethods = "zelleFeature")
    public static void zelleFeature_2 () {
        //navigate to Capital One Bank website
        driver.navigate().to("https://www.capitalone.com/");
        //click on Checking & Savings on top header
        ReusableMethods_Loggers.clickMethod(driver, logger,"//*[text()= 'Checking & Savings']","C&S Button");
        //scroll to "The Experience You Deserve"
        ReusableMethods_Loggers.scrollByView(driver, logger, "//*[text()= 'Ways to bank']", "Exp You Deserve");
        //Click on "Ways to bank" link
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@href='https://www.capitalone.com/bank/ways-to-bank/']","Link");

        ReusableMethods_Loggers.clickMethod(driver, logger, "", "");

    }





}//end of class
