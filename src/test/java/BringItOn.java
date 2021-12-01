import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BringItOn {
    @Test
    public void pasteBringItOn() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");

        String titleText = "selenium selenium";
        WebElement newPaste = waitForElementLocatedBy(driver,By.xpath("//*[@id='postform-name']"));
        newPaste.sendKeys(titleText);

        String areaText = "git config --global user.name  \"New Sheriff in Town\"" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "git push origin master --force";
        WebElement postNewPaste = waitForElementLocatedBy(driver,By.xpath("//*[@id='postform-text']"));
        postNewPaste.sendKeys(areaText);

        WebElement postExpirationTimeList =
                waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-expiration-container']"));
        postExpirationTimeList.click();

        WebElement postExpirationTimeValue =
                waitForElementLocatedBy(driver,By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
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

        WebElement highlightingSynValue =
                waitForElementLocatedBy(driver,(By.xpath("//*[@class = 'left']/descendant::*[text()='Bash']")));
        String synValue = highlightingSynValue.getText();
        System.out.println("\\nHighlighting type is:\\n" + synValue);

        WebElement textAreaContainer =
                waitForElementLocatedBy(driver, (By.xpath("//*[@class = 'textarea']")));
        String textAreaResult = textAreaContainer.getAttribute("value");
        System.out.println("\\nText in text container is:\\n" + textAreaResult);

        String nameOfThePage = driver.getTitle();
        System.out.println("\\nTitle is:\\n" + nameOfThePage);

        Assert.assertTrue(synValue.contains(postHighlightingTypeName),"Type of highlighting is not correct!");
        Assert.assertTrue(nameOfThePage.contains(titleText),"Title of the page is not correct!");
        Assert.assertTrue(textAreaResult.contentEquals(areaText),"Text container contains wrong text!");

        driver.quit();
    }

  public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 25)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
