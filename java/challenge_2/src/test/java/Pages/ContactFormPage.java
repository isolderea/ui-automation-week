package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ContactFormPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public ContactFormPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for Name
    By NameTxt = By.cssSelector("input[placeholder=\"Name\"]");

    //Locator Email
    By EmailTxt = By.cssSelector("input[placeholder=\"Email\"]");

    //Locator Phone
    By  PhoneTxt = By.cssSelector("input[placeholder=\"Phone\"]");

    //Locator for Subject
    By  SubjectTxt = By.cssSelector("input[placeholder=\"Subject\"]");

    //Locator for Message
    By  MessageTxt = By.cssSelector("textarea");

    //Locator for Submit button
    By  SubmitButton = By.xpath("//button[text()=\"Submit\"]");

    //Locator for Confirmation text
    By  ConfirmationTxt = By.cssSelector(".col-sm-5 > div");


    //Method to fill the the form
    public void fillContactForm(String name, String email, String phone, String Subject, String message) {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(NameTxt));
        driver.findElement(NameTxt).sendKeys(name);
        driver.findElement(EmailTxt).sendKeys(email);
        driver.findElement(PhoneTxt).sendKeys(phone);
        driver.findElement(SubjectTxt).sendKeys(Subject);
        driver.findElement(MessageTxt).sendKeys(message);
        driver.findElement(SubmitButton).click();

    }

    //Method to fill the the form
    public boolean checkConfirmation(String message) {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(ConfirmationTxt));
        String confirmationMessage = driver.findElement(ConfirmationTxt).getText();
        if (confirmationMessage.contains(message)){
            return true;
        } else
            return false;
    }
}