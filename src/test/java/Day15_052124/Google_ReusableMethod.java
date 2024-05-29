package Day15_052124;

import Day13_051424.TestParent;
import Day14_052024.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Google_ReusableMethod extends TestParent {

    @Test
    public void googleSearch(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        ReusableMethods_Loggers.sendKeysMethod(driver,logger,"//*[@name='q']","cars","Search Field");
        //click on Google Search button
        ReusableMethods_Loggers.submitMethod(driver,logger,"//*[@name='btnK']","Search Button");
        //capture the search results
        String results = ReusableMethods_Loggers.captureText(driver,logger,"//*[@id='result-stats']","Search Results");
        System.out.println("My search Result is " + results);
        logger.log(LogStatus.INFO,"My search Result is " + results);
    }//end of main
}
