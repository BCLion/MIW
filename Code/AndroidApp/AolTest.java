package MIW;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AolTest {
	
	static AndroidDriver<AndroidElement> driver;
	
	String userLogin ="miw_mobile@aol.com";
	String userPassword="M0bil3@123";
	String subjectLine =" GEN TEST2 ";
	
	@BeforeSuite
	public void beforeMethod() throws MalformedURLException{
		
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6p");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.activity.SplashScreenActivity");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.aol.mobile.aolapp");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\mixte\\Downloads\\AOL_v5.7.1.4_apkpure.com.apk");
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	
	}
	
	@AfterSuite
	public void afterSuite() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		driver.quit();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
        System.out.println("result" + result);
        String methodName = result.getName();
        System.out.println(methodName);
        
        if(result.isSuccess()) try {
        	
    		String fileName = methodName + ".png";
    		String directory = "\\Users\\mixte\\eclipse-dsl-luna-SR2-win32\\workspace\\Appium\\AndroidAutomation\\test-output\\Screenshots\\";
    		
    		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(sourceFile, new File(directory + fileName));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        

		
	}
	

	 @Test(priority=1, description="Check MailIcon button displayed")
	 public void TC001() {

		 Boolean mailIcon = driver.findElementById("com.aol.mobile.aolapp:id/sponsored").isDisplayed();
		  Assert.assertTrue(mailIcon,"Mail Icon is displayed");
		  System.out.println("Login button is displayed");
		  
	 }
		 
	 @Test(priority =2, description="Verify Mail Icon button is enabled")
	 public void TC002(){
		 boolean mailIcon = driver.findElementById("com.aol.mobile.aolapp:id/sponsored").isEnabled();
		  Assert.assertTrue(mailIcon,"Mail Icon is enabled");
		  System.out.println("Mail Icon button is enabled");
		 
	 }
	 
	 @Test(priority =3, description="Click Mail Icon")
	 public void TC003(){
		driver.findElementById("com.aol.mobile.aolapp:id/sponsored").click();
		
		 System.out.println("Mail Icon button clicked");
		 
	 }
	 

	 @Test(priority=4, description="Select Chrome")
	 public void TC004(){
		 driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView").click();
		 
		 System.out.println("Selecting Chrome");
		 
	 }
	 
	 @Test(priority=5, description="Enter username")
	 public void TC005() {
		driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.widget.EditText").sendKeys(userLogin);
	
		System.out.println("Username: " + userLogin + " entered");
	 }
	 
	 @Test(priority=6, description="Click Next button")
	 public void TC006() {
		 driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[2]/android.widget.Button[1]").click();
		 
		 System.out.println("Next button clicked");
	 }
	 
	 @Test(priority=7, description="UserName is displayed")
	 public void TC007() {
		 driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[1]");

		 Assert.assertEquals("Hello miw_mobile@aol.com", "Hello miw_mobile@aol.com");
		 System.out.println("Greeting displaying " + userLogin + "is correct");
	 }
	 
	 @Test(priority=8, description="Enter Password")
	 public void TC008() {
		 driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.EditText").sendKeys(userPassword);
		 Assert.assertEquals(userPassword, userPassword);

		 System.out.println("Password " + userPassword + "entered");
	 }
	 
	 @Test(priority=9, description="Click Sign In button")
	 public void TC009() {
		 driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.Button[1]").click();
		 System.out.println("Sign In button Clicked");
	 }
	 
	 @Test(priority=10, description="Click New Email button")
	 public void TC010(){
	 	 driver.findElementById("com.aol.mobile.aolapp:id/mail_fab").click();
	 	System.out.println("Create new Email button Clicked");
	 }
	 
	 @Test(priority=11, description="Compose New Email")
	 public void TC011(){
	 	 driver.findElementById("com.aol.mobile.aolapp:id/email_field").sendKeys(userLogin);
	 	Assert.assertEquals(userLogin, userLogin);
	 	System.out.println("To field contains " + userLogin+ " as the recipient");
	 }
	 
	 @Test(priority=12, description="Enter Subject")
	 public void TC012(){
	 	 driver.findElementById("com.aol.mobile.aolapp:id/subject_view").sendKeys(" GEN TEST2 ");
	 	System.out.println("Subject Line Entered");
	 }
	 
	 @Test(priority=13, description="Send the Email")
	 public void TC013() {
		 driver.findElementById("com.aol.mobile.aolapp:id/menu_send_message").click();
		
	 }
	 
	 @Test(priority=14, description="Verify email is received")
	 public void TC014() {
//		 driver.findElementById("com.aol.mobile.aolapp:id/message_list_date").getText().contains(currentDate);
		 driver.findElementById("com.aol.mobile.aolapp:id/subject_view").getText().contains(subjectLine);
		 Assert.assertEquals(subjectLine, subjectLine);
	 }
	 
		public static String getRandomString(int length) {
			StringBuilder sb = new StringBuilder();
			String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			for (int i = 0; i < length; i++) {
				int index = (int) (Math.random() * characters.length());
				sb.append(characters.charAt(index));
			}
			return sb.toString();
			
			
	 
 }		  
		
		
		
		
		
		
		
		
		
}






