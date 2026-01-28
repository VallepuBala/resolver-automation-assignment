package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("QE Automation Report");
            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Author", "Bala Durgesh Vallepu");
        }
        return extent;
    }
}
