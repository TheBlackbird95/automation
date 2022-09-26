import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.time.Duration;

public class Alerts {

    private static void waitIclick (WebElement webElement) throws InterruptedException {
        webElement.click();
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/alerts");

        //prvo
        WebElement alertButton = wd.findElement(By.id("alertButton"));
        waitIclick(alertButton);
        wd.switchTo().alert().accept();

        //drugo
        WebElement timerAlertButton = wd.findElement(By.id("timerAlertButton"));
        waitIclick(timerAlertButton);

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();

        //trece
        WebElement confirmButton = wd.findElement(By.id("confirmButton"));
        waitIclick(confirmButton);
        wd.switchTo().alert().accept();
        assert (wd.findElement(By.id("confirmResult")).getText().equalsIgnoreCase("You selected Ok"));
        waitIclick(confirmButton);
        wd.switchTo().alert().dismiss();
        assert (wd.findElement(By.id("confirmResult")).getText().equalsIgnoreCase("You selected cancel"));

        //cetvrto
        WebElement promtButton = wd.findElement(By.id("promtButton"));
        waitIclick(promtButton);
        wd.switchTo().alert().sendKeys("Text");
        wd.switchTo().alert().accept();
        Thread.sleep(1000);
        assert (wd.findElement(By.id("promptResult")).getText().contains("Text"));

        wd.quit();

    }
}
