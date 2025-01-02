package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6Actions {
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

    // Check Checkbox 1
    public void checkCheckbox1() {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        if (!checkbox1.isSelected()) {
            checkbox1.click(); // Check Checkbox 1 if it's not already checked
        }
    }

    // Verify that both checkboxes are checked
    public boolean areBothCheckboxesChecked() {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        return checkbox1.isSelected() && checkbox2.isSelected(); // Check if both checkboxes are selected
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
