package automation.ui.shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupLoginPage {
    private WebDriver webDriver;
    private String NAME_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]";
    private String EMAIL_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]";
    private String SIGNUP_BUTTON_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/form[1]/button[1]";
    private String PASSWORD_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/input[1]";
    private String DAY_OF_BIRTH_CSS_SELECTOR = "days";
    private String MONTH_OF_BIRTH_CSS_SELECTOR = "months";
    private String YEAR_OF_BIRTH_CSS_SELECTOR = "years";
    private String NEWSLETTER_CSS_SELECTOR = "newsletter";
    private String SPECIAL_OFFERS_CSS_SELECTOR = "optin";
    private String FIRST_NAME_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/input[1]";
    private String LAST_NAME_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[2]/input[1]";
    private String COMPANY_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[3]/input[1]";
    private String ADDRESS_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[4]/input[1]";
    private String ADDRESS2_LABEL_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[5]/input[1]";
    private String COUNTY_DROPBOX_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[6]/select[1]";
    private String STATE_CSS_SELECTOR = "state";
    private String CITY_CSS_SELECTOR = "city";
    private String ZIPCOTE_CSS_SELECTOR = "zipcode";
    private String MOBILE_NUMBER_CSS_SELECTOR = "mobile_number";
    private String CREATE_ACCOUNT_BUTTON_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]";
    private String EMAIL_LOGIN_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]";
    private String PASSWORD_LOGIN_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]";
    private String WRONG_EMAIL_OR_PASSWORD_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]";
    private String LOGIN_BUTTON_XPATH = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]";

    public SignupLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public void fields(String ime, String email){
        webDriver.findElement(By.xpath(NAME_LABEL_XPATH)).sendKeys(ime);
        webDriver.findElement(By.xpath(EMAIL_LABEL_XPATH)).sendKeys(email);
        webDriver.findElement(By.xpath(SIGNUP_BUTTON_XPATH)).click();
    }

    public void title(String titulaBezTacke){
        if (titulaBezTacke.equalsIgnoreCase("mr")){
            webDriver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/label[1]")).click();
        } else if (titulaBezTacke.equalsIgnoreCase("mrs")){
            webDriver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/label[1]")).click();
        } else {
            throw new IllegalArgumentException("Unkown title!");
        }
    }

    public void password(String password){
        webDriver.findElement(By.xpath(PASSWORD_LABEL_XPATH)).sendKeys(password);
    }

    public void dateOfBirth(int day, String month, int year){
        new Select (webDriver.findElement(By.id(DAY_OF_BIRTH_CSS_SELECTOR))).selectByValue(String.valueOf(day));
        new Select (webDriver.findElement(By.id(MONTH_OF_BIRTH_CSS_SELECTOR))).selectByVisibleText(month);
        new Select (webDriver.findElement(By.id(YEAR_OF_BIRTH_CSS_SELECTOR))).selectByValue(String.valueOf(year));
    }

    public void checkbox(int broj){
        switch (broj){
            case 0:
                webDriver.findElement(By.id(NEWSLETTER_CSS_SELECTOR)).click();
                break;
            case 1:
                webDriver.findElement(By.id(SPECIAL_OFFERS_CSS_SELECTOR)).click();
                break;
            case 3:
                webDriver.findElement(By.id(NEWSLETTER_CSS_SELECTOR)).click();
                webDriver.findElement(By.id(SPECIAL_OFFERS_CSS_SELECTOR)).click();
                break;
            default:
                break;
        }
    }

    public void firtName(String ime){
        webDriver.findElement(By.xpath(FIRST_NAME_LABEL_XPATH)).sendKeys(ime);
    }

    public void lastName(String prezime){
        webDriver.findElement(By.xpath(LAST_NAME_LABEL_XPATH)).sendKeys(prezime);
    }

    public void company(String company){
        webDriver.findElement(By.xpath(COMPANY_LABEL_XPATH)).sendKeys(company);
    }

    public void address(String adresa){
        webDriver.findElement(By.xpath(ADDRESS_LABEL_XPATH)).sendKeys(adresa);
    }

    public void address2(String adresa){
        webDriver.findElement(By.xpath(ADDRESS2_LABEL_XPATH)).sendKeys(adresa);
    }

    public void country(String country){
        new Select (webDriver.findElement(By.xpath(COUNTY_DROPBOX_XPATH))).selectByVisibleText(country);
    }

    public void state(String state){
        webDriver.findElement(By.id(STATE_CSS_SELECTOR)).sendKeys(state);
    }

    public void city(String city){
        webDriver.findElement(By.id(CITY_CSS_SELECTOR)).sendKeys(city);
    }

    public void zipcode(int zipcode){
        webDriver.findElement(By.id(ZIPCOTE_CSS_SELECTOR)).sendKeys(String.valueOf(zipcode));
    }

    public void mobileNumber(String mobile){
        webDriver.findElement(By.id(MOBILE_NUMBER_CSS_SELECTOR)).sendKeys(mobile);
    }

    public void createAccount() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON_XPATH)));
        webDriver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON_XPATH)).click();
    }

    public void loginEmail(String email){
        webDriver.findElement(By.xpath(EMAIL_LOGIN_XPATH)).sendKeys(email);
    }

    public void loginPassword(String password){
        webDriver.findElement(By.xpath(PASSWORD_LOGIN_XPATH)).sendKeys(password);
    }

    public void clickLogIn(){
        webDriver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }

    public String incorrectSignIn(){
        return webDriver.findElement(By.xpath(WRONG_EMAIL_OR_PASSWORD_XPATH)).getText();
    }
}
