package automation.ui.shopping.tests;

import automation.ui.shopping.pages.AccountCreatedPage;
import automation.ui.shopping.pages.HomePage;
import automation.ui.shopping.pages.SignupLoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import java.time.Duration;

public class TestSignUp{
    public static WebDriver wd = new ChromeDriver();

    HomePage homePage = new HomePage(wd);
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage(wd);
    SignupLoginPage signupLoginPage = new SignupLoginPage(wd);

    @BeforeSuite
    public void configure (){
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        wd.get("https://www.automationexercise.com/");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wd.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        homePage.clickSignupLogin();
        signupLoginPage.fields("Pera Peric", "peraperic@smarac.com");
        signupLoginPage.title("mr");
        signupLoginPage.password("milos123");
        signupLoginPage.dateOfBirth(28,"August",1995);
        signupLoginPage.checkbox(0);
        signupLoginPage.firtName(String.valueOf(Faker.instance().funnyName()));
        signupLoginPage.lastName(String.valueOf(Faker.instance().funnyName()));
      //  signupLoginPage.company(null);
        signupLoginPage.address(String.valueOf(Faker.instance().address()));
      //  signupLoginPage.address2(null);
        signupLoginPage.country("Canada");
        signupLoginPage.state("Ontario");
        signupLoginPage.city("Toronto");
        signupLoginPage.zipcode(21010);
        signupLoginPage.mobileNumber(String.valueOf(Faker.instance().phoneNumber()));
        signupLoginPage.createAccount();
        Assert.assertEquals(accountCreatedPage.getText(), "ACCOUNT CREATED!");
    }



    @AfterSuite
    public void after (){
        wd.close();
    }
}
