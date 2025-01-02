package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task9Actions {
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

    // Perform drag and drop action
    public void dragAndDrop(String sourceLocator, String targetLocator) {
        WebElement source = driver.findElement(By.cssSelector(sourceLocator));
        WebElement target = driver.findElement(By.cssSelector(targetLocator));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform(); // Perform drag and drop
    }

    // Verify that the text of the target element has changed
    public boolean isDroppedTextCorrect(String targetLocator, String expectedText) {
        WebElement target = driver.findElement(By.cssSelector(targetLocator));
        return target.getText().equals(expectedText);
    }

    // Close the browser
    public void closeBrowser() {
       driver.quit();
   }
}
