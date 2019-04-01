package MIW;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;




public class ChromeBase {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{
	
	AndroidDriver<AndroidElement> driver;
	
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6p");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	
	driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	return driver;
	
	
	
	
	}

}
