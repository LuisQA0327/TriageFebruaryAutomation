package Automation_AI03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {
    public static void main(String[] args) throws InterruptedException {
        //Define the WebDriver variable and set up the Chrome Driver
        WebDriver driver = new ChromeDriver();
        //Navigate to Bing.com
        driver.navigate().to("https://www.bing.com/");
        //Wait for 2 to 3 seconds before performing any other actions
        Thread.sleep(2000); //sleep for 3 seconds
        //Enter the keyword "soccer" in the search box
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("soccer");
        //press "Return" (MacOS) or "Enter" (Windows) to submit soccer search
        driver.findElement(By.xpath("//*[@name='q']")).submit();
        //Wait 3 Seconds
        Thread.sleep(2000);
        //Capture the search results and attach to string message
        String searchResult = driver.findElement(By.xpath("//*[@id='b_tween_searchResults']")).getText();
        //Create a String Array and split the search result text
        String[] searchResultSplit = searchResult.split(" ");
        //Define the searchResultVariable to hold the number of results
        String searchResultVariable = searchResultSplit[1];
        System.out.println("I searched Bing.com and the search result is " + searchResultVariable);
        //Click on "More", which is located on the top menu bar under the search box
        driver.findElement(By.xpath("//*[@id='b_sp_menu_separ']")).click();
        //When drop-down menu pops out scroll down to "My Bing" and click
        driver.findElement(By.xpath("//*[@id='b-scopeListItem-bingpages']")).click();
        //Wait 2-3 seconds for the page to load
        Thread.sleep(2000);
        //Capture the profile message starting with "To see your profile page,"
        String profileMessage = driver.findElement(By.xpath("//*[@class= 'myprofile-see-profile']")).getText();
        //Print out the entire message in Profile
        System.out.println("The message that appears is " + profileMessage);
        //quit the Chrome browser
        driver.quit();
    }//end of main
}//end of class
