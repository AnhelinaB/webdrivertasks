import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ICanWin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com");

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement newPaste = driver.findElement(By.id("postform-text"));
        newPaste.sendKeys("selenium.java");

        WebElement postExpirationTimeList =
                waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-expiration-container']"));
        postExpirationTimeList.click();

        WebElement postExpirationTimeValue =
                waitForElementLocatedBy(driver,(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]")));
        postExpirationTimeValue.click();

        WebElement highlightingContainer =
                waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-format-container']"));
        highlightingContainer.click();

        WebElement postHighlightingType =
                driver.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]"));
        String postHighlightingTypeName = postHighlightingType.getText();
        postHighlightingType.click();

        WebElement createNewPaste =
                waitForElementLocatedBy(driver,By.xpath("//*[@class='btn -big']"));
        createNewPaste.click();
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
