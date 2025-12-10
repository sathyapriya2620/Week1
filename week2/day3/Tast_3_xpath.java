package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tast_3_xpath {

	public static void main(String[] args) {

		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		//Click on the Create new account button.

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
			driver.findElement(By.name("firstname")).sendKeys("sathya");
			
			//lastname
			driver.findElement(By.name("lastname")).sendKeys("irfan");
			//date
			WebElement date=driver.findElement(By.id("day"));
			Select date1=new Select(date);
			date1.selectByValue("26");
			//month
			WebElement month=driver.findElement(By.id("month"));
			Select month1=new Select(month);
			month1.selectByValue("6");
			//year
			WebElement year=driver.findElement(By.id("year"));
			Select year1=new Select(year);
			year1.selectByValue("2011");
			// gender
			driver.findElement(By.xpath("//input[@value='1']")).click();
			//mobile number
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8610128926");
			//passwords
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("sathya@123");
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	}

}
