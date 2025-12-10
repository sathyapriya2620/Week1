package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.messages.types.Duration;

public class Home_assignment_select {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		  option.addArguments("--guest"); // making this browser in guest mode 
		ChromeDriver driver=new ChromeDriver(option);
		String s="http://leaftaps.com/opentaps/control/main";
		//driver.manage().window().maximize();
		driver.get(s);
		driver.manage().window().maximize();
		
		//Username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//click on login
		driver.findElement(By.className("decorativeSubmit")).click();
		
	
		//button// after logging the account
		driver.findElement(By.id("label")).click();
		
		
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		//accountName
		driver.findElement(By.id("accountName")).sendKeys("Zaara.I");
		//description
		driver.findElement(By.name("description")).sendKeys("i am automation testers");
		
		//Select "ComputerSoftware" as the industry.
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select industry1=new Select(industry);
		industry1.selectByVisibleText("Computer Software");
		
		//Select "S-Corporation" as ownership using SelectByVisibleText
		
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select ownership1=new Select(ownership);
		ownership1.selectByVisibleText("S-Corporation");
		
		//Select "Employee" as the source using SelectByValue.
		
		WebElement employee = driver.findElement(By.name("dataSourceId"));
		Select employee1=new Select(employee);
		employee1.selectByValue("LEAD_EMPLOYEE");
		
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex
		
		WebElement marketing_compaign = driver.findElement(By.id("marketingCampaignId"));
		Select marketing_compaign1=new Select(marketing_compaign);
		marketing_compaign1.selectByIndex(6);
		
		//Select "Texas" as the state/province using SelectByValue.
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select state1=new Select(state);
		state1.selectByValue("TX");
		
		//Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();//create account to submit
		
	//String str1=driver.getTitle();
		//System.out.println(driver.accountName);
		
	
	}

	private static WebElement findElement(By className) {
		// TODO Auto-generated method stub
		return null;
	}

}
