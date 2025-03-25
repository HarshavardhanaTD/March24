package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @Parameters({"os", "br"})
    @BeforeClass
    public void setUp(String os, String br) throws IOException {

        // Load properties file
        FileReader file = new FileReader("./src/test/resources/Config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        // Fix: Initialize driver BEFORE calling driver.get()
        if (p.getProperty("execution_env").equals("remote")) { // Removed semicolon (important!)
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("Windows")) 
            {
                capabilities.setPlatform(Platform.WIN11);
              
            } 
            
            else if(os.equalsIgnoreCase("Linux"))
            {
            	capabilities.setPlatform(Platform.LINUX);
            }
            	
            else if  (os.equalsIgnoreCase("Mac")) 
            {
                capabilities.setPlatform(Platform.MAC);
            } 
            else 
            {
                System.out.println("No matching OS");
                return;
            }

            // Set browser capabilities
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("edge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://192.168.0.110:4444/wd/hub"), capabilities);
        } else if (p.getProperty("execution_env").equals("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }
        }

        // Fix: Now driver is initialized, so it's safe to call get()
        driver.get(p.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        // Implement screenshot capture logic
    }
}