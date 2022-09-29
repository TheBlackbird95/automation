package automation.ui.shopping.tests;

import automation.ui.shopping.pages.HomePage;
import automation.ui.shopping.pages.SignupLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import javax.xml.crypto.Data;

public class TestLoginIncorrect {

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

    @DataProvider(name = "myDataProvider")
    public Object[][] createData1() {
        return new Object[][]{
                {"unused@mail.hehe", "petar321"},
                {"mail@mail.mail", "mail123"}
        };
    }

    @Test(dataProvider = "myDataProvider")
    public void verifyData1(String email, String password) {
        homePage.clickSignupLogin();
        signupLoginPage.loginEmail(email);
        signupLoginPage.loginPassword(password);
        signupLoginPage.clickLogIn();
        Assert.assertEquals(signupLoginPage.incorrectSignIn(), "Your email or password is incorrect!");
    }

    @AfterSuite
    public void after() {
        wd.close();
    }
}
