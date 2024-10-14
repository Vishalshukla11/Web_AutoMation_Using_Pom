package MyShop_testCase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.Base_class.TestBase;
import com.example.MyShop_Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.example.TestNgLiseners.TestNGlisners.class)
public class HomePageTestCase extends TestBase {

    static Logger log4j = Logger.getLogger(HomePageTestCase.class);

    HomePage homePage;
    LoginPage loginpage;
    Luma_Home_Page lumahomepage;
    WhatsnewPage whatsnewPage;
    Women women;
    Men men;
    Gear gear;
    Training training;
    Sale sale;

    public HomePageTestCase() {
        super();
    }

    @BeforeClass
    public void setup() {
        log4j.info("Starting test execution");
        Initilization();

        lumahomepage = new Luma_Home_Page();
        lumahomepage.verifySigninlink();
        log4j.info("Verified sign-in link on Luma home page");
        homePage = new HomePage();
        loginpage = new LoginPage();
    }

    // Helper method to navigate to pages and perform logging
    private void navigateToPage(String pageName, Object page) {
        log4j.info("Navigating to " + pageName);
        test = extent.createTest("Test " + pageName);
        if (page instanceof WhatsnewPage) {
            whatsnewPage = homePage.WhatsNewPage();
        } else if (page instanceof Women) {
            women = homePage.WomenPage();
        } else if (page instanceof Men) {
            men = homePage.MenPage();
        } else if (page instanceof Gear) {
            gear = homePage.GearPage();
        } else if (page instanceof Training) {
            training = homePage.TrainingPage();
        } else if (page instanceof Sale) {
            sale = homePage.SalePage();
        }
        test.pass("Navigated to " + pageName);
        log4j.info("Successfully navigated to " + pageName);
    }

    @Test(priority = 1)
    @Description("Verifying what's new page")
    @Severity(SeverityLevel.CRITICAL)

    public void testWhatsNew() {
        navigateToPage("WhatsNew", new WhatsnewPage());
        org.testng.Assert.assertEquals(driver.getTitle(), "What's New");
    }

    @Test(priority = 2)
    @Description("Test for navigating to Women page")
    @Severity(SeverityLevel.CRITICAL)
    public void testWomen() {
        navigateToPage("Women", new Women());
        Assert.assertEquals(driver.getTitle(), "Women");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for navigating to Men page")
    public void testMen() {
        navigateToPage("Men", new Men());
        Assert.assertEquals(driver.getTitle(), "Men");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for navigating to Gear page")
    public void testGear() {
        navigateToPage("Gear", new Gear());
        Assert.assertEquals(driver.getTitle(), "Gear");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for navigating to Training page")
    public void testTraining() {
        navigateToPage("Training", new Training());
        Assert.assertEquals(driver.getTitle(), "Training");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for navigating to Sale page")
    public void testSale() {
        navigateToPage("Sale", new Sale());
        Assert.assertEquals(driver.getTitle(), "Sale");
    }

    @AfterClass
    public void tearDown() {
        log4j.info("Tearing down the test");
        extent.flush();
        driver.quit();
        log4j.info("Browser closed");
    }
}
