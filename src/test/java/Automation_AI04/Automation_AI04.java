package Automation_AI04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Automation_AI04 {
    public static void main(String[] args) throws InterruptedException {
        //Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        //add option for Chrome to start on fullscreen(maximized) and incognito mode
        options.addArguments("start-maximized", "incognito");
        //declare Chrome driver and define options
        WebDriver driver = new ChromeDriver(options);
        //create an ArrayList to store zipCodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11423");
        zipCodes.add("11004");
        zipCodes.add("11693");

        for (int i = 0; i < zipCodes.size(); i++) {
            //navigate to www.weightwatchers.com/us/find-a-workshop/
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait 2 seconds
            Thread.sleep(2000);
            //Click on "Find a Workshop" on the top right corner
            driver.findElement(By.xpath("//*[text() = 'Find a Workshop']")).click();
            //click on "In-Person" link
            driver.findElement(By.xpath("//*[text() = 'In-Person']")).click();
            //wait 2 seconds
            Thread.sleep(2000);
            // Locate search input, clear it, and input the zip code
            WebElement searchInput = driver.findElement(By.xpath("//*[@id = 'location-search']"));
            searchInput.clear();
            searchInput.sendKeys(zipCodes.get(i));
            //wait 1 second
            Thread.sleep(1000);
            // Click the search arrow
            driver.findElement(By.xpath("//*[@class= 'rightArrow-C_sUu']")).click();
            Thread.sleep(1000);
            //store the studios in ArrayList of WebElements
            ArrayList<WebElement> studios = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkUnderline-XyxpJ']")));
            if (i == 0){
                studios.get(1).click(); // Second studio
            } else if (i == 1){
                studios.get(2).click(); // Third studio
            } else if (i == 2){
                studios.get(0).click(); // First studio
            }//end of conditional statement
            //wait for 3 seconds
            Thread.sleep(2000);
            String address = driver.findElement(By.xpath("//*[@class='address-FnT8k']")).getText();
            System.out.println(address);
            WebElement schedule = driver.findElement(By.xpath("//*[@class= 'workshopSchedule-2zUZD']"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", schedule);
            String fullSchedule = driver.findElement(By.xpath("//*[@class= 'workshopSchedule-2zUZD']")).getText();
            System.out.println(fullSchedule);
        }//end of loop
            //quit chrome driver
            driver.quit();
    }//end of main
}//end of class
