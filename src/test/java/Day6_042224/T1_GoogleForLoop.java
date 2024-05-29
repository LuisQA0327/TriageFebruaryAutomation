package Day6_042224;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T1_GoogleForLoop {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver variable and set up the chrome driver
        WebDriver driver = new ChromeDriver();
        //declare the array list
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("BMW");
        carBrands.add("Mercedes");
        carBrands.add("Toyota");
        for (int i = 0; i < carBrands.size(); i++) {
            //go to google.com
            driver.navigate().to("https://www.google.com");
            //type of cars in the search box
            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(carBrands.get(i));
            //click or submit the google search button
            driver.findElement(By.xpath("//*[@name = 'btnK']")).submit();
            //pause for 2 seconds
            Thread.sleep(2000);
            //store the search result into a string variable
            String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
            //print out the result stats
            System.out.println("Search Result for "+ carBrands.get(i) + "is" +searchResult);
        }//end of loop
        //quit the chrome browser
        driver.quit();
    }//end of main
}//end of class
