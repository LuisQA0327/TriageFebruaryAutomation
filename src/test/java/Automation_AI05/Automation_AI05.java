package Automation_AI05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
//Create an ArrayList with 2 values for the following variables
//zipCode, policyStart, firstName, lastName, streetAdd, dob, coFirstName, coLastName

public class Automation_AI05 {
    public static void main(String[] args) throws InterruptedException {
        //setup chrome options
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("start-maximized" , "incognito");
        //Initialize driver
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11412");
        zipCode.add("11435");

        ArrayList<String> policyStart = new ArrayList<>();
        policyStart.add("05302024");
        policyStart.add("05282024");

        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Big");
        firstName.add("Papi");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Daddy");
        lastName.add("Chulo");

        ArrayList<String> streetAdd = new ArrayList<>();
        streetAdd.add("19031 111th Ave");
        streetAdd.add("13843 Lloyd Road");

        ArrayList<String> dob = new ArrayList<>();
        dob.add("12252001");
        dob.add("12312001");

        ArrayList<String> coFirstName = new ArrayList<>();
        coFirstName.add("Jane");
        coFirstName.add("She");

        ArrayList<String> coLastName = new ArrayList<>();
        coLastName.add("Doe");
        coLastName.add("Her");

        try {
            driver.get("https://www.statefarm.com/");
            Thread.sleep(2000);  // Wait for the page to load

            for (int i = 0; i < zipCode.size(); i++) {
                try {
                    // Click on 'Get a Quote'
                    driver.findElement(By.linkText("Get a Quote")).click();
                    Thread.sleep(1000);  // Wait for modal to appear

                    // Enter zip code and proceed
                    WebElement zipCodeInput = driver.findElement(By.name("postalCode"));
                    zipCodeInput.clear();
                    zipCodeInput.sendKeys(zipCode.get(i));
                    Thread.sleep(1000);  // Simulate user typing delay

                    // Navigate further based on the page response
                    driver.findElement(By.xpath("//button[contains(text(), 'Start')]")).click();
                    Thread.sleep(2000);  // Wait for navigation

                    // Enter policy start date
                    driver.findElement(By.name("policyStart")).sendKeys(policyStart.get(i));
                    driver.findElement(By.name("firstName")).sendKeys(firstName.get(i));
                    driver.findElement(By.name("lastName")).sendKeys(lastName.get(i));
                    driver.findElement(By.name("streetAddress")).sendKeys(streetAdd.get(i));
                    driver.findElement(By.name("dateOfBirth")).sendKeys(dob.get(i));

                    // Click on continue, assume this submits the form
                    driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click();
                    Thread.sleep(1000); // Wait for the next page

                    // Handle co-applicant information
                    driver.findElement(By.xpath("//button[contains(text(), 'Add Co-Applicant')]")).click();
                    driver.findElement(By.name("coApplicantFirstName")).sendKeys(coFirstName.get(i));
                    driver.findElement(By.name("coApplicantLastName")).sendKeys(coLastName.get(i));
                    Thread.sleep(1000); // Simulate user input delay

                    // Assuming to capture any message or click continue again
                    driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click();
                    Thread.sleep(1000); // Wait for response

                    // Print any messages if needed or log success
                    System.out.println("Form submitted successfully for zip code: " + zipCode.get(i));

                } catch (Exception e) {
                    System.out.println("Error during processing zip code " + zipCode.get(i) + ": " + e.getMessage());
                }//end of
            }//end of loop
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            //quit driver
            driver.quit(); // Close the browser and end the session
        }// end of
    }//end of class
}//end of main
