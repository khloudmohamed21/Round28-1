package workshopTasks;

import org.testng.annotations.Test;

public class Task5Test {

    @Test
    public void verifySecondSearchResultLink() {
        Task5Actions task = new Task5Actions();

        // Open the browser
        task.openBrowser();

        // Navigate to DuckDuckGo
        task.navigateTo("https://duckduckgo.com/");

        // Perform the search for 'Cucumber IO'
        task.search("Cucumber IO");

        // Navigate to the second results page
        task.navigateToSecondPage();

        // Get the expected URL for the second result
        String expectedUrl = task.getExpectedUrl();

        // Wait for the page to load completely and compare the URLs
        task.assertSecondResultLink(expectedUrl);

        // Close the browser
        task.closeBrowser();
    }
}
