import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Test\\Desktop\\Zadaci\\Java\\automation\\chromedriver.exe");

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/");
        wd.manage().window().maximize();
        Thread.sleep(5000); // pauziraj ovaj red za 5 sekundi
        String url = wd.getCurrentUrl();
        System.out.println("URL:" + url);
        String title = wd.getTitle();
        System.out.println("Title: " + title);
        wd.manage().window().maximize();

        wd.navigate().refresh();
        wd.get("https://google.com");
        wd.navigate().back();
        wd.navigate().forward();



        wd.close();
    }
}