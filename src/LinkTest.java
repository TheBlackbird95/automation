import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LinkTest {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/links");

        WebElement homeLink = wd.findElement(By.id("simpleLink"));
        System.out.println(homeLink.getAttribute("href"));
        String homeLinkUrl = homeLink.getAttribute("href");

        HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(homeLinkUrl)).openConnection();

        httpURLConnection.setRequestMethod("GET");

        httpURLConnection.connect();

        System.out.println(httpURLConnection.getResponseCode());

        wd.close();
    }
}
