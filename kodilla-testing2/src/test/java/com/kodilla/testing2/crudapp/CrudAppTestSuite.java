package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "http://localhost:8888/tasks_frontend";
    private WebDriver driver;
    private Random generator;
    private int random;

    @BeforeEach
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    public String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";

        String taskName = "Task number" + generator.nextInt(10000);            // [1]
        String taskContent = taskName + " content";                              // [2]

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);                                                 // [3]

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);                                           // [4]

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));   // [5]
        addButton.click();                                                       // [6]
        Thread.sleep(2000);
        return taskName;
    }


    private void sendTestTaskInTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(3000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
            final String TRELLO_URL = "https://trello.com/login";
            boolean result = false;
            WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);	// [1]
            driverTrello.get(TRELLO_URL);                                                // [2]

            driverTrello.findElement(By.id("user")).sendKeys("krzy.przybylski@gmail.com");		        // [3]
            driverTrello.findElement(By.id("password")).sendKeys("Fiesta_11");		    // [4]
            WebElement el = driverTrello.findElement(By.id("login"));
            el.submit();									                                // [5]

            Thread.sleep(4000);								                            // [6]

            driverTrello.findElement(By.id("password")).sendKeys("Fiesta_11");		    // [7]
            driverTrello.findElement(By.id("login-submit")).submit();

            Thread.sleep(4000);								                            // [8]

            driverTrello.findElements(By.xpath("//a[@class=\"board-title\"]")).stream()  // [9]
                    .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)  // [10]
                    .forEach(WebElement::click);						                        // [11]

            Thread.sleep(4000);								                            // [12]

            result = driverTrello.findElements(By.xpath("//span")).stream()		        // [13]
                    .anyMatch(theSpan -> theSpan.getText().equals(taskName));    		        // [14]

            driverTrello.close();							                            // [15]

            return result;								                                // [16]
        }

    private boolean checkTaskHasBeenDeleted(String taskName) throws InterruptedException {
        boolean isDeleted = false;
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);

        while (!webDriver.findElement(By.xpath("//form[@class=\"datatable__row\"]")).isDisplayed()) ;

        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(webElement -> webElement.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(webElement -> webElement.
                        findElement(By.xpath(".//div[contains(@class, \"section-wrapper\")]/" +
                                "fieldset[contains(@class, \"button-section\")]/button[@data-task-delete-button]"))
                        .click());
        Thread.sleep(2000);

        if (webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .noneMatch(webElement ->
                        webElement.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))) {
            isDeleted = true;
        }
        webDriver.close();
        return isDeleted;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskInTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        assertTrue(checkTaskHasBeenDeleted(taskName));

    }
}
