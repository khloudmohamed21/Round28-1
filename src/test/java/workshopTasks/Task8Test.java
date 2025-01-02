package workshopTasks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task8Test {
    private Task8Actions task8;

    @BeforeMethod
    public void setUp() {
        task8 = new Task8Actions();
        task8.openBrowser();
    }

    @Test
    public void verifyFileUpload() {
        // Navigate to the URL
        task8.navigateTo("http://the-internet.herokuapp.com/upload");

        // File to upload (provide the correct file path)
        String filePath = "C:\\Users\\kholoud.mohamed\\Downloads\\pagination.png";
        String fileName = "pagination.png";
        // Upload the file
        task8.uploadFile(filePath);

        // Assert that the file was uploaded successfully
        Assert.assertTrue(task8.isFileUploaded(fileName), "The file was not uploaded successfully!");
    }

    @AfterMethod
    public void tearDown() {
        task8.closeBrowser();
    }
}
