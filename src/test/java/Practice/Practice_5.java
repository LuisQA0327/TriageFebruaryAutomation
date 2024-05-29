package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Practice_5 {
    public static void main(String[] args) throws InterruptedException {
//        //This the syntax to set the web driver as Chrome (after the 4.19.1 version of Selenium no longer necessary)
//        " WebDriverManager.chromedriver().setup(); "
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
      /*  driver.navigate().to("https://demoqa.com/");
        driver.findElement(By.xpath("//*[text() = 'Elements'] ")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement widgets = driver.findElement(By.xpath("//*[text() = 'Widgets']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",widgets);
        Thread.sleep(2000);
        widgets.click();
        driver.navigate().to("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
        Select dropdownmenu = new Select(dropdown);
        dropdownmenu.selectByIndex(6);*/
        driver.navigate().to("https://www.fideliscare.org/");
        WebElement login = driver.findElement(By.xpath("//*[contains(text() , 'Login')]"));
        login.click();
        Thread.sleep(2000);
        WebElement mop = driver.findElement(By.xpath("//*[contains(text() , 'Member Online Portal')]"));
        mop.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String article = driver.findElement(By.xpath("//*[contains(text() ,  'Renew Your Coverage')]")).getText();
        System.out.println("Don't forget to" + article);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement espanolTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Español']")));
        espanolTab.click();





    }//end of main
}//end of class
