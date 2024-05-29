package Practice;

import Day13_051424.TestParent;
import Day14_052024.ReusableMethods_Loggers;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Boolean extends TestParent {
    @Test
    public static void trial (){
        driver.get("https://www.fideliscare.org/Blog/Get-Dental-Coverage");
        boolean checkboxIsSelected = driver.findElement(By.xpath("//*[contains(text(),'By checking this')]")).isSelected();
        System.out.println("The box is selected: " + checkboxIsSelected);
        if(checkboxIsSelected){
            System.out.println("Checkbox is selected");
        }else{
            ReusableMethods_Loggers.clickMethod(driver, logger, "//*[contains(text(),'By checking this')]", "Check-Box");
        }
    }

    @Test
    public static void trial2(){
        driver.get("https://www.lendingtree.com/home/refinance/cash-out/?icid=wp-menu-home-corefi");
        ReusableMethods_Loggers.clickMethod(driver,logger,"//*[contains(text(),'Pros and cons')]","Pros and cons link");
        boolean prosAndConsSelection = driver.findElement(By.xpath("//*[contains(text(),'Pros and cons')]")).isEnabled();
        System.out.println(prosAndConsSelection);
    }

}//end of class
