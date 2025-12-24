package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		WebElement scroll=driver.findElement(By.xpath("(//li[@class='nav_first'])[5]/a"));
		Actions act= new Actions(driver);
		act.scrollToElement(scroll).perform();
		File filename=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshot/sample1.png");
		FileUtils.copyFile(filename,target);
		System.out.println(scroll.getText());
		
		

	}

}
