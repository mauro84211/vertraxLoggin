package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    private WebDriver driver;
    /*private By reviewMenuButton = By.xpath("//span[@title='Review']");
    private By reviewButton = By.xpath("//ul[@id='tabReviewReconcile$Menu']//span[@title='Review']");*/
    private By DispatchButton = By.xpath("(//span[@title='Dispatch'])");
    private By BoardButom = By.xpath("//ul[@id='tabDispatch$Menu']/li/div/span[2]");
    private By RevieewNavButton = By.xpath("//div[@id='main-sidebar-global-menu']/div/div/div/ul/li[5]/div/div/span[2]");
    private By ReviewBotton = By.xpath("(//li[5]/ul/li/div/span[2])[1]");
    private By SetupNavButton = By.xpath("//div[@id='main-sidebar-global-menu']/div/div/div/ul/li[2]/div");
    private By SetupLocationsButton = By.xpath("(//li[2]/ul/li/div)[1]");
    private By SetupPickUpButton = By.xpath("(//ul[@id='tabSetupLocation$Menu']/li/div)[1]");
    private By LoadNavButton = By.xpath("//div[@id='main-sidebar-global-menu']/div/div/div/ul/li[3]/div");
    private By ManageLoadNButton = By.xpath("(//ul[@id='tabLoad$Menu']/li/div/div/span[2])[1]");
    private By CreateLoadNButton = By.xpath("(//ul[@id='tabLoadManageLoad$Menu']/li/div/span[2])[1]");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public org.openqa.selenium.By getSetupNavButton() {
        return SetupNavButton;
    }
    
    public void clickDispatchButton() {
        driver.findElement(DispatchButton).click();
    }
    
    /*public DispatchTabPage clickBoardButton() {
        driver.findElement(BoardButom).click();
        return new DispatchTabPage(driver);
    }*/
    
    public void clickReviewNavButton() {
        driver.findElement(RevieewNavButton).click();
    }
    
    /*public ReviewPage clickReviewButton() {
        driver.findElement(ReviewBotton).click();
        return new ReviewPage(driver);
    }*/
    
    public void clickSetupToLocations() {
        driver.findElement(SetupNavButton).click();
        try {
            Thread.sleep(2000);
            driver.findElement(SetupLocationsButton).click();
            Thread.sleep(2000);
            driver.findElement(SetupPickUpButton).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /*public CreateLoadsPage clickLoadToCreateLoads() {
        driver.findElement(LoadNavButton).click();
        try {
            Thread.sleep(2000);
            driver.findElement(ManageLoadNButton).click();
            Thread.sleep(2000);
            driver.findElement(CreateLoadNButton).click();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CreateLoadsPage(driver);
    }*/
    
    public void goForward() {
        driver.navigate().forward();
    }
    
    public String getURL() {
        return driver.getCurrentUrl();
    }
}