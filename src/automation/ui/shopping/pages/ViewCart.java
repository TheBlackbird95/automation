package automation.ui.shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ViewCart {

    private WebDriver webDriver;
    private final String FINAL_DRESS_NAME_CSS_SELECTOR = "div.container div.table-responsive.cart_info:nth-child(3) table.table.table-condensed:nth-child(1) tbody:nth-child(2) tr:nth-child(1) td.cart_description h4:nth-child(1) > a:nth-child(1)";

    public ViewCart(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public String getActual(){
        WebElement naziv = webDriver.findElement(By.cssSelector(FINAL_DRESS_NAME_CSS_SELECTOR));
        return naziv.getText();
    }
}
