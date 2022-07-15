package week4day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame {

	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
		    ChromeDriver driver = new ChromeDriver();
			driver.manage().window();
			
			//open a url  https://jqueryui.com/selectable/
			driver.navigate().to("https://jqueryui.com/selectable/");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee'][3]")).click();
			driver.findElement(By.xpath("//li[@class='menu-item']/a[text()='Download']")).click();
		
	}
}
