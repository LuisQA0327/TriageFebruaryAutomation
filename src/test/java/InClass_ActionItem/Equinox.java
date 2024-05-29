package InClass_ActionItem;

import Day11_050724.ReusableMethods;
import Day13_051424.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Equinox extends TestParent {

    @Test
    public void tc001_getStarted() throws InterruptedException {
        //navigate to equinox
        driver.navigate().to("https://www.equinox.com/");
        //capture the size or number of nav bar options and print it out
        ArrayList<WebElement> equinoxHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@role='navigation']")));
        for (int i = 0;i < equinoxHeaders.size(); i++) {
            System.out.println(equinoxHeaders.get(i).getText());
        }//end for loop
        //click on get started
        ReusableMethods.clickMethod(driver, "//*[@class='PageHero_cta__vJsVL']","GetStartedButton");
//        //fill out first and last name, email address, and phone number
//        ReusableMethods.sendKeysMethod(driver, "//*[@id='mui-1']", "Papi", "FirstNameField");
//        ReusableMethods.sendKeysMethod(driver, "//*[@id='mui-2']", "Chulo", "LastNameField");
//        ReusableMethods.sendKeysMethod(driver, "//*[@id='mui-3']", "papichulo2000@gmail.com", "EmailField");
//        ReusableMethods.sendKeysMethod(driver, "//*[@id='mui-4']", "7181234567", "PhoneNumberField");
//        ReusableMethods.clickMethod(driver,"//*[@class='ContactInformation_club-name-text.__aMDn']", "SelectACLubField");
//        Thread.sleep(2000);
//        ReusableMethods.sendKeysMethod(driver, "//*[@name='autoSearchString']", "Queens, NY 11435, USA", "SearchByLocationField");
//        Thread.sleep(2000);
//        ReusableMethods.clickMethod(driver, "//*[@class='pac-item' ]", "ClubLocation");
//        Thread.sleep(2000);
//        System.out.println(ReusableMethods.captureText(driver, "//*[@class='col-sm-9 col-md-11 col-lg-5 p-0']", "WilliamsburgClubLocation"));
//        ReusableMethods.clickMethod(driver, "//*[@class='col-sm-9 col-md-11 col-1g-5 p-0']", "WilliamsburgClubLocation");
//        ReusableMethods.clickMethod(driver, "//*[text()='Visit a Club']", "VisitAClubButton");
//        Thread.sleep(2000);
    }//end for tc_001
}//end of class
