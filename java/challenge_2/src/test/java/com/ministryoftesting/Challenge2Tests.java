package com.ministryoftesting;

import BaseTest.BaseTest;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


//    Welcome to UI Automation Challenge 2
//
//    For this challenge it's all about creating clean, readable and maintainable code. Below
//    are five tests that work (just about) but require cleaning up. Update this class so that
//    code base so that it's easier to maintain, more readable and has sensible ways of asserting
//    data. You might want to research different approaches to improving UI automation such as
//    Page Object Models and implicit vs. explicit waits

public class Challenge2Tests extends BaseTest {

//  Test one: Check to see if you can log in with valid credentials
    @Test
    public void loginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/");

        //Creating object of home page
        HomePage home = new HomePage(driver);

        //Creating object of Admin page
        AdminPage adminPage = new AdminPage(driver);

        //Login to the Admin Panel
        home.clickLogin("admin","password");

        //Check the title
        assertTrue(adminPage.checkText("Rooms"));

    }

//  Test two: Check to see if rooms are saved and displayed in the UI
    @Test
    public void room() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/");

        //Creating object of home page
        HomePage home = new HomePage(driver);

        //Creating object of Admin page
        AdminPage adminPage = new AdminPage(driver);

        //Login to the Admin Panel
        home.clickLogin("admin","password");

        //Create Rool
        adminPage.createRoom("101","101");

        //Check the creation
        assertTrue(adminPage.checkCreation());
    }

//  Test three: Check to see the confirm message appears when branding is updated
    @Test
    public void updateBrandin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationintesting.online/#/admin");

        //Creating object of home page
        HomePage home = new HomePage(driver);

        //Creating object of Admin page
        AdminPage adminPage = new AdminPage(driver);

        //Creating object of Branding page
        BrandingPage brandingPage = new BrandingPage(driver);

        //Login to the Admin Panel
        home.clickLogin("admin","password");

        driver.get("https://automationintesting.online/#/admin/branding");

        brandingPage.enterFormValue("test");

        //Check the creation
        assertTrue(brandingPage.checkCreation());
    }

    WebDriver driver;

//  Test four: Check to see if the contact form shows a success message
    @Test
    public void ContectCheck() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online");


        //Creating object of Contact page
        ContactFormPage contactFormPage = new ContactFormPage(driver);

        //Fill in form and Submit
        contactFormPage.fillContactForm("Test userName", "test@test.com", "1234567894242", "This is a test email", "This is a long text a very long text");

        //Check if the message is present
        assertTrue(contactFormPage.checkConfirmation("Thanks for getting in touch"));
    }

//  Test five: Check to see if unread messages are bolded
    @Test
    public void isTheMessageBoldWhenUnreadInTheMEssageViwe() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://automationintesting.online/#/admin/messages");

        //Creating object of home page
        HomePage home = new HomePage(driver);

        //Creating object of AdminMessagePage page
        AdminMessagesPage adminMessagePage = new AdminMessagesPage(driver);

        home.clickLogin("admin","password");

        driver.navigate().to("https://automationintesting.online/#/admin/messages");

        //Check that there are more than 1 unread messages
        assertTrue(adminMessagePage.checkMessageList(1));
    }


}
