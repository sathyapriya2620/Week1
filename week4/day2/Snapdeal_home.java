package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Snapdeal_home {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		


		
		
		ChromeOptions option = new ChromeOptions();
		  option.addArguments("--guest"); // making this browser in guest mode 
		ChromeDriver driver=new ChromeDriver(option);
		
		// Add argument to open Chrome in Guest Mode
		option.addArguments("--disable-notifications");

		
		
	//	1. Load the URL (https://www.amazon.in/)
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
	//2. Go to "Men's Fashion".
		
		Actions act=new Actions(driver);
		WebElement mens = driver.findElement(By.id("tab-category-0"));
		act.moveToElement(mens).perform();
		
	//	3. Go to "Sports Shoes".	
		
	driver.findElement(By.xpath("//div[text()='Sports Shoes']")).click();
	
		String parent = driver.getWindowHandle();
		System.out.println("parent address:"+parent);
		System.out.println("I am parent: "+driver.getTitle());
		
		//Switching to child window
		Set<String> child1 = driver.getWindowHandles();
		for(String string:child1)
		{
			if(!string.equals(parent)) {
				driver.switchTo().window(string);
				
			}
			System.out.println(" I am child window "+driver.getTitle());
		}
		
	//4. Get the count of sports shoes.	
	
		WebElement sports_count=driver.findElement(By.xpath("//a[@href='/products/mens-footwear-sports-shoes#bcrumbLabelId:255']/div[@class='child-cat-count ']"));
		System.out.println("Total count of sports shoe is :"+sports_count.getText());
		

     //  5. Click on "Training Shoes".	
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
	//6. Sort the products by "Low to High".
		
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();    //sort
		
		
		driver.findElement(By.xpath("//li[contains(normalize-space(),'Price Low To High')]")).click();  //click on low to high
		
	//7. Check if the displayed items are sorted correctly.
		
	//8. Select any price range ex:(500-700).
		WebElement price=driver.findElement(By.xpath("//input[@name='fromVal']"));
		price.clear();
		price.sendKeys("500");
		
		
		WebElement price1=driver.findElement(By.xpath("//input[@name='toVal']"));
		price1.clear();
		price1.sendKeys("700");
		
		
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn btn-line btn-theme-secondary')]")).click();
		
		Thread.sleep(3000);
		
	//	9. Filter by any colour.
		
		//To scroll the page
		
		//WebElement scroll = driver.findElement(By.xpath("//a[text()=' White & Blue']"));
		WebElement until1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' White & Blue']")));
		act.scrollToElement(until1).perform();
		Thread.sleep(2000);
		////label[contains(@for,'Color_s-White%20%26%20Blue')]
		//To click on check box;
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' White & Blue']")));
		driver.executeScript("arguments[0].click();", until);  // to click th element usning jscript
		Thread.sleep(2000);
		
	//11. Mouse hover on the first resulting "Training Shoes".
	       WebElement mousehover=	driver.findElement(By.xpath("//div[@id='products']/section/div"));
	
        act.moveToElement(mousehover).perform();

//12. Click the "Quick View" button.
             driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
             
//13. Print the cost and the discount percentage.
           WebElement cost=  driver.findElement(By.xpath("//span[@class='payBlkBig']"));
           Thread.sleep(2000);
           System.out.println("The cost is :"+cost.getText());
           
           WebElement disCount=  driver.findElement(By.xpath("//span[@class='percent-desc ']"));
           Thread.sleep(2000);
          
           System.out.println("The discount price is:"+disCount.getText());
         
           
           
         //  14. Take a snapshot of the shoes.  
           
           File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
           File target=new File("./Screenshot/snapdeal.png");
           FileUtils.copyFile(screenshotAs, target);
           
           driver.quit();

	}

}
