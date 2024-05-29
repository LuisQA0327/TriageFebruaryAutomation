package Day10_050624;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class T2_ImplicitWait {
    public static void main (String [] args){
        //declare the chrome options
        ChromeOptions options  = new ChromeOptions();
        //run incognito
        options.addArguments("start-maximized");
        //define new webdriver
        WebDriver driver = new ChromeDriver(options);
        //declare and define your global implicit wait for all web elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        //navigate to UPS.com
        driver.navigate().to("https://www.ups.com/");
        //Click on Tracking
        driver.findElement(By.xpath("//*[text()='Tracking']")).click();
        //click on Tracking
        driver.findElement(By.xpath("//*[text()='Track a Package']")).click();
    }//end of main
}//end of class
