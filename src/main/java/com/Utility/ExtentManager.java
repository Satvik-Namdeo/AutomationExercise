package com.Utility;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ExtentManager implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    private static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReports.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = getExtentReports().createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String path = ScreenshotUtility.captureScreenshot(result.getMethod().getMethodName(), false);
        if (path != null) test.addScreenCaptureFromPath(path);
        test.pass("Test Passed");
        getExtentReports().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtility.captureScreenshot(result.getMethod().getMethodName(), true);
        if (path != null) test.addScreenCaptureFromPath(path);
        test.fail(result.getThrowable());
        getExtentReports().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
        getExtentReports().flush();
    }
}





