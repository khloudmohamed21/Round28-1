package workshopTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task3Test {

    private WebDriver driver;
    private Task3Actions task3Actions;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        task3Actions = new Task3Actions(driver);
    }

    @Test
    public void testSearchResult() {
        task3Actions.open();

        task3Actions.search("Selenium WebDriver");

        String expectedLink = "https://www.selenium.dev/documentation/webdriver/";
        String actualLink = task3Actions.getFirstResultLink();
        Assert.assertEquals(actualLink, expectedLink, "The first result link is not as expected.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
