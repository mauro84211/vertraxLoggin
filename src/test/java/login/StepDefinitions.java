package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LoginPage;


public class StepDefinitions extends base.BaseTest {
    
    private LoginPage loginPage;
    private HomePage homePage;
    private String nowURL;
    
    @Given("The login Page of the Vertrax System us open un the {string}")
    public void the_login_page_of_the_vertrax_system_us_open_un_the(String environment) {
        setUp(environment);
    }
    
    @When("I write {string} {string} and {string}")
    public void i_write_and(String username, String password, String company) {
        loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.setCompany(company);
        homePage = loginPage.clickLoginButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getSetupNavButton()));
        nowURL = homePage.getURL();
        
    }
    
    @Then("The should open in the Dashboard Page")
    public void theShouldOpenInTheDashboardPage() {
        org.junit.Assert.assertEquals("https://welltrax-alpha.vertrax.com/dashboard", nowURL);
    }
}
