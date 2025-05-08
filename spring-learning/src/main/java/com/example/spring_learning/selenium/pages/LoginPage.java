package com.example.spring_learning.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    By userName = By.id("username");
    By password = By.id("password");
    By submitBtn = By.id("submit");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.userName)).sendKeys(userName);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.submitBtn).click();
    }


}
