package Day10_050624;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T3_ExplicitWait {
    public static void main(String [] arguments){
        //declare the chromeOptions
        ChromeOptions options = new ChromeOptions();
        //start maximized
        options.addArguments("start-maximized");
        //define the web driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to UPS.com
        driver.navigate().to("https://www.ups.com/");
        //declare explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        //click on tracking
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Tracking']")));
        }catch (Exception e) {
            System.out.println("Unable to click on Tracking " +e);
        }//end of exception
        //click on track a package
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();
        }catch (Exception e) {
            System.out.println("Unable to click on a Track a package" +e);
        }//end of exception

        //quit the driver
        driver.quit();
    }//end of main
}//end of class
