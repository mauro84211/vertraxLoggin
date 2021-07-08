package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    private Set<String> handles;
    
    
    public void goStart(String dirEnvironment) {
        driver.get(dirEnvironment);
        wait = new WebDriverWait(driver, 150);
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @BeforeAll
    public void setUp(String dirEnvironment) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.logfile", "D:\\chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        // decTools = driver.
        goStart(dirEnvironment);
    }
    
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--enable-precise-memory-info");
        //options.setHeadless(true); /*Para que no se levante el navegador durante las pruebas*/
        return options;
    }
    
    @AfterAll
    public void tearDown() {
        System.out.println("Este es el @AfterAll");
        driver.quit();
    }
    
    private void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
    }
    
    public void switchToNewTab() {
        openNewTab();
        String subWindowHandler = null;
        handles = driver.getWindowHandles();
        for (String handle : handles) {
            subWindowHandler = handle;
        }
        driver.switchTo().window(subWindowHandler);
    }
    
    public void printMemory() {
        long value = (long) ((JavascriptExecutor) driver).executeScript("return window.performance.memory.usedJSHeapSize");
        long valueInMB = value / (1024 * 1024);
        System.out.println(valueInMB);
    }
}
