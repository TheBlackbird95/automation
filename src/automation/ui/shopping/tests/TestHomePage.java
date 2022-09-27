package automation.ui.shopping.tests;

import automation.ui.shopping.pages.ViewCartPage;
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
    ViewCartPage viewCartPage = new ViewCartPage(wd);

    @BeforeSuite
    public void configure (){
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        wd.get("https://www.automationexercise.com/");
    }

    @Test
    public void test1() throws InterruptedException {



        homePage.clickOnHome();

        homePage.scrollToDress(3);
        // Assert.assertThrows(() -> homePage.scrollToDress(100)); //unhappy path -test prolazi nesto sto nije moguce

        homePage.hoverToDress(3);

        homePage.clickToAddCartButton(3);

        Assert.assertEquals(homePage.getModalTitle(), "Added!", "Trebalo bi da je dodato u korpu!");
    }

    @Test
    public void test2() {

        homePage.clickOnViewCardButton();

        Assert.assertEquals(viewCartPage.getActual(), homePage.getExpectedText() , "Trebalo bi biti ono sto smo kliknuli!");

        wd.close();
    }
}
