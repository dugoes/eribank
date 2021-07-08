import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    @Test
    public void loginRealizadoComSucesso() {
        loginScreen.login("company", "company");
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.view.View[@class='android.view.View']"),"Your balance is: 100.00$"));
    }

    @Test
    public void loginInvalido(){
        loginScreen.login("company", "compan");
        wait.until(ExpectedConditions.textToBe(By.xpath("//android.widget.Toast"),"Invalid username or password!"));
    }
}
