package workshopTasks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task6Test {
    private Task6Actions task6;

    @BeforeMethod
    public void setUp() {
        task6 = new Task6Actions();
        task6.openBrowser();
    }

    @Test
    public void verifyCheckboxesAreChecked() {
        // Navigate to the URL
        task6.navigateTo("http://the-internet.herokuapp.com/checkboxes");

        // Check Checkbox 1
        task6.checkCheckbox1();

        // Assert that both checkboxes are checked
        Assert.assertTrue(task6.areBothCheckboxesChecked(), "Both checkboxes are not checked!");
    }

    @AfterMethod
    public void tearDown() {
        task6.closeBrowser();
    }
}
