package study;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StudyDriveTest {

    public static AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", "C:\\Users\\pc\\Downloads\\StudyDrive\\studydrive.apk");
        dc.setCapability("appium:deviceName", "OnePlus 6");
        dc.setCapability("appium:platformVersion", "11");
        dc.setCapability("autoGrantPermissions", true); // Auto accept permissions

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testOnboardingAndFileUpload() {
        // Handle Cookie Consent pop-up (if present)
        try {
            // Explicit wait for the cookie consent button to appear
            WebElement acceptCookies = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/textViewButtonIcon\" and @text=\"Accept all\"]")));

            // Clicking the Accept button if visible
            acceptCookies.click();
            System.out.println(" Cookie consent accepted.");
        } catch (Exception e) {
            System.out.println(" No cookie consent pop-up detected, continuing...");
        }
        
        System.out.println("Next Step");

        // Click "Signup" Button
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/buttonConstraintLayout\"])[3]")).click();
        


        //  Enter Email
        WebElement emailInput = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/editTextConstraintLayout\"]"));
        emailInput.sendKeys("qatestingautomation5@gmail.com");
      


        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/buttonConstraintLayout\"]")).click();
        

        // Enter Password
        WebElement passwordInput = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/editTextConstraintLayout\"])[2]"));
        passwordInput.sendKeys("Qwerty123$");

        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/buttonConstraintLayout\"]")).click();

        // Choose Display Name
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/textViewButtonIcon\"]")).click();

        //  Select "Student" as user type
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"At University\"]")).click();
      


        //  Enter University Name
        WebElement universityInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"de.veedapp.veed:id/textInputEditText\"]"));
        universityInput.sendKeys("987654321");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/titleTextView\"]")).click();

        // Select Study Major
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"de.veedapp.veed:id/textInputEditText\" and @text=\"Select field of studies\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/titleTextView\" and @text=\"Mathematics, Computer Sciences & Natural Sciences\"]")).click();

        //  Select Study Program
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"de.veedapp.veed:id/textInputEditText\" and @text=\"Select study program\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/titleTextView\" and @text=\"Computer Engineering\"]")).click();

        driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@resource-id=\"de.veedapp.veed:id/notSureCardView\"]")).click();

        
        //  Select Semester
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"de.veedapp.veed:id/textInputEditText\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/titleTextView\" and @text=\"Winter 2024/25\"]")).click();

        //  Continue
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/buttonConstraintLayout\"]")).click();

        //  Navigate to "Courses"
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"de.veedapp.veed:id/navImageViewUnselected\"])[3]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/courseNameTextView\" and @text=\"microeconomics\"]")).click();

        //  Join "Microeconomics" Course
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/textViewButtonIcon\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"de.veedapp.veed:id/actionButtonIcon\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"de.veedapp.veed:id/documentButton\"]")).click();

        //  Upload File
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"de.veedapp.veed:id/textViewButtonIcon\" and @text=\"Browse my files\"]")).click();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("C:\\Users\\pc\\Downloads\\studydrive_testing.pdf");

        //  Select "Semester"
      /*  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Semester']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Winter 2024/25']")).click();

        //  Select "Document Type"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Document Type']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Other']")).click();

        //  Select "Language"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Language']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='English']")).click();

        //  Select Course
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Enter course name']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Microeconomics']")).click();
*/
        //  Enter Description
        WebElement descriptionInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"de.veedapp.veed:id/textInputEditText\" and @text=\"Description\"]"));
        descriptionInput.sendKeys("Test document upload.");

        //  Click "Upload and Earn Rewards"
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"de.veedapp.veed:id/buttonConstraintLayout\"])[1]")).click();

        
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
