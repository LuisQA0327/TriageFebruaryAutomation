package Day10_050624;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseAction {
    public static void main(String[] args) {
        //Set up ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //declare chrome arguments
        options.addArguments("Incognito");
        //run in full screen
        options.addArguments("start-maximized");
        //define the driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to USPS
        driver.navigate().to("https://www.usps.com/");
        //define Action command
        Actions mouseAction = new Actions(driver);
        try{
            WebElement SendTab = driver.findElement(By.xpath("//*[text()= 'send']"));
            mouseAction.moveToElement(SendTab).perform();
        }catch (Exception e){
            System.out.println("Unable to hover over Send Tab");
        }//end of exception
        //Click on Look up a Zip Code from the drop-down list
        try{
            WebElement zipcodeLookUp = driver.findElement(By.xpath("//*[text()='Look Up a ZIP Code']"));
            mouseAction.moveToElement(zipcodeLookUp).click().perform();
        }catch (Exception e){
            System.out.println("Unable to click on Look up a Zip code" + e);
        }//end of exception
        //Enter a Zip Code
        try{
            WebElement ZipCode = driver.findElement(By.xpath("//*[@id= 'tZip']"));
            mouseAction.moveToElement(ZipCode).sendKeys("11221").click().perform();
        }catch (Exception e){
            System.out.println("Unable to enter Zip code " +e);
        }//end of exception
        //quit driver
        driver.quit();
    }//end of class
}// end of main
