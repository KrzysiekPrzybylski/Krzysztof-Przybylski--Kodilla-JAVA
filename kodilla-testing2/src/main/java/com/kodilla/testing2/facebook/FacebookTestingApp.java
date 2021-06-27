package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class FacebookTestingApp {

    public static final String COOKIE_FIELD = "//div[contains(@class, \"_9o-r\")]/button[2]";
    public static final String NEW_ACCOUNT_BUTTON = "//a [contains(@class, \"_42ft _4jy0 _6lti\")]";
    public static final String DAY_OF_BIRTH = "//select [contains(@name, \"birthday_day\")]";
    public static final String MONTH_OF_BIRTH = "// select [contains (@name, \"birthday_month\")]";
    public static final String YEAR_OF_BIRTH = "// select [contains (@name, \"birthday_year\")]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement searchFieldCookie = driver.findElement(By.xpath(COOKIE_FIELD));
        searchFieldCookie.click();

        Thread.sleep(3000);

        WebElement searchFieldAccount = driver.findElement(By.xpath(NEW_ACCOUNT_BUTTON));
        searchFieldAccount.click();

        Thread.sleep(2000);


        WebElement searchFieldDay = driver.findElement(By.xpath(DAY_OF_BIRTH));
        Select selectDay = new Select(searchFieldDay);
        selectDay.selectByValue("10");

        WebElement searchFieldMonth = driver.findElement(By.xpath(MONTH_OF_BIRTH));
        Select selectMonth = new Select(searchFieldMonth);
        selectMonth.selectByValue("7");

        WebElement searchFieldYear = driver.findElement(By.xpath(YEAR_OF_BIRTH));
        Select selectYear = new Select(searchFieldYear);
        selectYear.selectByValue("1990");
    }
}
