package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class editDashboard {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Thread.sleep(5000);
		
		//4. Click on the Dashboards tab 
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Dashboards");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		//5. Search the Dashboard 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']")).sendKeys("boobesh");
		
		//6. Click on the Dropdown icon and Select Edit
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread'])[1]")).click();
		Thread.sleep(5000);
    	driver.findElement(By.xpath("(//lightning-menu-item[@class='slds-dropdown__item'])[2]/a/span[@class='slds-truncate']")).click();
    	
    	//7.Click on the Edit Dashboard Properties icon
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='toolbarActions']//button)[5]")).click();   
        driver.switchTo().defaultContent();
		
        //8. Enter Description as 'SalesForce' and click on save.
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe")));
        driver.findElement(By.xpath("(//div[@class='slds-form-element__control']/input[@class='slds-input'])[2]")).clear();
        driver.findElement(By.xpath("(//div[@class='slds-form-element__control']/input[@class='slds-input'])[2]")).sendKeys("SalesForce");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
        driver.switchTo().defaultContent();
        
        //9. Click on Done and  Click on save in the popup window displayed.
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe")));
        driver.findElement(By.xpath("//div[@class='toolbarActions']//button[@class='slds-button doneEditing']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe")));
        driver.findElement(By.xpath("//footer[@class='slds-modal__footer']/button[@class='slds-button slds-button_brand modalBtn2']")).click();
        driver.switchTo().defaultContent();
        
        //10. Verify the Description.
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe")));
        String text = driver.findElement(By.xpath("//div[@class='slds-col slds-align-bottom']/p")).getText();
        System.out.println(text);
        
        if (text.contains("SalesForce")) {
        	System.out.println("test passed");
			} 
        else {
			System.out.println("test failed");
		}
        
        driver.quit();
          
		
	}
	
}
