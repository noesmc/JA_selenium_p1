import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class SeleniumTest {
    @Test
    public static void firstSeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        List<WebElement> links = driver.findElements(By.xpath("//li//a"));
        links.get(9).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/drag_and_drop",
            "The \"Drag and drop\" page isn't open");
        driver.quit();
    }

    @Test(dependsOnMethods = "firstSeleniumTest")
    public static void dependsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        List<WebElement> links = driver.findElements(By.xpath("//li//a"));
        links.get(9).click();
        WebElement boxA = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement boxB = driver.findElement(By.xpath("//div[@id='column-b']"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(boxA, boxB).perform();
        Assert.assertEquals(boxB.getText(), "A", "The boxes haven't changed their position");
        driver.quit();
    }
}
