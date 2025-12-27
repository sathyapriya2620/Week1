package week4.day2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Big_basket {
	
	/*
	 * .1. Navigate to https://www.bigbasket.com/.



5. Click on "
act".


8. Select the 5 Kg bag.
9. Check and note the price of the rice.
10. Click "Add" to add the bag to your cart.
11. Verify the success message that confirms the item was added to your cart.
12. Take a snapshot of the current page
13. Close the current window.

	 */
	

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		  option.addArguments("--guest"); // making this browser in guest mode 
		ChromeDriver driver=new ChromeDriver(option);
		
		// Add argument to open Chrome in Guest Mode
		option.addArguments("--disable-notifications");

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
	//	1. Load the URL (https://www.amazon.in/)
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	//2. Click on "Shop by Category".
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']")).click();
		
	//3. Mouse over "Foodgrains, Oil & Masala".
		WebElement food=driver.findElement(By.partialLinkText("Foodgrains,"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(food).perform();
		
		
		
	//4. Mouse over "Rice & Rice Products".
		WebElement rice=driver.findElement(By.partialLinkText("Rice"));
		Thread.sleep(2000);
		act.moveToElement(rice).perform();
		
		
	//5. Click on "Boiled & Steam Rice"
		
	driver.findElement(By.partialLinkText("Boiled & Steam Rice")).click();
	
	//6. Filter the results by selecting the brand "bb Royal".
	
	WebElement scroll=driver.findElement(By.xpath("//input[@id='i-bbRoyal']"));	
	act.scrollToElement(scroll).perform();;
	
	driver.findElement(By.xpath("//input[@id='i-bbRoyal']")).click();
	Thread.sleep(2000);
	
	WebElement element = wait.until(
	 ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/pd/40295241/bb-royal-tamil-ponni-boiled-rice-12-17-months-old-26-kg-bag/?nc=l3category&t_pos_sec=1&t_pos_item=4&t_s=Tamil+Ponni+Boiled+Rice'])[1]")));
	element.click();
	
		
	//7. Click on "Tamil Ponni Boiled Rice".
	//driver.findElement(By.xpath("(//a[@target='_blank'])[7]")).click();
	
	//Switching to window
	String parent = driver.getWindowHandle();
	
	System.out.println("I am parent window:"+driver.getTitle());
	System.out.println("parent address" +parent);
	
	//child iwndow
	Set<String> child = driver.getWindowHandles();
	
	for(String childnode:child)
	{
		if(!childnode.equals(parent))
		{
			driver.switchTo().window(childnode);
		}
 		
		System.out.println("I am child title:"+childnode);
		System.out.println(driver.getTitle());
	}
	
	
	
	
	}
	
	
	
}
