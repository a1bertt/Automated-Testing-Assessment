import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class employee {

    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a")
    private WebElement pim;

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement Employee;

    @FindBy(id = "firstName")
    private WebElement firstname;

    @FindBy(id = "lastName")
    private WebElement lastname;

    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    private WebElement location;

    @FindBy(xpath = "//*[@id=\"location\"]/option[3]")
    private WebElement locationselect;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement logindetailsbox;

    @FindBy(id = "username")
    private WebElement logdetailsusername;

    @FindBy(id = "password")
    private WebElement logdetailspassword;

    @FindBy(id = "confirmPassword")
    private WebElement logdetailsconfirmpassword;

    @FindBy(xpath = "//*[@id=\"adminRoleId_inputfileddiv\"]/div/input")
    private WebElement adminrole;

    @FindBy(id = "systemUserSaveBtn")
    private WebElement savebutton;

    @FindBy(id = "employee_name_quick_filter_employee_list_value")
    private WebElement employeesearch;

    public void pimclick()
    {
        pim.click();
    }

    public void employeeclick()
    {
        Employee.click();
    }

    public void adddetails(Actions action)
    {
        firstname.click();
        firstname.sendKeys("David");

        lastname.click();
        lastname.sendKeys("Brown");

        location.click();
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }

    public void logindetailsbx()
    {
        logindetailsbox.click();
    }

    public void logindetails()
    {
        logdetailsusername.click();
        logdetailsusername.sendKeys("DavidB");

        logdetailspassword.click();
        logdetailspassword.sendKeys("Pa$$w0rd");
        logdetailsconfirmpassword.click();
        logdetailsconfirmpassword.sendKeys("Pa$$w0rd");
    }

    public void admin(Actions action)
    {
        adminrole.click();
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }

    public void save()
    {
        savebutton.click();
    }

    public void search(Actions action)
    {
        employeesearch.click();
        employeesearch.sendKeys("David Brown");
        action.sendKeys(Keys.ENTER).perform();
    }
}
