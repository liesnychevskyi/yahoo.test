package core.tests;

import core.data.YahooTestData;
import core.logger.MyLogger;
import core.managers.DriverManager;
import core.pages.YahooPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YahooTest
{
    protected WebDriver driver = null;
    protected DriverManager driverManager;

    @BeforeTest
    public void setUp()
    {
        driverManager = new DriverManager();
        driver = driverManager.chromeDriver();
        MyLogger.log.info("Browser is extending...");
        driver.manage().window().maximize();
        MyLogger.log.info("WebDriver goes to the address...");
        driver.get("https://yahoo.com");
    }

    @Test(description="This TC will perform Yahoo execution")
    public void boeingYahooTest() throws InterruptedException
    {
        MyLogger.log.info("Create instance from Yahoo page...");
        YahooPage yahooPage = new YahooPage(driver);
        MyLogger.log.info("Clicking on the link FINANCE...");
        yahooPage.clickFinanceLink();
        MyLogger.log.info("Checking we are on the wright page...");
        yahooPage.weOnTheYahooFinancePage(YahooTestData.originTitle);
        MyLogger.log.info("Typing some text...");
        yahooPage.typeInTheSearchBox(YahooTestData.searchText);
        MyLogger.log.info("Clicking on Boeing Company button...");
        yahooPage.clickOnBoeingCompany();
        MyLogger.log.info("Getting text from the Boeing page...");
        yahooPage.weOnTheBoeingCompanyPage(YahooTestData.boeingPageTitle);
        MyLogger.log.info("Clicking on the Historical Date...");
        yahooPage.clickOnHistoricalData();
    }

    @AfterTest
    public void tearDown()
    {
        driverManager.shutDown();
    }
}

//---------------------------------------------------------------|test case|
//        1. Navigate to https://www.yahoo.com/
//        2. Go to Finance page
//        3. Search for BA indice and select BA The Boeing Company in the dropdown list
//        4. On the The Boeing Company (BA) page select Historical Data
//        5. Verify for July 1st the following values are as expected:
//        Open | High | Low | Close | Volume
//        364.88 | 365.23 | 353.32 | 356.46 | 356.46 | 6,409,600
//----------------------------------------------------------------||
