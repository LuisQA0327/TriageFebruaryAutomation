package Day11_050724;

import org.openqa.selenium.WebDriver;



public class T1_GoogleReusable {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver variable and set up the chrome driver
        WebDriver driver = ReusableMethods.setupChromeDriver();
        //go to google.com
        driver.navigate().to("https://www.google.com");
        //send keys from reusable methods
        ReusableMethods.sendKeysMethod(driver, "//*[@name = 'q']", "bmw", "Google Search");
        //submit using reusable methods
        ReusableMethods.submitMethod(driver, "//*[@name = 'btnK']", "Submit Button");
        // click on the tools button
        ReusableMethods.clickMethod(driver,"//*[@id = 'hdtb-tls']","Tools Button");
        //store the search result into a string variable
        String searchResult = ReusableMethods.captureText(driver, "//*[@id = 'result-stats']", "Search Result");
        //print out the result stats
        System.out.println("Search Result is " + searchResult);
        //quit the chrome browser
        driver.quit();
    }//end of main
}//end of class
