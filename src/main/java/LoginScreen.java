import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen {
    private final AndroidDriver <MobileElement> driver;

    public LoginScreen(AndroidDriver <MobileElement> driver) {
        this.driver = driver;
    }

    public void login(String user, String passwd){
        driver.findElementByXPath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/usernameTextField']").sendKeys(user);
        driver.findElementByXPath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/passwordTextField']").sendKeys(passwd);
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/loginButton']").click();
    }
}
