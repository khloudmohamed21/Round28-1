package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Task4Actions {
    private WebDriver driver;

    // Open Mozilla Firefox browser
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    // Navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Search for a query in DuckDuckGo
    public void search(String query) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchbox_input']")); // Find the search input
        searchBox.sendKeys(query); // Enter the query

        // Wait for the suggestions list to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.searchbox_suggestionList__QYLSF")));
    }

    // Get the text of the fourth search result
    public String getFourthResultText() {
        WebElement fourthResult = driver.findElement(By.cssSelector("ul.searchbox_suggestionList__QYLSF li:nth-child(4)")); // Locate the 4th result
        return fourthResult.getText(); // Return the text of the 4th result
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
