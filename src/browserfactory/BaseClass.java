package browserfactory;
/**
 * Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        //cookies
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        // Launch the Chrome Browser
        driver = new ChromeDriver(options);
        // Open the URL into Browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        // We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){

        driver.quit();
    }
}

