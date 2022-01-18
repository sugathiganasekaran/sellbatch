package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
	   driver.manage().window().maximize();
	   Thread.sleep(2000);
	   WebElement username = driver.findElement(By.id("username"));
       username.sendKeys("DemoSalesManager");
       driver.findElement(By.id("password")).sendKeys("crmsfa");
       driver.findElement(By.className("decorativeSubmit")).click();
       driver.findElement(By.linkText("CRM/SFA")).click();
       driver.findElement(By.linkText("Contacts")).click();
       driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
       driver.findElement(By.xpath("//input[@id='partyIdFrom']//following::a[1]")).click();
       Set<String>set=driver.getWindowHandles();
      List<String> list=new ArrayList<String>(set);
      
      String childwin=list.get(1);
      
      driver.switchTo().window(childwin);
      
       driver.findElement(By.xpath("//a[@class='linktext']")).click();
       
       String parentwindow=list.get(0);
       
       driver.switchTo().window(parentwindow);
       
       
       driver.findElement(By.xpath("//input[@id='partyIdTo']//following::a[2]")).click();
      driver.switchTo().window(childwin);
      
       driver.findElement(By.xpath("//a[@class='linktext']")).click();
        
     driver.switchTo().window(parentwindow);
       
       driver.findElement(By.xpath("//a[text()='Merge']")).click();
      Alert alert = driver.switchTo().alert();
      System.out.println(alert.getText());
       alert.accept();
       driver.close();
       
	
	
	}

}
