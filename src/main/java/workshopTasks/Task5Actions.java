package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Task5Actions {
    private WebDriver driver;

    // Open Google Chrome browser
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Search for a query in DuckDuckGo
    public void search(String query) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchbox_input']"));
        searchBox.sendKeys(query);
    }

    // Navigate to the second page of results
    public void navigateToSecondPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondPageLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@role='option' and @aria-selected='false' and contains(@class, 'searchbox_suggestion__csrUQ') and contains(., 'cucumber io parallel execut')]")));
        secondPageLink.click();
    }

    // Get the URL of the second result and store it as expected
    public String getExpectedUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'linkedin')]")));
        return secondResult.getAttribute("href");
    }

    // Assert that the current URL contains the specified expected link after navigating to the second result
    public void assertSecondResultLink(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(expectedUrl)); // Wait for URL to contain the expected link

        // Get the actual current URL
        String actualUrl = driver.getCurrentUrl();

        // Assert that the current URL matches the expected URL
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Assertion Passed: The current URL matches the expected URL.");
        } else {
            System.out.println("Assertion Failed: The current URL does not match the expected URL.");
        }
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
