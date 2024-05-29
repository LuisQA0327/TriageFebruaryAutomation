package Day13_051424;

import Day11_050724.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_Google_Inheritance extends TestParent {
    @Test(priority = 1)
    public void searchForACar(){
        //navigate to google homepage
        driver.navigate().to("https://www.google.com");
        //search for a car
        ReusableMethods.sendKeysMethod(driver, "//*[@name = 'q'", "bmw", "Google search");
        //hit submit
        ReusableMethods.submitMethod(driver, "//*[@name = 'btnK']","Submit Button");
    }//end of test case 1

    @Test(priority = 2)
    public void captureSearchResult(){
        //click on the tools button
        ReusableMethods.clickMethod(driver, "//*[@id = 'hatk-tls']","Tools Button");
        //store the search result into a string variable
        String searchResult = ReusableMethods.captureText(driver, "//*[@id = 'result-stats'", "Search Result");
        //print out the result stats
        System.out.println("Search Results is " + searchResult);
    }//end of test case 2

}//end of test class
