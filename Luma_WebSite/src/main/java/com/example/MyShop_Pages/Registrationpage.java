package com.example.MyShop_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.Base_class.TestBase;
import com.example.DataDriven.ReadDataFromFile;

public class Registrationpage extends TestBase {
    ReadDataFromFile readdatafromfile;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement FirstNamePath;

    @FindBy(id = "lastname")
    WebElement LastNamePath;

    @FindBy(name = "email")
    WebElement EmailPath;

    @FindBy(id = "password")
    WebElement PasswordPath;

    @FindBy(id = "password-confirmation")
    WebElement ConfirmPasswordPath;

    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    WebElement CreateAnAccountbutton;

    public String GEtPageTitle() {
        return driver.getTitle();
    }

    public Registrationpage()
    {
        PageFactory.initElements(driver, this);
    }

    public void ClearExistingDatafromTheTextBox() {

        WebElement[] elements = { FirstNamePath, LastNamePath, EmailPath, PasswordPath, ConfirmPasswordPath };

        for (WebElement element : elements) {
            if (element != null) {
                element.clear();
            }
        }

    }

    public MyAccount testCreateAccount(String firstName, String lastName, String email, String password,
            String confirmPassword) throws InterruptedException {
        FirstNamePath.sendKeys(firstName);
        LastNamePath.sendKeys(lastName);
        EmailPath.sendKeys(email);
        PasswordPath.sendKeys(password);
        ConfirmPasswordPath.sendKeys(confirmPassword);
        CreateAnAccountbutton.click();

        Thread.sleep(2000);
        return new MyAccount();

        // driver.findElement(By.xpath("//button[@title='Create an Account']")).click();

    }
}
