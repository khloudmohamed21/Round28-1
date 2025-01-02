package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task7Actions {
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

    // Get the Country for the specified Company
    public String getCountryForCompany(String companyName) {
        WebElement countryCell = driver.findElement(By.xpath("//table[@id='customers']//tr[td[text()='" + companyName + "']]/td[3]"));
        return countryCell.getText();
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
