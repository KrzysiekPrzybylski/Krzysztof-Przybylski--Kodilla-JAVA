package com.kodilla.testing2;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestingApp {
        public static final String EBAYFIELD = "_nkw";

        public static void main(String[] args) {
            WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
            driver.get("https://www.ebay.com");

            WebElement searchField = driver.findElement(By.name(EBAYFIELD));
            searchField.sendKeys("Laptop");
            searchField.submit();
    }
}
