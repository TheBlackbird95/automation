import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

import javax.swing.text.Position;

public class DragDrop {
    public static WebDriver  wd = new ChromeDriver();
    @BeforeSuite
    public void configure (){
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
    }

    public static void main(String[] args) throws InterruptedException {

        wd.get("https://demoqa.com/droppable");

        //prvi
        WebElement draggable = wd.findElement(By.id("draggable"));
        WebElement droppable = wd.findElement(By.id("droppable"));
        dragDrop(draggable,droppable);

        //drugi
        WebElement accept = wd.findElement(By.id("droppableExample-tab-accept"));
        accept.click();
        WebElement notAcceptable = wd.findElement(By.id("notAcceptable"));
        WebElement drop = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]"));
        dragDrop(notAcceptable,drop);
        assert (wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/p[1]")).getText().equalsIgnoreCase("Drop here"));
        WebElement acceptable = wd.findElement(By.id("acceptable"));
        dragDrop(acceptable,drop);
        assert (wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/p[1]")).getText().equalsIgnoreCase("Dropped!"));

        //treci
        WebElement prevent = wd.findElement(By.id("droppableExample-tab-preventPropogation"));
        prevent.click();
        WebElement drag = wd.findElement(By.id("dragBox"));
        WebElement drop1 = wd.findElement(By.id("notGreedyInnerDropBox"));
        dragDrop(drag,drop1);
        assert (wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/p[1]")).getText().equalsIgnoreCase("Dropped!"));
        WebElement drop2 = wd.findElement(By.id("greedyDropBoxInner"));
        assert (wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/p[1]")).getText().equalsIgnoreCase("Outer droppable"));

        //cetvrti
        WebElement revert = wd.findElement(By.id("droppableExample-tab-revertable"));
        revert.click();
        WebElement revertable = wd.findElement(By.id("revertable"));
        Point prvaR = revertable.getLocation();
        WebElement dropbox = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[4]/div[1]/div[2]"));
        dragDrop(revertable,dropbox);
        Thread.sleep(2000);
        Point drugaR = revertable.getLocation();
        assert (prvaR.equals(drugaR));
        WebElement notRevertable = wd.findElement(By.id("notRevertable"));
        Point prvaNR = notRevertable.getLocation();
        dragDrop(notRevertable,dropbox);
        Point drugaNR = notRevertable.getLocation();
        assert (!prvaNR.equals(drugaNR));

        wd.close();
    }
    private static void dragDrop (WebElement draggable, WebElement droppable){
        Actions actions = new Actions(wd);
        actions.dragAndDrop(draggable, droppable).perform();
    }
}
