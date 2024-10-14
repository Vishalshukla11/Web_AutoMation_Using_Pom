package MyShop_testCase;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import com.example.Base_class.TestBase;
import com.example.DataDriven.ReadDataFromFile;
import com.example.MyShop_Pages.Luma_Home_Page;
import com.example.MyShop_Pages.MyAccount;
import com.example.MyShop_Pages.Registrationpage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.example.TestNgLiseners.TestNGlisners.class)
public class registration_page_TestCases extends TestBase {

    static Logger log4j = Logger.getLogger(HomePageTestCase.class);
    
    Registrationpage registrationpage;
    Luma_Home_Page luma_Home_Page;
    MyAccount myAccount;

    @DataProvider(name = "accountData")
    public Object[][] getAccountData() throws IOException {
        String filePath = prop.getProperty("filePath");
        String sheetName = prop.getProperty("sheetName");
        return ReadDataFromFile.GetExcelData(filePath, sheetName);
    }

    public registration_page_TestCases() {
        super();

    }

    @BeforeClass
    public void Setup() {
        log4j.info("Starting test execution");
        log4j.info("Browser initialized successfully");
        Initilization();
        registrationpage = new Registrationpage();
        luma_Home_Page = new Luma_Home_Page();
        luma_Home_Page.verifyCreatenewAccountLink();
    }

    @Test(priority = 1)
    @Description("Verify Page title")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyPageTitle() {
        test=extent.createTest("Verify page title");
        log4j.info("Verify page title");
        String title = registrationpage.GEtPageTitle();
        org.testng.Assert.assertEquals(title, "Create New Customer Account");
        test.pass("Page title pass");
    }

    @Description("Test create new account ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "accountData", priority = 2)
    public void TestCreatenewAccount(String firstName, String lastName, String email, String password,
            String confirmPassword) throws InterruptedException {
                test=extent.createTest("Test Create new account");
                log4j.info("Test Create new account ");
        registrationpage.ClearExistingDatafromTheTextBox();
        myAccount = registrationpage.testCreateAccount(firstName, lastName, email, password, confirmPassword);
        test.pass("Test create new account pass");
    }

    @AfterClass
    public void TearDown() {
        log4j.info("Tearing down the test");
        extent.flush();
        driver.quit();
        log4j.info("Browser closed");
    }

}
