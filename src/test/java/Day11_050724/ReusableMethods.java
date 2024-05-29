package Day11_050724;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static Day13_051424.TestParent.driver;

public class ReusableMethods {
    public static void clickMethod(WebDriver driver, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).click();
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " due to exception " + e);
        }//end of catch block
    }//end of click method

    public static String captureText(WebDriver driver, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result="";
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).getText();
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
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

    public static void submitMethod(WebDriver driver, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " due to exception " + e);
        }//end of catch block
    }//end of submit method

    public static void sendKeysMethod(WebDriver driver, String xpathValue, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(userInput);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to send keys on " + elementName + " due to exception " + e);
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

    public static void scrollByView (WebDriver driver, String xpathValue, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);",element);
        } catch (Exception e) {
            System.out.println("Unable to scroll into : " + elementName + e);
        }// end of catch block
    }//end of scrollByView method

    public static void switchToTabByIndex (WebDriver driver, int index){
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
        }catch (Exception e){
            System.out.println("Unable to switch tabs " + e);
        }//end of catch block
    }//end of switchToTabByIndex

    public static void scrollByPixel (WebDriver driver, String pixelX , String pixelY){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + pixelX + "," + pixelY + ")");
        }catch (Exception e){
            System.out.println("Unable to scroll by pixel " + e);
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
    }
}//end of class