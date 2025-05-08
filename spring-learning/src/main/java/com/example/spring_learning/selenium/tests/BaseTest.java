package com.example.spring_learning.selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.spring_learning.selenium.driverfactory.WebDriverFactory;
import com.example.spring_learning.selenium.utils.ConfigReader;

import com.example.spring_learning.selenium.utils.ExtentManager;
import com.example.spring_learning.selenium.utils.ScreenShotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public WebDriver driver;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public ExtentTest logger;

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(ConfigReader.getKey("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
