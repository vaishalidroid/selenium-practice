package FirstDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FirstDropdownu {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // NEW: Use preferences to block location popups (modern, reliable way)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 = Block
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.olx.in/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement locationbox = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='Search city, area or locality']")
            )
        );
        locationbox.click();
    }
}