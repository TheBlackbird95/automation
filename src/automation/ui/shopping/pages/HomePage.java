package automation.ui.shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver webDriver;
    private String expectedText;
    private final String MODAL_HEADING_XPATH = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]";
    private final String HOME_BUTTON_XPATH = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]";
    private final String SIGNUP_LOGIN_XPATH = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]";
    private final String VIEW_CART_XPATH = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[2]/a[1]/u[1]";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public String getExpectedText() {
        return expectedText;
    }

    public void setExpectedText(String expectedText) {
        this.expectedText = expectedText;
    }

    public String getModalTitle() throws InterruptedException {
        WebElement popup = webDriver.findElement(By.xpath(MODAL_HEADING_XPATH));
        Thread.sleep(1000);
        return popup.getText();
    }

    public void clickOnHome() {
        WebElement home = webDriver.findElement(By.xpath(HOME_BUTTON_XPATH));
        home.click();
    }

    public WebElement getDress(int dressNumber) {
        if (dressNumber < 2 || dressNumber > 35){
            throw new IllegalArgumentException(String.format("The dress number %d is not available", dressNumber));
        }
        return webDriver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + dressNumber + "]/div[1]"));
    }
    public void scrollToDress (int dressNumber){
        WebElement majica = webDriver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + dressNumber + "]/div[1]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", majica);
    }

    public void hoverToDress(int dressNumber){
        Actions action = new Actions(webDriver);
        action.moveToElement(getDress(dressNumber)).perform();
    }

    public void clickToAddCartButton(int dressnumber) throws InterruptedException {
        setExpectedText(webDriver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + dressnumber + "]/div[1]/div[1]/div[1]/p[1]")).getText());
        WebElement addToCart = webDriver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + dressnumber + "]/div[1]/div[1]/div[2]/div[1]/a[1]"));
        Thread.sleep(1000);
        addToCart.click();
    }

    public void clickOnViewCardButton() {
        WebElement viewCart = webDriver.findElement(By.xpath(VIEW_CART_XPATH));
        viewCart.click();
    }

    public void clickSignupLogin (){
        WebElement signupLogin = webDriver.findElement(By.xpath(SIGNUP_LOGIN_XPATH));
        signupLogin.click();
    }

}
