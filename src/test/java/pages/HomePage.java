
package pages;

import org.openqa.selenium.*;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement emailField() {
        return driver.findElement(By.id("inputEmail"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("inputPassword"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public List<WebElement> listItems() {
        return driver.findElements(By.xpath("//div[@id='test-2-div']//li"));
    }

    public WebElement dropdownButton() {
        return driver.findElement(By.id("dropdownMenuButton"));
    }

    public void selectDropdownOption(String option) {
        dropdownButton().click();
        driver.findElement(By.xpath("//a[text()='" + option + "']")).click();
    }

    public List<WebElement> test4Buttons() {
        return driver.findElements(By.xpath("//div[@id='test-4-div']//button"));
    }

    public WebElement dynamicButton() {
        return driver.findElement(By.id("test5-button"));
    }

    public WebElement successAlert() {
        return driver.findElement(By.id("test5-alert"));
    }
}
