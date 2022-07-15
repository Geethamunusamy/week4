package week4day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal
{
public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// step : 1 Launch https://www.snapdeal.com/
       driver.get("https://www.snapdeal.com/");
       Actions builder = new Actions(driver);

       //step:2. Go to Mens Fashion
        WebElement Men =driver.findElement(By.linkText("Men's Fashion"));
        builder.moveToElement(Men).perform();
       
        //step :3. Go to Sports Shoes
       driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')])[1]")).click();
      
       //step :4. Get the count of the sports shoes
       String text =driver.findElement(By.xpath("//span[contains@class,'category-count')]")).getText();
       String replcAll=text.replaceAll("\\D", "");
       int parseInt = Integer.parseInt(replcAll);
       System.out.println("Sports Shoes:"+parseInt);

       //step :5. Click Training shoes
       driver.findElement(By.xpath("//div[text()='Training shoes')")).click();
       
       //step :6. Sort by Low to High
       driver.findElement(By.xpath("//i@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
       WebElement Low =driver.findElement(By.path("//li[contains@data-index,'1')])[2]"));
       builder.moveToElement(Low).click().perform();
       Thread:sleep(6000);

       //step :7. Check if the items displayed are sorted correctly
       List<WebElement> Price  =driver.findElements(By.path("//span@class=1float product-price']"));
       List<String> Shoe = new ArrayList<String>();


        //step :8.Select the price range (900-1200)



//step :9.Filter with color Navy 




//step :10 verify the all applied filters 



//step :11. Mouse Hover on first resulting Training shoes


//step :12. click QuickView button



//step :13. Print the cost and the discount percentage



//step :14. Take the snapshot of the shoes.



     //step :15. Close the current window
       driver.Close();
       

    //step :16. Close the main window //
    driver.quit();







}
