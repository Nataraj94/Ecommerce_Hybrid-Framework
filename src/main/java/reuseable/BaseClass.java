package reuseable;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.CommonUtils;
import utils.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    private static Logger log=null;
    public static Properties properties;

    public static WebDriver browserCall() throws IOException {

        String path = System.getProperty("user.dir");
        properties= new ConfigReader().initializeProperties();
        System.setProperty("webdriver.chrome.driver",path +"//src//main//resources//drivers//chromedriver.exe");



        switch (properties.getProperty("Browser").toLowerCase()){

            case "chrome" :


                driver = new ChromeDriver();
                break;
            case "edge" :

                driver = new EdgeDriver();
                break;

            case "firefox" :
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));


        return driver;
    }
}
