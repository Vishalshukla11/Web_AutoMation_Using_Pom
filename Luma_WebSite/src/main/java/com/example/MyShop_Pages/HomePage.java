package com.example.MyShop_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.Base_class.TestBase;

public class HomePage  extends TestBase{

    @FindBy(xpath="//a[@id='ui-id-3']//span[1]")
    WebElement WhatsNew;

    @FindBy(xpath = "//a[@id='ui-id-4']//span[contains(text(),'Women')]")
    WebElement Women;

    @FindBy(xpath = "//a[@id='ui-id-5']")
    WebElement Men;

    @FindBy(xpath = "//span[normalize-space()='Gear']")
    WebElement Gear;

    @FindBy(xpath = "//span[normalize-space()='Training']")
    WebElement Training;

    @FindBy(xpath = "//span[normalize-space()='Sale']")
    WebElement Sale ;

    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    public WhatsnewPage WhatsNewPage()
    {
        WhatsNew.click();
        return new WhatsnewPage();
    }

    public Women WomenPage()
    {
        Women.click();
        return new Women() ;
    }

    public Men MenPage()
    {
        Men.click();
        return new Men();
    }

    public Gear GearPage()
    {
        Gear.click();
        return new Gear();
    }

    public Training TrainingPage()
    {
        Training.click();
        return new Training();
    }

    public Sale SalePage()
    {
        Sale.click();
        return new Sale();
    }
    
}
