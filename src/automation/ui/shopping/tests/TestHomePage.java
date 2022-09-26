package automation.ui.shopping.tests;

import automation.ui.shopping.pages.ViewCart;
import utils.PropertiesReader;
import automation.ui.shopping.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestHomePage {
    public static WebDriver wd = new ChromeDriver();

    HomePage homePage = new HomePage(wd);
    ViewCart viewCart = new ViewCart(wd);

    @BeforeSuite
    public void configure (){
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
    }

    @Test
    public void test1() throws InterruptedException {

        wd.get("https://www.automationexercise.com/");

        homePage.clickOnHome();

        homePage.scrollToDress(1);

        homePage.hoverToDress(1);

        homePage.clickToAddCartButton();

        Assert.assertEquals(homePage.getModalTitle(), "Added!", "Trebalo bi da je dodato u korpu!");
    }

    @Test
    public void test2() {

        homePage.clickOnViewCardButton();

        Assert.assertEquals(viewCart.getActual(), "Blue Top", "Trebalo bi biti ono sto smo kliknuli!");

        wd.close();
    }
}
