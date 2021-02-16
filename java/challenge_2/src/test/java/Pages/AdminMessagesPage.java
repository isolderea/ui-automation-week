package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminMessagesPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public AdminMessagesPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for Admin Messages
    By MessageList = By.cssSelector(".read-false");


    //Method to check that there are more than I messages
    public boolean checkMessageList(int number) {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(MessageList));
        int rooms = MessageList.findElements(driver).size();
        if (rooms >= number) {
            return true;
        } else
            return false;
    }
}