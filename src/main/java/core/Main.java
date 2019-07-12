package core;

import core.managers.DriverManager;
import core.pages.YahooPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Main
{
//===============================================================================//
   protected WebDriver driver = null;
   protected DriverManager driverManager = new DriverManager();
//================================================================================//
    @Test
    public void test_1() throws InterruptedException
    {
        driver = driverManager.chromeDriver();
        driver.get("https://yahoo.com");
        driver.manage().window().maximize();
        YahooPage yahooPage = new YahooPage(driver);
        yahooPage.clickFinanceLink();
        driverManager.shutDown();
    }
//===================================================================================//
    @Test
    public void test_2()
    {

    }
//===================================================================================//
    @Test
    public void test_3()
    {

    }
//===================================================================================//
//        String log4jConfPath = "C:\\Users\\liesn\\IdeaProjects\\yahoo\\src\\main\\java\\core\\logger\\log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
//        MyLogger.log.setLevel(Level.DEBUG);
//        MyLogger.log.debug("Test");
//===================================================================================//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://yahoo.com");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[@href='https://finance.yahoo.com/']")).click();
//        Thread.sleep(5000);
//        driver.quit();
//==================================================================================//

}
