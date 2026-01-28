package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TableUtils;
import utils.WaitUtils;
import org.openqa.selenium.By;

public class HomePageTests extends BaseTest {

    @Test
    public void test1_loginValidation() {
        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.isEmailFieldDisplayed(), "Email field is not displayed");
        Assert.assertTrue(home.isPasswordFieldDisplayed(), "Password field is not displayed");
        Assert.assertTrue(home.isLoginButtonDisplayed(), "Login button is not displayed");

        home.enterEmail("test@company.com");
        home.enterPassword("Password@123");
    }

    @Test
    public void test2_listGroupValidation() {
        HomePage home = new HomePage(driver);

        Assert.assertEquals(home.getListItemCount(), 3, "List item count mismatch");
        Assert.assertTrue(
                home.getListItemText(1).contains("List Item 2"),
                "Second list item text mismatch"
        );
        Assert.assertEquals(
                home.getListItemBadgeValue(1),
                "6",
                "Second list item badge value mismatch"
        );
    }

    @Test
    public void test3_dropdownValidation() {
        HomePage home = new HomePage(driver);

        Assert.assertEquals(
                home.getSelectedDropdownValue(),
                "Option 1",
                "Default dropdown value mismatch"
        );

        home.selectDropdownOption("Option 3");

        Assert.assertEquals(
                home.getSelectedDropdownValue(),
                "Option 3",
                "Dropdown value after selection mismatch"
        );
    }

    @Test
    public void test4_buttonStateValidation() {
        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.isFirstButtonEnabled(), "First button should be enabled");
        Assert.assertFalse(home.isSecondButtonEnabled(), "Second button should be disabled");
    }

    @Test
    public void test5_dynamicButtonValidation() {
        // Wait handled centrally, test remains clean
        WaitUtils.waitForVisibility(driver, By.id("test5-button"));

        HomePage home = new HomePage(driver);
        home.clickDynamicButton();

        Assert.assertTrue(
                home.isSuccessMessageDisplayed(),
                "Success message is not displayed"
        );
        Assert.assertFalse(
                home.isDynamicButtonEnabled(),
                "Dynamic button should be disabled after click"
        );
    }

    @Test
    public void test6_tableValidation() {
        String value = TableUtils.getCellValue(driver, 2, 2);
        Assert.assertEquals(value, "Ventosanzap", "Table cell value mismatch");
    }
}
