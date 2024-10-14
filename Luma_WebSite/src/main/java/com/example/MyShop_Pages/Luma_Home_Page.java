package com.example.MyShop_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.Base_class.TestBase;

public class Luma_Home_Page extends TestBase {

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    WebElement storeLogo;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    WebElement signin;

    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    WebElement createNewAccount;

    public Luma_Home_Page() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLogo() {
        return storeLogo.isDisplayed();
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public LoginPage verifySigninlink() {
        signin.click();
        return new LoginPage();
    }

    public Registrationpage verifyCreatenewAccountLink()
    {
        createNewAccount.click();
        return new Registrationpage();
    }

}
