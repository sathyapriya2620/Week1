package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pvr {

	public static void main(String[] args) throws InterruptedException {

		

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		  option.addArguments("--guest"); // making this browser in guest mode 
		
		  ChromeDriver driver=new ChromeDriver(option);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 //{ Launch the Browser}
		String s="https://www.pvrcinemas.com/";
		driver.get(s);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='date-show']/span[text()='Cinema']")).click();
		
		//div[@class='date-show']/span[text()='Cinema']
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		//Thread.sleep(2000);
		
		//Click on Cinema under Quick Book
		driver.findElement(By.xpath("//li[contains(@class,'p-dropdown-item')]//span[contains(normalize-space(),'INOX The Marina Mall, OMR, Chennai')]")).click();
		////span[text()='INOX National,Virugambakkam Chennai']
		
		Thread.sleep(2000);
		//li[contains(@class,'p-dropdown')]/span[text()='Today']
		//driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		//span[text()='Today']
		
		WebElement date=driver.findElement(By.xpath("//li[contains(@class,'p-dropdown-item')]/span[contains(text(),'Today')]"));
		Thread.sleep(3000);
		date.click();
		
		//driver.findElement(By.xpath("//span[text()='Select Movie']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[contains(@class,'p-dropdown-item')][2]")).click();
		Thread.sleep(2000);
		WebElement time=driver.findElement(By.xpath("//li[contains(@class,'p-dropdown-item') and contains(normalize-space(.),'07:35 PM') and contains(normalize-space(.),'Tamil')]"));
		Thread.sleep(5000);
		time.click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		////button[text()='Accept']
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		////span[@id='EX.EXECUTIVE|L:18']
		WebElement book=driver.findElement(By.xpath("//span[@id='CL.CLUB|H:1']"));
		Thread.sleep(5000);
		book.click();
		////h6[contains(normalize-space(.),'111.77')]
		WebElement price=driver.findElement(By.className("grand-prices"));
		String Grandprice=price.getText();
		System.out.println("the grand total is:"+Grandprice);
		WebElement seat=driver.findElement(By.className("select-seat-number"));
		String seatnum = seat.getText();
		System.out.println("The seat number is:"+seatnum);
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		//Thread.sleep(2);
		//.close();
		
		//pi pi-times
		WebElement click1=driver.findElement(By.xpath("//div[@class='cross-icon mx-2'])[2]"));
		Thread.sleep(5000)	;
		click1.click();
		
	}

	
	}


