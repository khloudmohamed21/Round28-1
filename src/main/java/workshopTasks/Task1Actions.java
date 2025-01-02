package workshopTasks;

import org.openqa.selenium.WebDriver;

public class Task1Actions {
    private WebDriver driver;
    private String url = "https://duckduckgo.com/"; // الرابط المعدل

    public Task1Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url); // فتح الرابط
    }

    public String getTitle() {
        return driver.getTitle(); // إرجاع عنوان الصفحة
    }
}
