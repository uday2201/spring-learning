package com.example.spring_learning.selenium.tests;

import com.aventstack.extentreports.ExtentTest;
import com.example.spring_learning.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLogin() {
        ExtentTest logger = extent.createTest("Login Test");
        logger.info("Starting login test");
        LoginPage login = new LoginPage(driver);
        login.login("student", "Password123");
        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
        logger.pass("Login successful");
    }
}
