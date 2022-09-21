import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D_19_Milos_Kos {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Test\\Desktop\\Zadaci\\Java\\automation\\chromedriver.exe");

        WebDriver wd = new ChromeDriver();

        wd.get("https://demoqa.com/text-box");

        WebElement inputName = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]"));
        inputName.sendKeys("TheBlackbird");

        WebElement email = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[2]/input[1]"));
        email.sendKeys("crnaptica@digi.rs");

        WebElement current = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[3]/div[2]/textarea[1]"));
        current.sendKeys("gnezdo na malom drvetu");

        WebElement permament = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[2]/textarea[1]"));
        permament.sendKeys("rupa u drvetu");

        WebElement submitButton = wd.findElement(By.id("submit"));
        submitButton.click();

        WebElement prosao = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[1]"));
        assert prosao.isDisplayed();
        System.out.println("Test prosao");

        Thread.sleep(3000);
        wd.close();
    }
}
