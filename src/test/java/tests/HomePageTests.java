
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
        Assert.assertTrue(home.emailField().isDisplayed());
        Assert.assertTrue(home.passwordField().isDisplayed());
        Assert.assertTrue(home.loginButton().isDisplayed());
        home.emailField().sendKeys("test@company.com");
        home.passwordField().sendKeys("Password@123");
    }

    @Test
    public void test2_listGroupValidation() {
        HomePage home = new HomePage(driver);
        Assert.assertEquals(home.listItems().size(), 3);
        Assert.assertTrue(home.listItems().get(1).getText().contains("List Item 2"));
        Assert.assertEquals(
                home.listItems().get(1).findElement(By.tagName("span")).getText(),
                "6"
        );
    }

    @Test
    public void test3_dropdownValidation() {
        HomePage home = new HomePage(driver);
        Assert.assertEquals(home.dropdownButton().getText(), "Option 1");
        home.selectDropdownOption("Option 3");
        Assert.assertEquals(home.dropdownButton().getText(), "Option 3");
    }

    @Test
    public void test4_buttonStateValidation() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.test4Buttons().get(0).isEnabled());
        Assert.assertFalse(home.test4Buttons().get(1).isEnabled());
    }

    @Test
    public void test5_dynamicButtonValidation() {
        WaitUtils.waitForVisibility(driver, By.id("test5-button")).click();
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.successAlert().isDisplayed());
        Assert.assertFalse(home.dynamicButton().isEnabled());
    }

    @Test
    public void test6_tableValidation() {
        String value = TableUtils.getCellValue(driver, 2, 2);
        Assert.assertEquals(value, "Ventosanzap");
    }
}
