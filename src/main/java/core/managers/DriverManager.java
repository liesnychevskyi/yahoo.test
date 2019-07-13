package core.managers;


import core.logger.MyLogger;
import core.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManager
{
    private WebDriver driver;
//------------------------------------------------------------------------||chrome
    public WebDriver chromeDriver()
    {
        try
        {
            MyLogger.log.info("WebDriver manager started...");
            WebDriverManager.chromedriver().setup();
            MyLogger.log.info("Creating ChromeDriver...");
            driver = new ChromeDriver();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return driver;
    }
//-------------------------------------------------------------------------||firefox
public WebDriver firefoxDriver()
{
    try
    {
        MyLogger.log.info("WebDriver manager started...");
        WebDriverManager.firefoxdriver().setup();
        MyLogger.log.info("Creating Firefox Driver...");
        driver = new FirefoxDriver();
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    return driver;
}
//--------------------------------------------------------------------------||edge
public WebDriver edgeDriver()
{
    try {
        MyLogger.log.info("WebDriver manager started...");
        WebDriverManager.edgedriver().setup();
        MyLogger.log.info("Creating EdgeDriver...");
        driver = new EdgeDriver();
    } catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    return driver;
}
//--------------------------------------------------------------------------||IE
    public WebDriver internetExplorerDriver ()
    {
        try {
            MyLogger.log.info("WebDriver manager started...");
            WebDriverManager.iedriver().setup();
            MyLogger.log.info("Creating InternetExplorer Driver...");
            driver = new InternetExplorerDriver();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return driver;
    }
//---------------------------------------------------------------------------||opera
        public WebDriver operaDriver()
        {
            try
            {
                MyLogger.log.info("WebDriver manager started...");
                WebDriverManager.operadriver().setup();
                MyLogger.log.info("Creating OperaDriver...");
                driver = new OperaDriver();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            return driver;
        }
//-------------------------------------------------------------------------||tearDown
            public void shutDown()
            {
                if (driver != null)
                {
                    MyLogger.log.info("Driver quiting...");
                    driver.quit();
                }
                else
                {
                    System.out.println("Driver is null, nothing to quit");
                }
            }
//--------------------------------------------------------------------------||
        }

