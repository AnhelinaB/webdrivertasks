package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.WebDriverSeleniumHQTestHurtMePlenty;

public class SeleniumHQSearchingPage {

    private WebDriver driver;
    WebDriverSeleniumHQTestHurtMePlenty waiter = new WebDriverSeleniumHQTestHurtMePlenty();

    public SeleniumHQSearchingPage(WebDriver driver, String linkText){
        this.driver = driver;
    }

    public SeleniumHQSearchingPage searchingLink(String linkText) {
        String linkXpath = "//div[@class='gs-title']/descendant::b[text()='" + linkText + "']";
        WebElement searchingLink =
                waiter.waitForElementLocatedBy (driver, By.xpath(linkXpath));
        searchingLink.click();
        return new SeleniumHQSearchingPage(driver, linkText);
    }
}
