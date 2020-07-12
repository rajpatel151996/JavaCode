 package testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class Link_count

{
	
	WebDriver driver;
	@Test(priority=0)
	public void Login_verify()
	{
	     WebElement ele=driver.findElement(By.id("demo1"));	
		String s=ele.getText();  //login
		System.out.println(s);
		Assert.assertTrue(s.contains("Login"));
		
	}
	
	@Test(priority=1)
	public void count()
	{
	     List<WebElement> ele =driver.findElements(By.tagName("a"));
	     int i=ele.size();
	     System.out.println(i);
	    for(WebElement e:ele)
	    {
	    	System.out.println(e.getText());
	    }
	    
	   /*  List<WebElement>el=driver.findElements(By.xpath("//*"));
	     int i1=el.size();
	     System.out.println(i);
	     for(int j=0;j<i;j++)
	     {
	    	 System.out.println(el.get(j).getText());
	     }
	     */
	}
	
	 @Test(priority=2)
	  public void test1()
	  {
		    
		    driver.findElement(By.id("userName")).sendKeys("1234");
			driver.findElement(By.id("password")).sendKeys("9999");
			driver.findElement(By.name("Login")).click();
		//	Navigation.back();
			
	  }
	 
 //correct cerdential
  @Test(priority=3)
  public void test2() throws InterruptedException
  {      Thread.sleep(4000); 
	    driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		 WebElement ele=driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul"));	
			String s=ele.getText();  //login   //*[@id="header"]/div[1]/div/div/div[2]/div/ul
			System.out.println(s);
		Assert.assertTrue(s.contains("Hi, Lalitha SignOut"));
		
		System.out.println("successfully");
  }
  @BeforeTest
  public void config()
  { 
	  System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/loginhere.htm");
  }
  @AfterTest
  public void closed()
  {
	  driver.close();
	 
	 
  } 
  
}
