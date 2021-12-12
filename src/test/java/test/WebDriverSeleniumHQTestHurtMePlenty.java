package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SeleniumHQCalculatorPage;
import page.SeleniumHQCalculatorResultsPage;
import page.SeleniumHQHomePage;
import page.SeleniumHQSearchingPage;

public class WebDriverSeleniumHQTestHurtMePlenty {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Test for task 'Hurt Me Plenty'")
    public void pricingCalculator(){

        String searchingValue = "Google Cloud Platform Pricing Calculator";
        new SeleniumHQHomePage(driver, searchingValue)
                .openPage()
                .searchForTerms(searchingValue);

        new SeleniumHQSearchingPage(driver, searchingValue)
                .searchingLink(searchingValue);

        new SeleniumHQCalculatorPage(driver)
                .setParams();
        SeleniumHQCalculatorResultsPage calculation = new SeleniumHQCalculatorResultsPage(driver);

        String commitmentTerm = calculation.getResultCommitmentTerm();
        String estimatedCost = calculation.getResultEstimatedCost();
        String instanceType = calculation.getResultInstanceType();
        String region = calculation.getResultRegion();
        String spaceSSD = calculation.getResultSSDSpace();
        String classVMC = calculation.getResultVMClass();

        Assert.assertTrue(commitmentTerm.contains("1 Year"), "Calculated commitment term is not correct!");
        Assert.assertTrue(estimatedCost.contains("USD 1,082.77"),"Estimated cost is not correct!");
        Assert.assertTrue(instanceType.contains("n1-standard-8"),"Instance type is not correct!");
        Assert.assertTrue(region.contains("Frankfurt"),"Region is not correct!");
        Assert.assertTrue(spaceSSD.contains("2x375 GiB"),"Total available local SSD space is not correct!");
        Assert.assertTrue(classVMC.contains("regular"),"VM class is not correct!");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(by));
    }


}
