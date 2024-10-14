package com.example.TestNgLiseners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGlisners implements ITestListener {
    WebDriver driver;

    public TestNGlisners() {
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(
                "C:\\Users\\acer\\Desktop\\java\\Bridzelabz_softwareTesting_manual_Automation_MobileTesting\\Automation_Testing_using_pom\\himalaya_automation_pom\\src\\failTestCasesScreenshots\\"
                        + result.getMethod().getMethodName() + ".png");
        try {
            FileUtils.copyFile(destination, ts);
            System.out.println("Screenshot saved:- " + destination.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Test Case :---" + result.getMethod().getMethodName() + " Failed" + " and Reason is "
                + result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case:---" + result.getMethod().getMethodName() + " Skipped");

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Case:---" + result.getMethod().getMethodName() + " Started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case :---" + result.getMethod().getMethodName() + " Passed");

    }

}
