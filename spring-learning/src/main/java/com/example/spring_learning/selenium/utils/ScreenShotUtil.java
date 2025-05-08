package com.example.spring_learning.selenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {
    private static final Logger logger = LoggerFactory.getLogger(ScreenShotUtil.class);
    public static String takeScreenshot(WebDriver driver, String testName) {
        String destinationPath = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        String screenshotAsBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
        } catch (IOException e) {
            logger.error("Error while performing IO operations" + e.getMessage());
        }
        return screenshotAsBase64;
    }
}
