package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.WebDriverSeleniumHQTestHurtMePlenty;

public class SeleniumHQHomePage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    public SeleniumHQHomePage(WebDriver driver, String searchingValue){
        this.driver = driver;
    }

    public SeleniumHQHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SeleniumHQHomePage searchForTerms(String searchingValue){
        WebDriverSeleniumHQTestHurtMePlenty waiter = new WebDriverSeleniumHQTestHurtMePlenty();
        WebElement searchingButton =
                waiter.waitForElementLocatedBy(driver, By.xpath("//input[@aria-autocomplete='list']"));
        searchingButton.click();

        WebElement searchField =
                driver.findElement(By.xpath("//input[@class='devsite-search-field devsite-search-query']"));
        Actions action = new Actions(driver);
        action.moveToElement(searchField,500,10);
        searchField.sendKeys(searchingValue);
        searchField.sendKeys(Keys.ENTER);
        return new SeleniumHQHomePage(driver, searchingValue);
    }


}
