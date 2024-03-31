package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserDriver {

    public static WebDriver driver;

    public static WebDriverWait wait;

    public ChromeOptions options;

    public BrowserDriver(){
        this.driver = driver;
      //  System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.get(PropertyFileReader.readConfigFile().getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void close(){
        this.driver.close();
    }

}
