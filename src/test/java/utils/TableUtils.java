
package utils;

import org.openqa.selenium.*;

public class TableUtils {

    public static String getCellValue(WebDriver driver, int row, int col) {
        return driver.findElement(
                By.xpath("//table/tbody/tr[" + (row + 1) + "]/td[" + (col + 1) + "]")
        ).getText();
    }
}
