import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ITBootcampLinkovi {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://itbootcamp.rs/");

        List<WebElement> allLinks = wd.findElements(By.tagName("a"));


        for(WebElement link:allLinks){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }

        wd.close();
    }
}
