package workshopTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Task12Test {

    private WebDriver driver;
    private Task12Actions task12Actions;

    @BeforeClass
    public void setUp() throws IOException {
        //  config.properties
        Properties properties = new Properties();
        String configFilePath = "src/test/resources/config.properties";
        FileInputStream configStream = new FileInputStream(configFilePath);
        properties.load(configStream);


        String targetBrowser = properties.getProperty("TargetBrowser");

        // ضبط WebDriver  على المتصفح المحدد
        switch (targetBrowser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + targetBrowser);
        }

        task12Actions = new Task12Actions(driver);
    }

    @Test
    public void testSearchResult() {
        task12Actions.open();

        task12Actions.search("Selenium WebDriver");

        String expectedLink = "https://www.selenium.dev/documentation/webdriver/";
        String actualLink = task12Actions.getFirstResultLink();
        Assert.assertEquals(actualLink, expectedLink, "The first result link is not as expected.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
