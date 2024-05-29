package Day13_051424;

import Day11_050724.ReusableMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestParent {

    public static WebDriver driver;

    public static ExtentReports reports;

    public static ExtentTest logger;

    //declare a global public webDriver variable
    @BeforeSuite
    public void setUpReports(){
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html");
    }//end of before suite

    @BeforeClass
    public void setUpDriver(){
        driver = ReusableMethods.setupChromeDriver();
    }//end of before class

    @BeforeMethod
    public void setTestName (Method methodName){
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endTest (){
        reports.endTest(logger);
    }//end of before method

    @AfterClass
    public void quitDriver(){
       /* driver.quit();*/
    }//end of after class

    @AfterSuite
    public void flushReport(){
        reports.flush();
    }//end of after suite

}//end of class
