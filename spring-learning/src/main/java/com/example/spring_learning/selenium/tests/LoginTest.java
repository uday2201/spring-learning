package com.example.spring_learning.selenium.tests;

import com.aventstack.extentreports.Status;
import com.example.spring_learning.selenium.pages.LoginPage;
import com.example.spring_learning.selenium.utils.ScreenShotUtil;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUp(ITestContext context) {
        logger = extent.createTest(context.getName());
    }

    @Test
    public void validLogin() {
        logger.info("Starting login test");
        LoginPage login = new LoginPage(driver);
        login.login("student", "Password123");
        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
        logger.pass("Login successful");
    }

//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String screenshotAsBase64 = ScreenShotUtil.takeScreenshot(driver, result.getTestName());
//            // Attach to report
//            logger.fail(result.getThrowable(),
//                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotAsBase64).build());
//        }
//        extent.flush();
//    }
}
