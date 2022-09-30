package automation.ui.shopping.tests;

import automation.ui.shopping.pages.HomePage;
import automation.ui.shopping.pages.SignupLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.PropertiesReader;

public class D_21_logout {
    public static WebDriver wd = new ChromeDriver();
    HomePage homePage = new HomePage(wd);
    SignupLoginPage signupLoginPage = new SignupLoginPage(wd);

    @BeforeSuite
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        wd.get("https://www.automationexercise.com/");
        wd.manage().window().maximize();
    }

    @Test
    public void logut(){
        homePage.clickSignupLogin();
        signupLoginPage.loginEmail("peraperic@petlic.com");
        signupLoginPage.loginPassword("milos123");
        signupLoginPage.clickLogIn();
        homePage.signOut();
        assert homePage.getSignUpLogin().isDisplayed();
    }

    @AfterSuite
    public void after() {
        wd.close();
    }
}
