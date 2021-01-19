package com.amazon.utilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	//public AndroidDriver<AndroidElement> androidDriver;
	DesiredCapabilities caps;
    public static ThreadLocal<AndroidDriver<AndroidElement>> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the Thread Local driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return Thread Local driver.
     */
    public AndroidDriver<AndroidElement> initializeDriver() {
    	try {
			caps = new DesiredCapabilities();
			caps.setCapability("browserstack.user", "experion1");
		    caps.setCapability("browserstack.key", "q7vCVpzTo88Nni1sWs9m");
		    caps.setCapability("app", "bs://1f736e92d37ac5e5faa6b3da238deac0a6462818");
		    
		    caps.setCapability("device", "Google Pixel 3");
		    caps.setCapability("os_version", "9.0");		    
		    caps.setCapability("project", "Amazon");
		    caps.setCapability("build", "Amazon Build");
		    caps.setCapability("name", "Test");
		    
		    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "900");
			caps.setCapability("APP_WAIT_ACTIVITY","ccom.amazon.windowshop.home.HomeLauncherActivity");
			tlDriver.set(new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), caps));
		    
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.print(e);
		}
        return getDriver();
    }

    /**
     * this is used to get the driver with ThreadLocal
     */
    public static synchronized AndroidDriver<AndroidElement> getDriver() {
        return tlDriver.get();
    }

}
