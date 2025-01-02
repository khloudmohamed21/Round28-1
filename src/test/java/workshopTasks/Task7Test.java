package workshopTasks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task7Test {
    private Task7Actions task7;

    @BeforeMethod
    public void setUp() {
        task7 = new Task7Actions();
        task7.openBrowser();
    }

    @Test
    public void verifyCountryForCompany() {
        // Navigate to the URL
        task7.navigateTo("https://www.w3schools.com/html/html_tables.asp");

        // Get the Country for the Company "Ernst Handel"
        String actualCountry = task7.getCountryForCompany("Ernst Handel");
        String expectedCountry = "Austria";

        // Assert that the Country is as expected
        Assert.assertEquals(actualCountry, expectedCountry, "The country for 'Ernst Handel' is not correct!");
    }

    @AfterMethod
    public void tearDown() {
        task7.closeBrowser();
    }
}
