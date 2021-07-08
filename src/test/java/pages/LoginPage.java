package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By companyField = By.id("company");
    private By loginButton = By.xpath("//button");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void setCompany(String password) {
        driver.findElement(companyField).sendKeys(password);
    }
    
    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
