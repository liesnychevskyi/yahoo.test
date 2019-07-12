package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base
{
    private WebDriver driver;


    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void waitUntilDownloaded(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if(element != null)
        {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        else
        {
            System.out.println("Element is NULL##########################");
        }

    }





















}
// http://www.software-testing-tutorials-automation.com/2014/02/selenium-webdriver-how-to-wait-till.html
// good for webdriver //
// http://learn-automation.com/base-class-in-selenium-webdriver/ Mukesh blog