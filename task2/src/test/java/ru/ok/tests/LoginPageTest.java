package ru.ok.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.ok.model.LoginPageActor;
import ru.ok.model.LoginPage;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {
    private final LoginPageActor loginPageActor = new LoginPageActor(new LoginPage());

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru/";
        WebDriverManager.chromedriver().driverVersion("123").setup();
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--headless\"\"");
//        System.setProperty("webdriver.chrome.driver", "//usr/bin//chromedriver");
    }

    @AfterEach
    public void closeSession() {
        Selenide.closeWebDriver();
    }

    @ParameterizedTest(name = "login = {0}, password = {1}")
    @DisplayName("check correct data for login form")
    @CsvFileSource(resources = {"/data.csv"})
    public void checkLoginPage(String login, String password) {
        assertEquals(loginPageActor
                        .loginOnPage(login, password)
                        .findElementByClass("tico ellip")
                        .getText(), "technopol52 technopol52");
    }

    @Test
    @DisplayName("check empty login")
    public void checkEmptyLogin() {
        assertEquals(loginPageActor
                .loginOnPage("", "")
                .findErrorMessage()
                .getText(), "Введите логин");
    }

    @Test
    @DisplayName("check incorrect data for login form")
    public void checkIncorrectData() {
        assertEquals(loginPageActor
                .loginOnPage("incorrectLogin", "incorrectPassword")
                .findErrorMessage()
                .getText(), "Неправильно указан логин и/или пароль");
    }
}
