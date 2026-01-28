package base;

import com.aventstack.extentreports.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExtentManager;
import java.lang.reflect.Method;


public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getExtent();
    }

    @BeforeMethod
    public void setup(Method method) {
        test = extent.createTest(method.getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/91868/Downloads/AutomationChallenge_2022/QE-index.html");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
