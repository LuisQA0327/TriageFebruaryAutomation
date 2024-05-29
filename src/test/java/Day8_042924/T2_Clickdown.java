package Day8_042924;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T2_Clickdown {
    public static void main(String[] args) throws InterruptedException {
        //select start month from the dropdown on mortgagecalculator.org
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("start-maximized" + "incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        //wait few seconds for the browser session to load up
        Thread.sleep(3000);
        //enter home value
        driver.findElement(By.xpath("//*[@id='homeval']")).sendKeys("450000");
        //enter down payment
        driver.findElement(By.xpath("//*[@id='downpayment']")).sendKeys("100000");
        //select a start month from the start dropdown
        WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //click on dropdown value may by using xpath text()
        driver.findElement(By.xpath("//*[text()='May']")).click();
    }//end of main
}//end of class
