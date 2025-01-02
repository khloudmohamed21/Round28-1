package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2Actions {
    private WebDriver driver;
    private String url = "https://duckduckgo.com/"; // URL to open

    // Constructor to initialize WebDriver
    public Task2Actions(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open the given URL
    public void open() {
        driver.get(url);
    }

    // Method to check if the DuckDuckGo logo is displayed on the page
    public boolean isLogoDisplayed() {
        // Locate the logo image element using a CSS selector
        WebElement logo = driver.findElement(By.xpath("//section[@class='header_headerLeft__gTUAg header_headerSection__C99zW']//img"));
        // Return whether the logo is displayed
        return logo.isDisplayed();
    }
}
