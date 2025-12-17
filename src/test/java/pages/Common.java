package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {

    public static WebDriver driver;
    /** Centralized browser launch **/
    public static void browserLaunch(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        
        else if (browser.equalsIgnoreCase("Edge")) {
            // Use WebDriverManager
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } 
        
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        else {
            System.out.println("Invalid Browser Name: " + browser);
            throw new IllegalArgumentException("Browser not supported");
        }

        driver.manage().window().maximize();
    }

    public static void browserLaunches(String browser) {

        if (browser == null || browser.trim().isEmpty()) {
            browser = "Chrome";   // default fallback
            System.out.println("Browser parameter missing → Defaulting to Chrome.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
    }

    public static void loadUrl(String url) {
        driver.get(url);
    }

    public static void quickWait() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void webElementWait(WebElement ele) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
            .until(ExpectedConditions.elementToBeClickable(ele));
    }

    public static void webElementXpathWait(By xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(40))
            .until(ExpectedConditions.elementToBeClickable(xPath));
    }

    public static void webElementOccurance(By xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(40))
            .until(ExpectedConditions.visibilityOfElementLocated(xPath));
    }

    public static void selectByVisibleText(WebElement ele, String value) {
        new Select(ele).selectByVisibleText(value);
    }

    public static void javaScriptExecutorClick(WebElement ele) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click()", ele);
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
        }
    
    public static String readProperty(String key) throws IOException { 
    	File file = new File("C:\\Users\\cutem\\Downloads\\SeptemberProject2025\\SeptemberProject2025\\src\\test\\resources\\Credentials\\Details.properties");
    	FileInputStream fis = new FileInputStream(file);
    	Properties prop = new Properties(); 
    	prop.load(fis); 
    	String property = prop.getProperty(key);
    	return property; 
    	}
        
      public static void updateLog(Status statusStep) {
        // --- Logging Setup ---
        String methodName = new Throwable().getStackTrace()[1].getMethodName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        String logMessage = methodName + " ---- " + statusStep.toString();

        System.out.println(logMessage);

        // --- Screenshot Logic ---
        if (driver != null) {
            try {
                // Take screenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                File screenshotSourceFile = ts.getScreenshotAs(OutputType.FILE);

                // Directory path
                String screenshotDir =
                        "C:\\Users\\cutem\\Downloads\\SeptemberProject2025\\SeptemberProject2025\\src\\test\\resources\\TakeScreenshot";

                // Create directory if missing
                File destinationDir = new File(screenshotDir);
                if (!destinationDir.exists()) {
                    destinationDir.mkdirs();
                    System.out.println("Created screenshot directory: " + screenshotDir);
                }

                // File name
                String filename = methodName + "_" + statusStep.toString() + "_" + timestamp + ".png";

                // Target
                File destinationFile = new File(destinationDir, filename);

                // Copy screenshot
                FileHandler.copy(screenshotSourceFile, destinationFile);

                System.out.println("✔ Screenshot saved for " + statusStep + " as: " + filename);

            } catch (ClassCastException e) {
                System.err.println("❌ Driver cannot capture screenshot (ClassCastException)");
            } catch (IOException e) {
                System.err.println("❌ Screenshot saving failed: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("❌ Unexpected screenshot error: " + e.getMessage());
            }

        } else {
            System.err.println("⚠ WebDriver is NULL - cannot capture screenshot");
        }
    }
}