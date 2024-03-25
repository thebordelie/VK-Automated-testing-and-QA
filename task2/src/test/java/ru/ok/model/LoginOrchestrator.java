package ru.ok.model;

import lombok.Data;

@Data
public class LoginOrchestrator {
    private final LoginPage loginPage;

    public LoginPage loginOnPage(String login, String password) {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        return loginPage;
    }
}
