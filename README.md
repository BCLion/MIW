# MIW Coding Exercise


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 


**Note: Feel free to [clone this repo](https://github.com/BCLion/MIW.git) to have the code, and reports locally, and the jar files for the [Selenium java client](https://github.com/BCLion/MIW/tree/master/Appium-Jars) are also provided.**
### Prerequisites

```
Android SDK using API 27
Jave version 1.8.0_162 or higher
Node v10.15.1
Appium v1.10 or higher
Eclipse Java IDE Mars release or higher
TestNG
Selenium java client
```

### Installing
Install [nodejs](nodejs.org/en/download/)

To install Appium, launch the nodejs command prompt and type:

```
npm install -g appium
```

Install Appium Desktop from https://github.com/appium/appium-desktop/releases/tag/v1/12/0

Install Eclipse from https://eclipse.org

Download Android SDK tools from https://developer.android.com/studio#downloads and select the OS you will be using.

Download Java from https://www.java.com/en/download/ and follow their insructions.


## Running the tests

It is important to make sure your Java path and sdk tools path are in your environment variables for your respective OS.

The BrowserTest performs a search query on Google for mobile integrations group. This is achieved by launching Chrome on an Android phone, and the title of google.com is verified if it is displayed, as well as the image, indicating the page has loaded.

A query is performed, and a console output is displayed containing all the links and their respective texts, it is important to note that the first result is miwtech.com, and it is displayed beneath WebResults in the console output when BrowserTest.java is launched.

The TestNG framework used for AolTest.java has 14 tests total, and can be seen after the @Test annotation.

The AOL client is initialized, launched, the mail icon is selected, and the user logs in with their username and password, an email is composed, and sent.  Screenshots of the inbox containing the subject link GEN TEST 2 are provided in this repo.




### Coding style for the tests
There are two flavors I used. The Chrome browser search test has two files:
1. BrowserTest.java which extends ChromeBase.java and utlizes simple TestNG assertions and is the test in which the execution takes place
    * 1a. ChromeBase.java contains the Android capability types to be used against a real device. A sample of what the code looks like for it:
    
    ```
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
    
    ```


The second style I used were strictly TestNG annotaions for AolTest.java which includes screenshot functionality after each method in order of execution and can be found in this coding exercise repository in the directory [Screenshots](https://github.com/BCLion/MIW/tree/master/Results/Screenshots)

Sample of the TestNG annotations used are as follows:

```
@BeforeSuite 
@AfterSuite
@AfterMethod
@Test

```

A [TestNG report](https://github.com/BCLion/MIW/tree/master/Results/TestNG-Report) is generated showing pass or failed tests.


### Tips

When you have enabled USB debugging on your device, and it is recognized from the command prompt, you will need to disable USB debugging, turn off developer options, unplug your Android from the USB connection, and reboot the phone. After wards enable USB debugging and reconnect your phone to the USB cable. 


