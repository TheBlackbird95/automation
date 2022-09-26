import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesReader;

import java.util.List;

public class DemoDohvatiElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/text-box");

        WebElement element = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/label[1]"));

        System.out.println(element.getText());
        System.out.println(element.getAttribute("class"));
        System.out.println(element.getAttribute("id"));
        System.out.println(element.getAttribute("xpath"));
        System.out.println(element.getCssValue("color"));
        System.out.println(element.getTagName());
        System.out.println(element.getLocation());

        WebElement inputName = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]"));
        inputName.sendKeys("Marko");
        Thread.sleep(3000);

   //     WebElement submitButton = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[1]/button[1]"));
        WebElement submitButton = wd.findElement(By.id("submit"));

        List<WebElement> listaLabela = wd.findElements(By.tagName("label"));
//        for (WebElement webElement : listaLabela){
//            System.out.println(webElement.getText());
//        }

        submitButton.click();
        Thread.sleep(3000);

        wd.close();
    }
}
