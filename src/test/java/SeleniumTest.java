import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTest {
    @Test
    public static void firstSeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.xpath("//li//a"));
        links.get(9).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/drag_and_drop",
            "The \"Drag and drop\" page isn't open");
        driver.quit();
    }
}
