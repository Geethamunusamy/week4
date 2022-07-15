package week4day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");	
		
		//3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		//5. Click on contacts Button
		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//div[@class='frameSectionBody']/ul/li[4]")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> allwindows = driver.getWindowHandles();
	
		List<String> list = new ArrayList<>(allwindows);
		
		
		//8. Click on First Resulting Contact
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
		
		//9. Click on Widget of To Contact
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		//10. Click on Second Resulting Contact
		Set<String> allwindowss = driver.getWindowHandles();
		List<String> lists = new ArrayList<>(allwindowss);
		driver.switchTo().window(lists.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[2]")).click();
		
		//11. Click on Merge button using Xpath Locator
		driver.switchTo().window(lists.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		
		//12. Accept the Alert
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		//13. Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
	}
	
}