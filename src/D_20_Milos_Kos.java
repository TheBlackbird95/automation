import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesReader;

public class D_20_Milos_Kos {

    public static WebDriver wd = new ChromeDriver();

    @BeforeSuite
    public void configure (){
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
    }

    public static void main(String[] args) throws InterruptedException {
        String ime = "Pera";
        String prezime = "Peric";
        String mail = "peraperic@petlic.com";
        String broj = "0634592136";
        String naslov = "English";
        String adresa = "Pere Perica 2";
        String drzava = "NCR";
        String grad = "Delhi";

        wd.get("https://demoqa.com/automation-practice-form");

        WebElement footer = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]"));
        WebElement reklama = wd.findElement(By.id("adplus-anchor"));
        WebElement smetalo = wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]"));

        WebElement firstName = wd.findElement(By.id("firstName"));
        firstName.sendKeys(ime);
        WebElement lastName = wd.findElement(By.id("lastName"));
        lastName.sendKeys(prezime);
        WebElement email = wd.findElement(By.id("userEmail"));
        email.sendKeys(mail);
        WebElement gender = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[3]/div[2]/div[1]"));
        gender.click();
        WebElement mobile = wd.findElement(By.id("userNumber"));
        mobile.sendKeys(broj);

        //brisanje elemenata je ovde jer se reklama nekad ne ocita odma pa zablokira program, a prvi problem zbog reklame moze da nastane tek kod biranja dana
        if (reklama.isDisplayed()){
            ((JavascriptExecutor) wd).executeScript("return arguments[0].remove();", reklama);
        }
        ((JavascriptExecutor) wd).executeScript("return arguments[0].remove();", footer);
        ((JavascriptExecutor) wd).executeScript("return arguments[0].remove();", smetalo);

        WebElement dateOfBirth = wd.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();
        new Select (wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]"))).selectByVisibleText("August");
        new Select (wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]"))).selectByVisibleText("1995");
        WebElement day = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[2]"));
        day.click();
        WebElement subjects = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
        subjects.sendKeys(naslov);
        subjects.sendKeys(Keys.ENTER);
        WebElement sports = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[7]/div[2]/div[1]"));
        sports.click();
        WebElement music = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[7]/div[2]/div[3]"));
        music.click();
        WebElement address = wd.findElement(By.id("currentAddress"));
        address.sendKeys(adresa);
        WebElement state = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", state);
        state.sendKeys(drzava);
        state.sendKeys(Keys.ENTER);
        WebElement city = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[10]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
        city.sendKeys(grad);
        city.sendKeys(Keys.ENTER);
        WebElement submit = wd.findElement(By.id("submit"));
        submit.click();

    }
}
