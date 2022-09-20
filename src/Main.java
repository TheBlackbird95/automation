import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Test\\Desktop\\Zadaci\\Java\\automation\\chromedriver.exe");

        WebDriver wd = new ChromeDriver();

        wd.get("https://google.com/");
        Thread.sleep(1000);
        wd.close();
    }
}