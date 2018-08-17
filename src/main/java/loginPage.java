
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
    @FindBy(id = "txtUsername")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement password;

    public void loginclick()
    {
        username.click();
        username.sendKeys("Admin");

        password.click();
        password.sendKeys("AdminAdmin");

        password.submit();
    }
}
