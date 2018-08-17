import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class ATRunnerSteps {

    WebDriver driver;
    private static ExtentReports report = new ExtentReports(Constants.path_ATReport, true);
    public ExtentTest test;

    Actions action;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
    }

    @After
    public void teardown()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        report.endTest(test);
        report.flush();
    }

    @Given("^the login page$")
    public void the_login_page()
    {
        driver.get(Constants.path_OrangeHRM);
        test = report.startTest("OrangeHRM Website Test Reports");
        test.log(LogStatus.INFO, "Browser Started");

        if(driver.getCurrentUrl().equals(Constants.path_OrangeHRM))
        {
            test.log(LogStatus.PASS, "Webpage accessed correctly");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed!");
        }

        assertEquals(driver.getCurrentUrl(), Constants.path_OrangeHRM);
    }

    @When("^I login$")
    public void i_login()
    {
        loginPage loginpg = PageFactory.initElements(driver, loginPage.class);
        loginpg.loginclick();

        assertEquals(driver.getCurrentUrl(), Constants.path_Mainpage);
        test.log(LogStatus.INFO, "Orange HRM login page accessed correctly");
        test.log(LogStatus.PASS, "Successfully navigated to Main page");
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab()
    {
        employee employeepg = PageFactory.initElements(driver, employee.class);
        employeepg.pimclick();
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        employee employeepg = PageFactory.initElements(driver, employee.class);
        employeepg.employeeclick();

        assertEquals(driver.getCurrentUrl(),"https://qa-trials641.orangehrmlive.com/client/#/pim/employees");
        test.log(LogStatus.INFO, "Add Employee page accessed correctly");
        test.log(LogStatus.PASS, "Successfully navigated to Add Employee page");
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly()
    {
        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        employee employeepg = PageFactory.initElements(driver, employee.class);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        employeepg.adddetails(action);
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button()
    {
        employee employeepg = PageFactory.initElements(driver, employee.class);
        employeepg.logindetailsbx();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly()
    {
        employee employeepg = PageFactory.initElements(driver, employee.class);
        employeepg.logindetails();
        employeepg.admin(action);
    }


    @When("^I click the Save button$")
    public void i_click_the_Save_button()
    {
        employee employeepg = PageFactory.initElements(driver, employee.class);
        employeepg.save();
        test.log(LogStatus.INFO, "Add a new Employee");
        test.log(LogStatus.PASS, "Successfully Added a new Employee");
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created()
    {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://qa-trials641.orangehrmlive.com/client/#/pim/employees");

        employee employeepg = PageFactory.initElements(driver, employee.class);
        employeepg.search(action);
        test.log(LogStatus.INFO, "Search for the new Employee added");
        test.log(LogStatus.PASS, "Successfully found the new Employee added");
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
