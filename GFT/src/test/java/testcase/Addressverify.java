package testcase;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Addressverify 
{
     WebDriver driver;

	 @BeforeTest
	  public void launch() 
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\RajPC\\Downloads\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  }
	
	 @Test
	  public void login() throws InterruptedException
	  {   
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		  driver.findElement(By.id("userName")).sendKeys("Lalitha");
		  driver.findElement(By.id("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();
		  Thread.sleep(2000);
		  WebElement ele=driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul"));	
			String s=ele.getText();  
		
		Assert.assertTrue(s.contains("Hi, Lalitha SignOut"));
		
		System.out.println("successfully");
	  }
	  
	 @Test
	 public void user() throws InterruptedException
	 {
		 Actions a=new Actions(driver);
	   WebElement ele= driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"));
		a.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span")).click();
		 driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[1]/a/span")).click();
		 Thread.sleep(2000);
		
		 String main=driver.getWindowHandle();
			System.out.println(main);
			Set<String> win=driver.getWindowHandles();
			for(String s:win)
			{
			if(!main.equals(s))
			{
				driver.switchTo().window(s);
				System.err.println(s);
			}
			}
		 driver.switchTo().frame("main_page");
		 String s1 =driver.findElement(By.xpath("//*[@id=\"demo3\"]/b/p[3]")).getText();
		    String s2="Contact Us";
		
		    if(s1.equalsIgnoreCase(s2))
		    {
		    	
		    	System.out.println("correct");	
		    
		    String s11=	driver.findElement(By.xpath("//*[@id=\"demo3\"]")).getText();
	    	System.out.println(s11);
	    	String se=driver.findElement(By.xpath("//*[@id=\"demo3\"]/b/p[4]")).getText();
	    	System.out.println(se);
	    	if(driver.getPageSource().contains(se))
	    	{
	    		Assert.assertTrue(s11.contains(se));
	    	//Assert.assertTrue(("Testme Inc. 123, Velachery Main Road Chennai, India ,Mobile: +91 9898912345 Fax: 84554323 Email: info@testmeapp.com").contains(s));
	    	}
		    }
		//  window handling  
		 /*Set<String> window=driver.getWindowHandles();
		   Iterator<String> itr=window.iterator();
		   
		   String main_window=itr.next();
		   System.out.println(main_window);
		  
		   String child_window=itr.next();
		   System.out.println(child_window);
		
		   driver.switchTo().window(child_window);
		   Thread.sleep(3000);
		   System.out.println(driver.getTitle()); 
		   Thread.sleep(3000);
		  */
		//driver.switchTo().frame("menu_page");
		  // driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
		
		
   
	 }
	@Test
     public  void Address() throws InterruptedException
	{    
		

			System.out.println("correct");
	//	     WebElement ele =driver.findElement(By.name("main_page"));
		  /*      driver.switchTo().frame("main_page");
		    String s1 =driver.findElement(By.xpath("//*[@id=\"demo3\"]/b/p[3]")).getText();
			Assert.assertTrue(s1.contains("Chennai, India"));
			System.out.println("correct");
		   
		   
		/*String main=driver.getWindowHandle();
		 Set<String> Handles = driver.getWindowHandles();
	        
	        for(String handle: Handles){
	            if(!handle.equals(main)){
	            driver.switchTo().window(handle);
	         System.out.println("Title of the new window: "+driver.getTitle());
	       }}
	         */
	 
		//	/html/frameset/frame[2]
	    
	
	}
	 @AfterTest
	  public void closed() 
	  {
		  System.out.println("ghaghdjkasjdk");
	  }
		
	
}
