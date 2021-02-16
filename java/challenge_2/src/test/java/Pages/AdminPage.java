package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;


public class AdminPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public AdminPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for Admin Panel footer
    By NavBar = By.className("navbar-collapse");

    //Locator for Room number
    By RoomNumber = By.cssSelector(".room-form > div:nth-child(1) input");

    //Locator for Room price
    By RoomPrice = By.cssSelector(".room-form > div:nth-child(4) input");

    //Locator for Create button
    By CreateButton = By.className("btn-outline-primary");

    //Locator for Room entries list
    By RoomList = By.cssSelector(".row.detail");


    //Method to get the Text
    public boolean checkText(String textTOCheck) throws InterruptedException {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(NavBar));
        WebElement navBar = driver.findElement(NavBar);
        System.out.println(navBar.getText());
        Boolean textpresent = navBar.getText().contains(textTOCheck);
        return textpresent;
    }

    //Method to add a Room
    public void createRoom(String rNumber, String rPrice) throws InterruptedException {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(CreateButton));
        WebElement navBar = driver.findElement(CreateButton);
        driver.findElement(RoomNumber).sendKeys(rNumber);
        driver.findElement(RoomPrice).sendKeys(rPrice);
        driver.findElement(CreateButton).click();
    }
    //Method to check if room was added
    public boolean checkCreation() {
        WebElement until = new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(RoomList));
        int rooms = RoomList.findElements(driver).size();
        if (rooms > 1) {
            return true;
        } else
            return false;
    }
}