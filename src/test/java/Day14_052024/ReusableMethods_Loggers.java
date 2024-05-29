package Day14_052024;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class ReusableMethods_Loggers {

        public static void clickMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue))).click();
                logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
            }//end of try block
            catch (Exception e) {
                System.out.println("Unable to click on " + elementName + " due to exception " + e);
                logger.log(LogStatus.FAIL,"Unable to click on " + elementName);
                getScreenShot(driver,elementName,logger);
            }//end of catch block
        }//end of click method

        public static String captureText(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String result = "";
            try {
                result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).getText();
                logger.log(LogStatus.PASS, "Successfully captured text from " + elementName);
                System.out.println(result);
            }//end of try block
            catch (Exception e) {
                System.out.println("Unable to capture text " + elementName + " due to exception " + e);
                logger.log(LogStatus.FAIL, "Unable to capture text from " + elementName);
                getScreenShot(driver,elementName,logger);
            }//end of catch block
            return result;
        }//end of capture text method

        public static WebDriver setUpDriver(){
            //declare and define chrome options
            ChromeOptions options = new ChromeOptions();
            //add option to start it maximized
            options.addArguments("start-maximized", "incognito");
            //pass the chrome options to the driver
            WebDriver driver = new ChromeDriver(options);
            //return driver
            return driver;
        }//end of setupdriver method

        public static void submitMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
            }//end of try block
            catch (Exception e) {
                System.out.println("Unable to submit on " + elementName + " due to exception " + e);
                getScreenShot(driver,elementName,logger);
            }//end of catch block
        }//end of submit method

        public static void sendKeysMethod(WebDriver driver, ExtentTest logger, String xpathValue, String userInput, String elementName){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(userInput);
                logger.log(LogStatus.PASS, "Successfully entered text on " + elementName);
            }//end of try block
            catch (Exception e) {
                System.out.println("Unable to send keys on " + elementName + " due to exception " + e);
                logger.log(LogStatus.FAIL, "Unable to send keys on " + elementName);
                getScreenShot(driver,elementName,logger);
            }//end of catch block
        }//end of send keys method


        public static void clearMethod(WebDriver driver, String xpathValue, String elementName){
            try {
                driver.findElement(By.xpath(xpathValue)).clear();
            }catch(Exception e){
                System.out.println("unable to clear" + elementName + e);
            }
        }
        public static void clickMethodByIndex(WebDriver driver, String xpathValue, int index, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathValue))).get(index).click();
            }//end of try block
            catch (Exception e) {
                System.out.println("Unable to click on " + elementName + " due to exception " + e);
            }//end of catch block
        }//end of click method

        public static void scrollByView (WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].scrollIntoView(true);",element);
                logger.log(LogStatus.PASS, "Successfully scrolled by pixel " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to scroll into : " + elementName + e);
                getScreenShot(driver,elementName,logger);
            }// end of catch block
        }//end of scrollByView method

        public static void switchToTabByIndex (WebDriver driver, ExtentTest logger, int index){
            try {
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(index));
            }catch (Exception e){
                System.out.println("Unable to switch tabs " + e);
            }//end of catch block
        }//end of switchToTabByIndex

        public static void scrollByPixel (WebDriver driver,ExtentTest logger, String pixelX , String pixelY, String elementName){
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(" + pixelX + "," + pixelY + ")");
                logger.log(LogStatus.PASS, "Successfully scrolled by pixel " + elementName);
            }catch (Exception e){
                System.out.println("Unable to scroll by pixel " + e);
                logger.log(LogStatus.FAIL, "Unable to scroll by pixel " + elementName);
                getScreenShot(driver,elementName,logger);
            }//end of catch block
        }//end of scrollByPixel

        public static void selectByText (WebDriver driver, String xpath, String visibleTextInput, String elementName ){
            try{
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
                WebElement selectVar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                Select selectFunction = new Select(selectVar);
                selectFunction.selectByVisibleText(visibleTextInput);
            } catch(Exception e){
                System.out.println("Unable to select by text " + elementName + e);
            }//end of catch block
        }//end selectByText

        public static WebDriver setupChromeDriver() {
            //declare and define chrome options
            ChromeOptions options = new ChromeOptions();
            //add option to start it maximized
            options.addArguments("start-maximized", "incognito");
            //pass the chrome options to the driver
            WebDriver driver = new ChromeDriver(options);
            //return driver
            return driver;
        }//end of setupChromeDriver

    public static void checkIfStringEquals(String expectedText, String actualText, ExtentTest logger) {
        if (expectedText.equals(actualText)) {
            logger.log(LogStatus.PASS, "Expected Text " + expectedText + " Matches " + actualText);

        } else {
            logger.log(LogStatus.FAIL, "Expected Text " + expectedText + " does not match " + actualText);
        }
    }//end of checkString

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!! " + e);
        }//end of exception
    }//end of get screenshot method

    public static void clickElementByJavaScript(WebDriver driver, ExtentTest logger, String xpath, String elementName) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            System.out.println("Successfully clicked on element using JavaScript: " + xpath);
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element using JavaScript: " + xpath + " - " + e);
            logger.log(LogStatus.FAIL, "Unable to click element " + elementName);
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of clickElementByJavaScript

    public static void openLinkInNewTab(WebDriver driver, ExtentTest logger, String xpath, String elementName) {
        try {
            // Find the link element using XPath
            WebElement link = driver.findElement(By.xpath(xpath));
            String url = link.getAttribute("href");

            // Open the link in a new tab using JavaScript
            ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", url);
            logger.log(LogStatus.PASS, "Successfully opened new tab with URL: " + url);

            // Get the list of window handles
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            // Switch to the new tab
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            logger.log(LogStatus.PASS, "Successfully switched to the new tab for " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to open new tab: " + e);
            logger.log(LogStatus.FAIL, "Unable to open new tab for " + elementName + " - " + e);
        }//end of exception
    }//end of openLinkInNewTab

    public static void hoverOverElement(WebDriver driver, ExtentTest logger, String xpath, String elementName) {
        try {
            Actions actions = new Actions(driver);

            // Find the element to hover over
            WebElement hoverElement = driver.findElement(By.xpath(xpath));

            // Move to the element (hover)
            actions.moveToElement(hoverElement).perform();
            logger.log(LogStatus.PASS, "Successfully hovered over " + elementName);

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to hover over " + elementName + " - " + e);
        }//end of exception
    }//end of hoverOverElement

}//end of class
