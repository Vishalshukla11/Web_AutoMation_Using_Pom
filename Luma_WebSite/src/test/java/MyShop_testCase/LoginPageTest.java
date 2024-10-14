package MyShop_testCase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.Base_class.TestBase;
import com.example.MyShop_Pages.HomePage;
import com.example.MyShop_Pages.LoginPage;
import com.example.MyShop_Pages.Luma_Home_Page;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.example.TestNgLiseners.TestNGlisners.class)
public class LoginPageTest extends TestBase {
    static Logger log4j = Logger.getLogger(HomePageTestCase.class);
    Luma_Home_Page lumahomepage;
    LoginPage loginPage;
    HomePage homepage;

    public LoginPageTest() {
        super();
    }

    @BeforeClass
    public void Setup() {
        log4j.info("Starting test execution");
       
        log4j.info("Browser initialized successfully");
        Initilization();

        lumahomepage = new Luma_Home_Page();
        lumahomepage.verifySigninlink();
        loginPage = new LoginPage();

    }

    @Description("verify page title")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void verifyPageTitle() {
        test = extent.createTest("Test verify Page Title");
        log4j.info("Verify page title");
        String title = loginPage.pageTitle();
        Assert.assertEquals(title, "Customer Login");
        test.pass("Page title test case pass");
    }

    @Test(priority = 2)
    public void TestCreateAnAccount() {
        test = extent.createTest("Test Create Account button");
        log4j.info("Verify test create an account button");
        boolean createaccountbtn = loginPage.createnewAccountButton();
        Assert.assertTrue(createaccountbtn);
        test.pass("Create an account button test case pass");
    }

    @Test(priority = 3)
    public void TestSignIn() {
        test = extent.createTest("Test Signin ");
        log4j.info("Test signin functionality");
        homepage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

        test.pass("Test Signin Functionality");
    }

    // @Test(priority = 4)
    // public void TestForgetPasswordlink() {
    //     test = extent.createTest("Test Forget password link");
    //     log4j.info("Test Forget passwordlink");
    //     loginPage.ForgotPasswordlink();
    //     test.pass("Test forget password link pass");
    // }

    @AfterClass
    public void TearDown() {
        log4j.info("Tearing down the test");
        if (extent != null) {
            extent.flush();  // Ensure extent report is flushed
        }
        driver.quit();
        log4j.info("Browser closed");
    }

}
