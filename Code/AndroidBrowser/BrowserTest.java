package MIW;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserTest extends ChromeBase {


public static void main(String[] args) throws MalformedURLException {
	 AndroidDriver<AndroidElement> driver = capabilities();	
	 
	 // Verify the web page google.com is loaded correctly.
	 driver.get("http://www.google.com");
	 
	 String url = driver.getCurrentUrl();
	 
	 String title = driver.getTitle();
	 
	 String searchResult = "https://www.miwtech.com";
	 
	 
	 System.out.println("URL is: " + url);
	 Assert.assertTrue(true, url);
	 
	 System.out.println("Page title is: " + title);
	 Assert.assertTrue(true, title);
	 
	 AndroidElement gLogo = driver.findElementById("hplogo");
	 Assert.assertTrue(gLogo.isDisplayed());
	 
	 
	 // Search for mobile integration workgroup
	 
	 AndroidElement searchMIW = driver.findElementByXPath("//input[@name='q']");
	 searchMIW.sendKeys("mobile integration workgroup");
	 searchMIW.sendKeys(Keys.RETURN);
	 
	 JavascriptExecutor jsx = (JavascriptExecutor) driver;
	 jsx.executeScript("window.scrollBy(0,400, )","");
	 
	 
	 //Verify miwtech.com is the first link
	    
	    List<AndroidElement> findLink = driver.findElementsByTagName("a");

   		
	    		
	       for (int i = 0; i < findLink.size(); i++) {
	    	   System.out.println(findLink.get(i).getText()+ "  -> " + findLink.get(i).getAttribute("href"));

	           System.out.println("******************************************************");

	       }
	    
	       
	    
	    
	    

	 
	 
//	 List<AndroidElement> allLinks = driver.findElementsByTagName("a");
//	 allLinks.get(0).getText();
//	 System.out.println("Link text is :" + allLinks);
//	 Assert.assertEquals("https://miwtech.com/", "https://miwtech.com/");
	 
}

	
//	@BeforeSuite
//	public void beforeMethod() throws MalformedURLException{
//		
//			}

}
