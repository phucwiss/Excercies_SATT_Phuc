package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverUtils {
    public static void initDriver() {
        switch (Constant.BROWSER.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "Resources/driver/chromedriver.exe");
                Constant.DRIVER = new ChromeDriver();
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "Resources/driver/geckodriver.exe");
                Constant.DRIVER = new FirefoxDriver();
                break;
            }
        }
    }


    public static void maximize() {Constant.DRIVER.manage().window().maximize();}
    public static void navigate(String railwayUrl){
        Constant.DRIVER.get(railwayUrl);
    }
    public static void quitBrowser(){Constant.DRIVER.quit();}

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void scrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) Constant.DRIVER;
        jse.executeScript("window.scrollBy(0,250)");
    }

}
