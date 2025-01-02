package workshopTasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Task11Tests {

    private WebDriver driver;
    private Task3Actions task3Actions;
    private Map<String, String> testData;

    @BeforeClass
    public void setUp() throws IOException {
        // Initialize WebDriver
        driver = new ChromeDriver();
        task3Actions = new Task3Actions(driver);

        // Read test data from JSON file
        String filePath = "src/test/resources/testData.json";
        ObjectMapper objectMapper = new ObjectMapper();
        testData = objectMapper.readValue(new File(filePath), Map.class);
    }

    @Test
    public void testSearchResult() {
        // Open the page
        task3Actions.open();

        // Perform search
        String query = testData.get("query");
        task3Actions.search(query);

        // Validate the first result link
        String expectedLink = testData.get("expectedLink");
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
