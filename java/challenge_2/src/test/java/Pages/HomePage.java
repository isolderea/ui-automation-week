package Pages;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for Admin Panel footer
    By FooterAdmin = By.cssSelector("footer p a:nth-child(5)");

    //Locator for login button
    By LoginBtn = By.className("float-right");

    //Locator for username
    By  UsernameTxt = By.xpath("//div[@class=\"form-group\"][1]/input");
        //.sendKeys("admin");

    //Locator for password
    By  PasswordTxt = By.xpath("//div[@class=\"form-group\"][2]/input");
        //sendKeys("password");


    //Method to click login button
    public void clickLogin(String username, String password) {
        driver.findElement(FooterAdmin).click();
        driver.findElement(UsernameTxt).sendKeys(username);
        driver.findElement(PasswordTxt).sendKeys(password);
        driver.findElement(LoginBtn).click();
    }
}