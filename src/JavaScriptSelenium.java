import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/text-box");

        Dimension dimension = new Dimension(1000,500);
        wd.manage().window().setSize(dimension);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) wd;

        WebElement textArea = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[2]/textarea[1]"));
//        textArea.sendKeys("Zdravo");

//        javascriptExecutor.executeScript("console.log('zdravo')");
//        Thread.sleep(1000);
//        javascriptExecutor.executeScript("scroll(0,500);");
//
        WebElement element = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(2000);

//        Actions action = new Actions(wd);
//        action.moveToElement(textArea);
//        action.perform();
//        Thread.sleep(2000);
    }
}