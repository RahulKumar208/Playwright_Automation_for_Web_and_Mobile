package com.codenbox.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class base {
	
	public AppiumDriverLocalService service;
    
	@Test
    public void configureAppium() throws MalformedURLException{
		
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\pc\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("demo");
        options.setApp(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\ApiDemos-debug.apk");
        
        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            // Your test code here
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // Quit the driver after the test
            driver.quit();
            service.stop();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}