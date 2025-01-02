package workshopTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task2Test {

    private WebDriver driver;
    private Task2Actions task2Actions;

    // Setup method to initialize WebDriver before tests start
    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver for Chrome
        driver = new ChromeDriver();
        // Create an instance of Task2Actions class
        task2Actions = new Task2Actions(driver);
    }

    // Test method to check if the DuckDuckGo logo is displayed
    @Test
    public void testLogoDisplayed() {
        // Open the DuckDuckGo website
        task2Actions.open();

        // Assert that the logo is displayed on the page
        Assert.assertTrue(task2Actions.isLogoDisplayed(), "The DuckDuckGo logo is not displayed.");
    }

    // Tear down method to close the WebDriver after tests are completed
    @AfterClass
    public void tearDown() {
        // Close the browser after all tests are finished
        if (driver != null) {
            driver.quit();
        }
    }
}
