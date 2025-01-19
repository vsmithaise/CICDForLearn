package webmd.CMUE;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cmue {

	public static void main(String[] args) {
		
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\srevankar\\Documents\\working\\chromedriver.exe");
			String login_Url="https://www.qa.cmeuniversity.com/";
			
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(login_Url);
			driver.manage().window().maximize();
			//login
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.cssSelector(".account")).click();
			driver.findElement(By.xpath("//input[@placeholder='Email ID or User Name']")).sendKeys("yikom63");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("YIKOM63");
			driver.findElement(By.cssSelector("button.login-button")).click();
			
			//select from All Course
			driver.findElement(By.cssSelector(".left-items a:nth-child(2)")).click();
			List<WebElement> courseDetails = driver.findElements(By.cssSelector(".course-details"));
			WebElement cour = courseDetails.stream().filter(course->course.findElement(By.cssSelector("p")).getText().equals("Hand Involvement in Scleroderma: Early Diagnosis and Management")).findFirst().orElse(null);
			cour.findElement(By.cssSelector("p")).click();
			//	driver.close();

		

	}

}
