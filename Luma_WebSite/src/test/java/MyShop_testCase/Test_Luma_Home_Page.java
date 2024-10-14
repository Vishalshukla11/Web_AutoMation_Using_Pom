package MyShop_testCase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.Base_class.TestBase;
import com.example.MyShop_Pages.LoginPage;
import com.example.MyShop_Pages.Luma_Home_Page;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.example.TestNgLiseners.TestNGlisners.class)
public class Test_Luma_Home_Page extends TestBase {
    static Logger log4j = Logger.getLogger(HomePageTestCase.class);

    Luma_Home_Page lumahomepage;
    LoginPage loginpage;

    public Test_Luma_Home_Page() {
        super();
    }

    @BeforeClass
    public void Setup() {

        log4j.info("Starting test execution");
        log4j.info("Browser initialized successfully");
        Initilization();
        lumahomepage = new Luma_Home_Page();
    }

    @Description("Test page title")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void TestPageTitle() {
        test=extent.createTest("Test page title");
        log4j.info("Test page title");
        String title = lumahomepage.validateHomePageTitle();
        Assert.assertEquals("Home Page", title);
        test.pass("Test page title pass");
    }

    @Description("Test logo")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 2)
    public void TestLogo() {
        test=extent.createTest("Test page logo");
        log4j.info("Test logo");
        boolean flag = lumahomepage.verifyLogo();
        Assert.assertTrue(flag);
        test.pass("Test logo pass");
    }

    @Description("Test Signin Page navigatin")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void TestSigninPage_navigation() {
        test=extent.createTest("Test signin page navigation");
        log4j.info("Test signin page  navigate ");
        loginpage = lumahomepage.verifySigninlink();
        test.pass("Test signin page navigation pass");

    }

    @AfterClass
    public void TearDown() {
        log4j.info("Tearing down the test");
        extent.flush();
        driver.quit();
        log4j.info("Browser closed");
    }

}
