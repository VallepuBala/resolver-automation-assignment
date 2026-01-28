
package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
