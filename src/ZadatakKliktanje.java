import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ZadatakKliktanje {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/buttons");

        Actions klik = new Actions(wd);

        WebElement dupliKlik = wd.findElement(By.id("doubleClickBtn"));
        klik.doubleClick(dupliKlik).perform();
        assert (wd.findElement(By.id("doubleClickMessage")).isDisplayed());
        System.out.println("Levi klik je OK");
        Thread.sleep(1000);

        WebElement desniKlik = wd.findElement(By.id("rightClickBtn"));
        klik.contextClick(desniKlik).perform();
        assert (wd.findElement(By.id("rightClickMessage")).isDisplayed());
        Thread.sleep(1000);

        WebElement leviKlik = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/button[1]"));
        klik.click(leviKlik).perform();
        Assert.assertTrue(wd.findElement(By.id("dynamicClickMessage")).isDisplayed(), "Levi klik je odradio!");
        Thread.sleep(1000);

        wd.close();
    }
}
