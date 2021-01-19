package com.amazon.base;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	DesiredCapabilities caps;
	public AndroidDriver<AndroidElement> androidDriver;
	
	
	@BeforeTest
	public void androidRun() {
		
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
			
		    androidDriver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
		    androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
	@AfterTest
	public void teardown() {
		androidDriver.quit();
	}
	
}
