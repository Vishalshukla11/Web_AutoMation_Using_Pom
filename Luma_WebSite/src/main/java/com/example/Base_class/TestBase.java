package com.example.Base_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
    //extent report 
     public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter sparkReporter;

    //Logging
    protected Logger log4j=Logger.getLogger(TestBase.class);

//webdriver & properties 
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\acer\\Desktop\\java\\Bridzelabz_softwareTesting_manual_Automation_MobileTesting\\Automation_Testing_using_pom\\himalaya_automation_pom\\src\\main\\java\\com\\example\\MyShop_config\\config.properties");
                        prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void Initilization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("No browser found using this name:-" + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(prop.getProperty("url"));

    }

    //setup extent report 
    @BeforeSuite
    public void SetupExtentReports()
    {
        if(extent==null)
        {
            String reportpath="C:\\Users\\acer\\Desktop\\java\\Bridzelabz_softwareTesting_manual_Automation_MobileTesting\\Automation_Testing_using_pom\\himalaya_automation_pom\\TestReports\\extentReport.html";
            sparkReporter = new ExtentSparkReporter(reportpath);
            extent= new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Host Name", "Vishal shukla");
            extent.setSystemInfo("Environment", "QA");
            
        }
    }

    @AfterClass
    public void tearDownExtentReports()
    {
        if(extent!=null)
        {
            log4j.info("Flushing and closing report");
            extent.flush();
        }
    }


}
