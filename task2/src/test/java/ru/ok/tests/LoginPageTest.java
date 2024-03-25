package ru.ok.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.ok.model.LoginOrchestrator;
import ru.ok.model.LoginPage;

import static com.codeborne.selenide.Condition.*;

public class LoginPageTest {
    private final LoginOrchestrator loginOrchestrator = new LoginOrchestrator(new LoginPage());

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru/";
    }

    @AfterEach
    public void closeSession() {
        Selenide.closeWebDriver();
    }

    @ParameterizedTest(name = "login = {0}, password = {1}")
    @DisplayName("check correct data for login form")
    @CsvFileSource(resources = {"/data.csv"})
    @Timeout(10)
    public void checkLoginPage(String login, String password) {
        loginOrchestrator
                .loginOnPage(login, password)
                .findSpanElementOnPage("Моя лента")
                .shouldBe(visible);
    }

    @Test
    @Timeout(10)
    @DisplayName("check empty login")
    public void checkEmptyLogin() {
        loginOrchestrator
                .loginOnPage("", "")
                .findErrorMessage()
                .shouldBe(visible)
                .shouldHave(text("Введите логин"));
    }

    @Test
    @Timeout(10)
    @DisplayName("check incorrect data for login form")
    public void checkIncorrectData() {
        loginOrchestrator
                .loginOnPage("incorrectLogin", "incorrectPassword")
                .findErrorMessage()
                .shouldBe(visible)
                .shouldHave(text("Неправильно указан логин и/или пароль"));
    }
}
