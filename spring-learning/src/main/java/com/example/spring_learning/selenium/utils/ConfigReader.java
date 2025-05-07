package com.example.spring_learning.selenium.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    static {
        try(InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("File not found or something went wrong");
        }
    }

    public static String getKey(String key) {
        return properties.getProperty("url");
    }
}
