package pages;

import org.openqa.selenium.*;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    
    // PRIVATE LOCATORS
      

    // Test 1 – Login
    private By emailInput = By.id("inputEmail");
    private By passwordInput = By.id("inputPassword");
    private By loginBtn = By.xpath("//button[@type='submit']");

    // Test 2 – List Group
    private By listItems = By.xpath("//div[@id='test-2-div']//li");
    private By listItemBadge = By.tagName("span");

    // Test 3 – Dropdown
    private By dropdownButton = By.id("dropdownMenuButton");
    private String dropdownOption = "//a[text()='%s']";

    // Test 4 – Buttons
    private By test4Buttons = By.xpath("//div[@id='test-4-div']//button");

    // Test 5 – Dynamic Button
    private By dynamicButton = By.id("test5-button");
    private By successAlert = By.id("test5-alert");

    
    // PUBLIC METHODS
      

    // ---------- Test 1 ----------
    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailInput).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordInput).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginBtn).isDisplayed();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // ---------- Test 2 ----------
    public int getListItemCount() {
        return driver.findElements(listItems).size();
    }

    public String getListItemText(int index) {
        return driver.findElements(listItems).get(index).getText();
    }

    public String getListItemBadgeValue(int index) {
        WebElement item = driver.findElements(listItems).get(index);
        return item.findElement(listItemBadge).getText();
    }

    // ---------- Test 3 ----------
    public String getSelectedDropdownValue() {
        return driver.findElement(dropdownButton).getText();
    }

    public void selectDropdownOption(String option) {
        driver.findElement(dropdownButton).click();
        driver.findElement(By.xpath(String.format(dropdownOption, option))).click();
    }

    // ---------- Test 4 ----------
    public boolean isFirstButtonEnabled() {
        return driver.findElements(test4Buttons).get(0).isEnabled();
    }

    public boolean isSecondButtonEnabled() {
        return driver.findElements(test4Buttons).get(1).isEnabled();
    }

    // ---------- Test 5 ----------
    public void clickDynamicButton() {
        driver.findElement(dynamicButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successAlert).isDisplayed();
    }

    public boolean isDynamicButtonEnabled() {
        return driver.findElement(dynamicButton).isEnabled();
    }
}
