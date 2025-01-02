package workshopTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task8Actions {
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

    // Upload a file
    public void uploadFile(String filePath) {
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(filePath); // Provide the file path to the input element

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click(); // Click the upload button
    }

    // Check if the file was uploaded successfully
    public boolean isFileUploaded(String fileName) {
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        return uploadedFile.getText().equals(fileName); // Verify the file name matches
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
