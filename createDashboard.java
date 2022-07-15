package week4day2;


import java.time.Duration;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createDashboard {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Dashboards");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		// 4. Click on the New Dashboard option
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();

		//5.Handle the frame
		WebElement findElement = driver.findElement(By.xpath("//div[@class='dashboardContainer']/iframe"));
        driver.switchTo().frame(findElement);
        
        //6. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Salesforce Automation by Boobesh");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
        driver.switchTo().defaultContent();
        
        //7.Click on Save and Verify Dashboard name.
        WebElement findElement2 = driver.findElement(By.xpath("//div[@class='dashboardContainer']/iframe"));
        driver.switchTo().frame(findElement2);
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral save']")).click();
        String text = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']")).getText();
   
        System.out.println(text);
        
       if (text.contains("Boobesh")) {
    	   
    	   System.out.println("test passed");
	} 
       else {

    	   System.out.println("test failed");
	} 
        
        
		
	}

}