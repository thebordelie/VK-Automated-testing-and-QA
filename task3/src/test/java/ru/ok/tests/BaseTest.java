package ru.ok.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private static final Properties properties = new Properties();
    static {
        try {
            properties.load(new FileInputStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = properties.getProperty("base_url");
//        WebDriverManager.chromedriver().driverVersion(properties.getProperty("driver_version")).setup();
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\"");
//        System.setProperty("webdriver.chrome.driver", "//usr/bin//chromedriver");
    }

    @BeforeEach
    public void open() {
        Selenide.open("/");
    }

    @AfterEach
    public void closeSession() {
        Selenide.closeWebDriver();
    }
}
