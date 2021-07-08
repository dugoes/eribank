import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class PaymentScreen {
    private final AndroidDriver <MobileElement> driver;
    private final WebDriverWait wait;

    public PaymentScreen(AndroidDriver <MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void makePayment(HashMap<String,String> recipient) {
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/makePaymentButton']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/phoneTextField']")));
        driver.findElementByXPath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/phoneTextField']").sendKeys(recipient.get("phone"));
        driver.findElementByXPath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/nameTextField']").sendKeys(recipient.get("name"));
        driver.findElementByXPath("//android.widget.SeekBar[@resource-id='com.experitest.ExperiBank:id/amount']").sendKeys(recipient.get("amount"));
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/countryButton']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView")));
        driver.findElementByXPath("//android.widget.TextView[@text='"+recipient.get("country")+"']").click();
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/sendPaymentButton']").click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"),"Are you sure you want to send payment?"));
        driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").click();
    }

    public void cancelPayment(HashMap<String,String> recipient) {
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/makePaymentButton']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/phoneTextField']")));
        driver.findElementByXPath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/phoneTextField']").sendKeys(recipient.get("phone"));
        driver.findElementByXPath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/nameTextField']").sendKeys(recipient.get("name"));
        driver.findElementByXPath("//android.widget.SeekBar[@resource-id='com.experitest.ExperiBank:id/amount']").sendKeys(recipient.get("amount"));
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/countryButton']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView")));
        driver.findElementByXPath("//android.widget.TextView[@text='"+recipient.get("country")+"']").click();
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/cancelButton']").click();
    }
}
