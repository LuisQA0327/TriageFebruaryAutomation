package Automation_AI06;

import Day11_050724.ReusableMethods;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Automation_AI06 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = ReusableMethods.setUpDriver();
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11423");
        zipCodes.add("11004");
        zipCodes.add("11693");

        for(int i = 0; i < zipCodes.size(); i++){
            driver.navigate().to("https://www.WeightWatchers.com");
            ReusableMethods.clickMethod(driver,"//*[text() = 'Find a Workshop']","Find a Workshop Button");
            ReusableMethods.clickMethod(driver, "//*[text() = 'In-Person']", "In Person Button");
            ReusableMethods.sendKeysMethod(driver,"//*[@id = 'location-search']",zipCodes.get(i),"Zip Search");
            Thread.sleep(2000);
            ReusableMethods.clickMethod(driver,"//*[@class= 'rightArrow-C_sUu']","Search button");
           // ArrayList<WebElement> studios = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkUnderline-XyxpJ']")));
            if (i == 0){
                ReusableMethods.clickMethodByIndex(driver,"//*[@class = 'linkUnderline-XyxpJ']",1,"Second Studio Link"); // Second studio
            } else if (i == 1){
                ReusableMethods.clickMethodByIndex(driver,"//*[@class = 'linkUnderline-XyxpJ']",2,"Third Studio Link");// Third studio
            } else if (i == 2){
                ReusableMethods.clickMethodByIndex(driver,"//*[@class = 'linkUnderline-XyxpJ']",0,"First Studio Link"); // First studio
            }//end of conditional statement
            String address = ReusableMethods.captureText(driver,"//*[@class='address-FnT8k']","studio address");
            System.out.println(address);
            ReusableMethods.scrollByView(driver,"//*[@class= 'workshopSchedule-2zUZD']","full schedule chart");
            String fullSchedule = ReusableMethods.captureText(driver,"//*[@class= 'workshopSchedule-2zUZD']","studio schedule");
            System.out.println(fullSchedule);
        }//end of
        driver.quit();
    }//end of main
}//end of class