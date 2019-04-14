package page;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

public abstract class Base {

    static String driverFile = null;
    String locatorsStr = null;
    public static Object locatorsFile = null;
    private static WebDriver driver = null;
    private static WebDriverWait wait;


    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void Checks() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();

        driverFile = currentDirectory + "/files/" + "chromedriver.exe";
        locatorsStr = currentDirectory + "/locators.json";
        locatorsFile = parser.parse(new FileReader(locatorsStr));

    }

    public void initialization() throws NumberFormatException, InterruptedException, IOException {

        String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();

        try {

            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> prefs = new HashMap<>();

//            prefs.put("profile.default_content_settings.popups", 0);
//            prefs.put("download.prompt_for_download", false);
//            prefs.put("download.directory_upgrade", true);
//            prefs.put("credentials_enable_service", false);
//            prefs.put("password_manager_enabled", false);
//            options.setExperimentalOption("prefs", prefs);
//
//            options.addArguments("disable-infobars");
//            options.addArguments("no-first-run");
//            options.addArguments("ignore-certificate-errors");
//            options.addArguments("disable-geolocation");

            String webDriverKey = "webdriver.chrome.driver";
            String webDriverValue = driverFile;
            System.setProperty(webDriverKey, webDriverValue);
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 10);

        } catch (Exception ex) {
            System.err.println("Configuration error " + ex.getMessage());
        } finally {
        }
    }


}
