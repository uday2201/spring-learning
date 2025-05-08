package com.example.spring_learning.selenium.listeners;

import com.example.spring_learning.selenium.tests.BaseTest;
import com.example.spring_learning.selenium.utils.ScreenShotUtil;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotAsBase64 = ScreenShotUtil.takeScreenshot(driver, result.getTestName());
        // Attach to report
        logger.fail(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotAsBase64).build());
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

}
