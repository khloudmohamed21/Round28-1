package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task12Actions {
    private WebDriver driver;
    private String url = "https://duckduckgo.com/";

    public Task12Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void search(String query) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchbox_input']"));
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getFirstResultLink() {
        WebElement firstResult = driver.findElement(By.xpath("//div[contains(@class, 'mwuQiMOjmFJ5vmN6Vcqw')]//a[@href='https://www.selenium.dev/documentation/webdriver/']"));
        return firstResult.getAttribute("href");
    }
}
