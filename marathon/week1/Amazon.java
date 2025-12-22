package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
/*
 *  

     
03) Type "Bags for boys" in the Search box
04) Choose the item in the result (bags for boys)
05) Print the total number of results (like 50000)
   example like this-----> 1-48 of over 50,000 results for "bags for boys"
06) Select the first 2 brands in the left menu
    (like American Tourister, Generic)
07) Choose New Arrivals (Sort)
08) Print the first resulting bag info (name, discounted price)
09) Get the page title and close the browser(driver.close())

 */
		//Launch Chrome 
		ChromeOptions option = new ChromeOptions();
		  option.addArguments("--guest"); // making this browser in guest mode 
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String s="https://www.amazon.in/";
		driver.manage().window().maximize();
		driver.get(s);
		driver.manage().window().maximize();
		
		//Type "Bags for boys" in the Search box
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("bags for boys",Keys.ENTER);
		//Choose the item in the result (bags for boys)
		//Print the total number of results (like 50000)
		WebElement tot_bag=driver.findElement(By.xpath("//h2[contains(@class,'top-small a-text-normal')]"));
		String value1=tot_bag.getText();
		System.out.println(value1);
		//Select the first 2 brands in the left menu
		driver.findElement(By.xpath("//span[@class='a-list-item']//span[text()='American Tourister']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='a-list-item']//span[normalize-space()='Safari']")).click();
		Thread.sleep(5000);
		//
		//Choose New Arrivals (Sort)
		/*WebElement dropdown=driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
		Select value=new Select(dropdown);
		value.selectByVisibleText("Newest Arrivals");
		*/
		
		driver.findElement(By.xpath("//span[@class='a-button-inner']//span[contains(text(),'Featured')] ")).click();
		
		//(//a[contains(text(),'Newest Arrivals')])[3]
		driver.findElement(By.xpath("//a[normalize-space()='Newest Arrivals'] ")).click();
		Thread.sleep(2000);
		//a[text()='Newest Arrivals']
	/*WebElement name=driver.findElement(By.xpath("(//h2[contains(normalize-space(),'Safari Chase')])"));
	Thread.sleep(2000);
	String name1=name.getText();
	System.out.print(name1);*/
	Thread.sleep(2000);
	//(//span[@class='a-price']//span[@class='a-price-whole'])
	WebElement rate=driver.findElement(By.xpath("//span[@class='a-price-whole']"));
 
	String price=rate.getText();
	System.out.println(price);
		
		
		
		//Thread.sleep(2000);
		//driver.close();
		
	}

	
}
