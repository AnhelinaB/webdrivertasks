package page;

import test.WebDriverSeleniumHQTestHurtMePlenty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHQCalculatorPage {
    private WebDriver driver;
    WebDriverSeleniumHQTestHurtMePlenty waiter = new WebDriverSeleniumHQTestHurtMePlenty();

    public SeleniumHQCalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public SeleniumHQCalculatorPage setParams(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/descendant::iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='myFrame']")));

        WebElement numberOfInstances =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='input_66']"));
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");

        WebElement operatingSystemList =
                waiter.waitForElementLocatedBy(driver,
                        By.xpath("//*[@id='select_value_label_59']"));
        operatingSystemList.click();

        WebElement operatingSystemValue =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_68']"));
        operatingSystemValue.click();

        WebElement machineClassList =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_60']"));
        machineClassList.click();

        WebElement machineClassValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_80']"));
        machineClassValue.click();

        WebElement seriesList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_62']"));
        seriesList.click();

        WebElement seriesValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_195']"));
        seriesValue.click();

        WebElement machineTypeList =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_63']"));
        machineTypeList.click();

        WebElement machineTypeValue = waiter.waitForElementLocatedBy(driver, By.xpath("//*[@id='select_option_379']"));
        machineTypeValue.click();

        WebElement checkboxAddGPU =
                waiter.waitForElementLocatedBy(driver, By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']"));
        checkboxAddGPU.click();

        WebElement numberGPUList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_411']"));
        numberGPUList.click();

        WebElement numberGPUValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_418']"));
        numberGPUValue.click();

        WebElement typeGPUList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_412']"));
        typeGPUList.click();

        WebElement typeGPUValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_423']"));
        typeGPUValue.click();

        WebElement localSSDList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_373']"));
        localSSDList.click();

        WebElement localSSDValue = waiter.waitForElementLocatedBy(driver, By.xpath("//*[@id='select_option_400']"));
        localSSDValue.click();

        WebElement datacenterLocationList = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_value_label_64']"));
        datacenterLocationList.click();

        WebElement datacenterLocationValue = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_option_212']"));
        datacenterLocationValue.click();

        WebElement committedUsageList = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_value_label_65']"));
        committedUsageList.click();

        WebElement committedUsageValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_99']"));
        committedUsageValue.click();

        WebElement addToEstimateButton =
                waiter.waitForElementLocatedBy(driver,
                        By.xpath("//*[@id='mainForm']/descendant::button[contains(@ng-disabled,'computeServer')]"));
        addToEstimateButton.click();

        return new SeleniumHQCalculatorPage(driver);

    }
}
