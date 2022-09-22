import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImpliciteWaitSeleniumDemo {
    public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver",
                    PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

            WebDriver wd = new ChromeDriver();

            wd.get("https://demoqa.com/dynamic-properties");

            wd.manage().window().maximize();

        WebElement webElement = wd.findElement(By.id("colorChange"));
        webElement.click();

        WebElement visibleAfter = new WebDriverWait(wd, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
        System.out.println(visibleAfter.isDisplayed());

        wd.close();
    }
}
