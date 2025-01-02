package workshopTasks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task9Test {
    private Task9Actions task9;

    @BeforeMethod
    public void setUp() {
        task9 = new Task9Actions();
        task9.openBrowser();
    }

    @Test
    public void verifyDragAndDrop() {
        // Navigate to the URL
        task9.navigateTo("https://jqueryui.com/resources/demos/droppable/default.html");

        // Locators for the draggable and droppable elements
        String draggableLocator = "#draggable";
        String droppableLocator = "#droppable";

        // Perform drag and drop
        task9.dragAndDrop(draggableLocator, droppableLocator);

        // Assert that the text has changed to "Dropped!"
        String expectedText = "Dropped!";
        Assert.assertTrue(task9.isDroppedTextCorrect(droppableLocator, expectedText),
                "The text did not change to 'Dropped!' after dropping.");
    }

   @AfterMethod
   public void tearDown() {
       task9.closeBrowser();
  }
}
