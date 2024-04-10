package ru.ok.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.ok.actors.LoginPageActor;
import ru.ok.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BaseTest {
    private final LoginPageActor loginPageActor = new LoginPageActor(new LoginPage());

    @Nested
    @DisplayName("Check different data for login form")
    class LoginFormTest {

        @ParameterizedTest(name = "login = {0}, password = {1}")
        @DisplayName("check correct data for login form")
        @CsvFileSource(resources = {"/data.csv"})
        public void checkCorrectData(String login, String password) {
            assertEquals(loginPageActor
                    .loginOnPage(login, password)
                    .findElementOnPage("*", "class", "tico ellip")
                    .getText(), "technopol52 technopol52");
        }

        @Test
        @DisplayName("check empty login")
        public void checkEmptyLogin() {
            assertEquals(loginPageActor
                    .loginOnPage("", "")
                    .getErrorMessage()
                    .getText(), "Введите логин");
        }

        @Test
        @DisplayName("check empty password")
        public void checkEmptyPassword() {
            assertEquals(loginPageActor
                    .loginOnPage("213", "")
                    .getErrorMessage()
                    .getText(), "Введите пароль");
        }

        @Test
        @DisplayName("check incorrect data for login form")
        public void checkIncorrectData() {
            assertEquals(loginPageActor
                    .loginOnPage("incorrectLogin", "incorrectPassword")
                    .getErrorMessage()
                    .getText(), "Неправильно указан логин и/или пароль");
        }

    }


}
