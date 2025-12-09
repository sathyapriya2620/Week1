package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions option = new ChromeOptions();
		  option.addArguments("--guest"); // making this browser in guest mode 
		ChromeDriver driver=new ChromeDriver(option);
		String s="http://leaftaps.com/opentaps/control/main";
		//driver.manage().window().maximize();
		driver.get(s);
		driver.manage().window().maximize();
		//username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//submit
		driver.findElement(By.className("decorativeSubmit")).click();
	//	driver.switchTo().alert().accept();
		//to click on crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		//click on lead taps
		//Leads
		driver.findElement(By.linkText("Leads")).click();
		//Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		//first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sathyapriya");
		//create lastname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Irfankhan");
		//create company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		//title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Selenium tester");
		//create lead--submit button
		//smallSubmit
		driver.findElement(By.className("smallSubmit")).click();
		//print title
		String s1=driver.getTitle();
		System.out.println(s1);
		driver.close();

	}

}
