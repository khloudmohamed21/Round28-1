package workshopTasks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4Test {
    private Task4Actions task4;

    @BeforeMethod
    public void setUp() {
        task4 = new Task4Actions();
        task4.openBrowser();
    }

    @Test
    public void verifyFourthSearchResult() throws InterruptedException {
        // Navigate to DuckDuckGo
        task4.navigateTo("https://duckduckgo.com/");

        // Search for "TestNG"
        task4.search("TestNG");

        // Get the text of the 4th search result
        String actualText = task4.getFourthResultText();

        // Expected text
        String expectedText = "TestNG Tutorial";

        // Assert the result
        Assert.assertEquals(actualText, expectedText, "The 4th search result text does not match!");
    }

    @AfterMethod
    public void tearDown() {
        task4.closeBrowser();
    }
}
