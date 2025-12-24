package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class Action_amazon_home {

	public static void main(String[] args) throws InterruptedException, IOException {

		/*
		 * 


8. Get the cart subtotal and verify if it is correct.
9. Close the browser.
		 */
		ChromeOptions option = new ChromeOptions();
		  option.addArguments("--guest"); // making this browser in guest mode 
		ChromeDriver driver=new ChromeDriver(option);
		
		// Add argument to open Chrome in Guest Mode
		option.addArguments("--disable-notifications");

		
		
	//	1. Load the URL (https://www.amazon.in/)
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
	//2. Search for "samsung galaxy s24".
		
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("samsung galaxy s24",Keys.ENTER);
		
	//3. Get the price of the first product.
		
	WebElement price=	driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		
		System.out.println("Price of the phone is: "+price.getText());
		
	//4. Print the number of customer ratings for the first displayed product.
	
		
	WebElement rating=	driver.findElement(By.xpath("(//span[@class='a-size-mini puis-normal-weight-text s-underline-text'])[1]"));
	
	System.out.println("Total number of rating is: " +rating.getText());
	
	//5. Click the first text link of the first image.
	
	//(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]
driver.findElement(By.xpath("(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]")).click();


//------------------- parent window-----------------

String windowHandle = driver.getWindowHandle();
System.out.println(windowHandle);
System.out.println("The title of parent is:"+driver.getTitle());
  
//----------------------------getchild window----------------------------->
Set<String> windowHandles = driver.getWindowHandles();

for(String child:windowHandles)
{
	if(!child.equals(windowHandle))
	{
		driver.switchTo().window(child);
		System.out.println("The address of child is "+child);
		Thread.sleep(2000);
		System.out.println("The title of child is: " +driver.getTitle());
	}
}

//---------------  Take a screenshot of the product displayed.


File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
File saveas=new File("./Screenshot/target.png");
FileUtils.copyFile(screenshotAs, saveas);


//7. Click the 'Add to Cart' button.

driver.findElement(By.id("add-to-cart-button")).click();


//Get the cart subtotal and verify if it is correct.


	WebElement price_verify=driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']//span[@class='a-price-whole']"));
	
	Thread.sleep(3000);
	System.out.println("The cart value :"+price_verify.getText());
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
