import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    protected AndroidDriver <MobileElement> driver;
    protected WebDriverWait wait;
    protected LoginScreen loginScreen;

    @BeforeTest
    public void tearUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.experitest.ExperiBank");
        desiredCapabilities.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver <>(remoteUrl, desiredCapabilities);

        wait = new WebDriverWait(driver,20);

        driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").click();

        loginScreen = new LoginScreen(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
