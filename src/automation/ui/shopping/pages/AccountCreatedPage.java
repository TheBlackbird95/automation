package automation.ui.shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    private WebDriver webDriver;
    private String ACCOUNT_CREATED_CSS_SELECTOR = "div.container div.row div.col-sm-9.col-sm-offset-1 h2.title.text-center:nth-child(1) > b:nth-child(1)";

    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public String getText() {
        return webDriver.findElement(By.cssSelector(ACCOUNT_CREATED_CSS_SELECTOR)).getText();
    }
}
