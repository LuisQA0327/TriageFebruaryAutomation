package Day14_052024;

import Day11_050724.ReusableMethods;
import Day13_051424.TestParent;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Day13_051424.TestParent.driver;

public class T1_GoogleExtentReport extends TestParent {

    @Test(priority = 1)
    public void tc001_verifyGoogleTitle(){
        //navigate to google homepage
        driver.navigate().to("https://www.google.com");
        //store the title of google page in a string variable
        String actualTitle = driver.getTitle();
        //store the expected title
        String expectedTitle = "Google";
        //assert the two titles
        Assert.assertEquals(actualTitle,expectedTitle);
    }//end of test case 1

    @Test(priority = 2)
    public void tc002_searchForACar(){
        //navigate to google home page
        driver.navigate().to("https://www.google.com");
        //search for a car
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@name = 'q']", "bmw", "Google Search");
        //hit submit
        ReusableMethods_Loggers.submitMethod(driver,logger, "//*[@name = 'btnK']", "Submit Button");
    }//end of test case 2

    @Test(priority = 3)
    public static void tc003_captureSearchResult(){
        // click on the tools button
        ReusableMethods.clickMethod(driver,"//*[@id = 'hdtb-tls']","Tools Button");
        //store the search result into a string variable
        String actualGoogleSearchResult = ReusableMethods.captureText(driver,"//*[@id = 'result-stats']", "Search Result" );
        String expectedGoogleSearchResult = "About 1,390,000,000 results (0.51 seconds)";
        //print out result on the log
        ReusableMethods_Loggers.checkIfStringEquals(expectedGoogleSearchResult, actualGoogleSearchResult,logger);
        //Assert the search results
        Assert.assertEquals(actualGoogleSearchResult,expectedGoogleSearchResult);
    }//end of test case 3
}//end of class
