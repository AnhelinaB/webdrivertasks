package page;

import test.WebDriverSeleniumHQTestHurtMePlenty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHQCalculatorResultsPage {
    private WebDriver driver;
    WebDriverSeleniumHQTestHurtMePlenty waiter = new WebDriverSeleniumHQTestHurtMePlenty();

    public SeleniumHQCalculatorResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getResultEstimatedCost(){
        WebElement estimateContainerEstimatedCostValue =
                waiter.waitForElementLocatedBy(driver, By.xpath("//*[contains(text(),'Estimated Component Cost')]"));
        String result = estimateContainerEstimatedCostValue.getText();
        return result;
    }
    public String getResultCommitmentTerm(){
        WebElement estimateContainerCommitmentTermValue =
                waiter.waitForElementLocatedBy(driver, By.xpath("//div[contains(text(),'Commitment term')]"));
        String result = estimateContainerCommitmentTermValue.getText();
        return result;
    }
    public String getResultSSDSpace(){
        WebElement estimateContainerSSDValue =
                waiter.waitForElementLocatedBy(driver, By.xpath("//div[contains(text(),'SSD space')]"));
        String result = estimateContainerSSDValue.getText();
        return result;
    }
    public String getResultRegion(){
        WebElement estimateContainerRegionValue =
                waiter.waitForElementLocatedBy(driver, By.xpath("//div[contains(text(),'Region')]"));
        String result = estimateContainerRegionValue.getText();
        return result;
    }
    public String getResultInstanceType(){
        WebElement estimateContainerInstanceTypeValue =
                waiter.waitForElementLocatedBy(driver, By.xpath("//div[contains(text(),'Instance type')]"));
        String result = estimateContainerInstanceTypeValue.getText();
        return result;
    }
    public String getResultVMClass(){
        WebElement estimateContainerVMClassValue =
                waiter.waitForElementLocatedBy(driver, By.xpath("//div[contains(text(),'VM class')]"));
        String result = estimateContainerVMClassValue.getText();
        return result;
    }
}
