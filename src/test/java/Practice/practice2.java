package Day5_041624;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class practice2 {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver variable and set up the chrome driver
        WebDriver driver = new ChromeDriver();
        // go to google.com
        driver.navigate().to("https://www.google.com");
        //type cars in the search box
        // driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");

        WebElement searchField = driver.findElement(By.xpath("//*[@class='gLFyf']"));


        searchField.click();
        searchField.sendKeys("cars");
        searchField.submit();


        //click or submit the google search button
        driver.findElement(By.xpath("//*[@name = 'btnK']")).submit();
        //pause for 2 seconds
        Thread.sleep(2000);
        //store the search result into a string variable
        String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
        //create a linear array to split search result text
        String[] searchResultSplit = searchResult.split(" ");
        //print out the number of search results using split
        System.out.println("Search Result amount is " + searchResultSplit[1]);
        //quit the chrome browser
        driver.quit();
    }//end of main
}//end of class
