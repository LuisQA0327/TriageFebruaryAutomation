package Day7_042324;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_Webelement {
    public static void main(String[] args) throws InterruptedException {
        //declare and define chrome options
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);
        //go to mortagecalcalculator.com
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //declare and store home value webelement
        WebElement homeValue = driver.findElement(By.xpath("//*[@id = 'homeval']"));
        //clear the home value field
        homeValue.clear();
        homeValue.sendKeys("950000");
        //wait 2 seconds
        Thread.sleep(2000);
        //quit chrome driver
//        driver.quit();
    }//end of main
}//end of class