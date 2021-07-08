import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PaymentTest extends Base{
    private PaymentScreen paymentScreen;
    private HashMap <String,String> recipient;

    @BeforeTest
    public void tearUP(){
        paymentScreen = new PaymentScreen(driver, wait);
        recipient = new HashMap<>();
    }

    @Test
    public void realizarPagamento() {
        recipient.put("phone","+5541998872997");
        recipient.put("name","Eduardo G. Goes");
        recipient.put("amount","50");
        recipient.put("country","Italy");
        loginScreen.login("company", "company");
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.view.View[@class='android.view.View']"),"Your balance is: 100.00$"));
        paymentScreen.makePayment(recipient);
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.view.View[@class='android.view.View']"),"Your balance is: 50.00$"));
    }

    @Test
    public void cancelarPagamento() {
        recipient.put("phone","+5541998728373");
        recipient.put("name","Louise Goes");
        recipient.put("amount","95");
        recipient.put("country","New Zealand");
        loginScreen.login("company", "company");
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.view.View[@class='android.view.View']"),"Your balance is: 100.00$"));
        paymentScreen.cancelPayment(recipient);
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.view.View[@class='android.view.View']"),"Your balance is: 100.00$"));
    }

    @AfterMethod
    public void logout() {
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/logoutButton']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.experitest.ExperiBank:id/loginButton']")));
    }
}
