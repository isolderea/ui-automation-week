package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrandingPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public BrandingPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for Form Control
    By FormControl = By.className("form-control");

    //Locator for Save button
    By SubmitButton = By.className("btn-outline-primary");

    //Locator for Close dialog
    By CloseButton =By.xpath("//button[text()=\"Close\"]");



    //Method to click login button
    public void enterFormValue(String formvalue) {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(SubmitButton));
        driver.findElement(FormControl).click();
        driver.findElement(FormControl).sendKeys(formvalue);
        driver.findElement(SubmitButton).click();
    }

    //Method to check if there is a dialog with a Close button
    public boolean checkCreation() {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(CloseButton));
        int buttonCount = CloseButton.findElements(driver).size();
        if (buttonCount== 1) {
            return true;
        } else
            return false;
    }
}