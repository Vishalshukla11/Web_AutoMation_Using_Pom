package com.example.MyShop_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.Base_class.TestBase;

public class LoginPage extends TestBase {
    @FindBy(id = "email")
    WebElement loginEmail;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(xpath = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]")
    WebElement createnewButton;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    WebElement signinBtn;

    @FindBy(xpath = "//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]")
    WebElement forgotPasswordlink;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public boolean createnewAccountButton() {
        return createnewButton.isDisplayed();
    }

    public HomePage Login(String un,String pw) {
        loginEmail.sendKeys(un);
        password.sendKeys(pw);
        signinBtn.click();
        return new HomePage();
    }

    public ForgotPassword ForgotPasswordlink() {
        driver.navigate().back();
        forgotPasswordlink.click();
        return new ForgotPassword();
    }
}
