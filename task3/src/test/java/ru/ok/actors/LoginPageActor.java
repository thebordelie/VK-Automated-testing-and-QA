package ru.ok.actors;

import lombok.Data;
import ru.ok.pages.LoginPage;

@Data
public class LoginPageActor {
    private final LoginPage loginPage;

    public LoginPage loginOnPage(String login, String password) {
        loginPage
                .enterLogin(login)
                .enterPassword(password)
                .clickLoginButton();
        return loginPage;
    }
}
