package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YahooPage extends Base
{
//--------------------------------------------------------------//WebDriver
    WebDriver driver;
    WebDriverWait wait;
//--------------------------------------------------------------//Locators
    By finance_link_search_box = By.xpath("//input[@aria-label='Search']");
    By finance_link = By.xpath("//a[@href='https://finance.yahoo.com/']");
    By boeing_company_from_drop_down_list = By.xpath("//div[@title='The Boeing Company']");
    By yahoo_finance_title = By.xpath("//a[@href='https://finance.yahoo.com/' and @data-reactid='34']");
    By theBoeingCompanyBA = By.xpath("//h1[contains(text(),'The Boeing Company (BA)')]");
    By historicalDate = By.xpath("//a[@href='/quote/BA/history?p=BA']");

//--------------------------------------------------------------//Constructor
    public YahooPage(WebDriver driver)
    {
        this.driver = driver;
    }
//---------------------------------------------------------------//Functions

    public void clickFinanceLink()
    {
        driver.findElement(finance_link).click();
    }

    public void typeInTheSearchBox(String text)
    {
        driver.findElement(finance_link_search_box).sendKeys(text);
    }

    public void weOnTheYahooFinancePage(String expected_title)
    {
        String title = driver.getTitle();
        System.out.println(title);
        boolean res = title.equalsIgnoreCase(expected_title);
        if(res == true)
            System.out.println("We are on the YAHOO FINANCE page");
        else
            System.out.println("Error we are not on the wright page");
    }

    public void weOnTheBoeingCompanyPage(String expected_title)
    {
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(theBoeingCompanyBA));
        String title = driver.findElement(theBoeingCompanyBA).getText();
        System.out.println(title);
        boolean res = title.equalsIgnoreCase(expected_title);
        if(res == true)
            System.out.println("We are on the YAHOO FINANCE page");
        else
            System.out.println("Error we are not on the wright page");
    }

    public void clickOnBoeingCompany() throws InterruptedException
    {
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(boeing_company_from_drop_down_list));
        driver.findElement(boeing_company_from_drop_down_list).click();
    }

    public void clickOnHistoricalData() throws InterruptedException
    {
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(historicalDate));
        boolean res = driver.findElement(historicalDate).isDisplayed();
        if(res == true)
        {
            driver.findElement(historicalDate).click();
        }
        else
        {
            System.out.println("********Error element is not present*********");
        }

    }
}
