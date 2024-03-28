package ru.ok.model;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    private final SelenideElement loginInput = $x("//input[@id='field_email']");
    private final SelenideElement passwordInput = $x("//input[@id='field_password']");
    private final SelenideElement loginButton = $x("//input[@value='Войти в Одноклассники']");
    private final SelenideElement errorElement = $x("//div[@class='input-e login_error']");

    public LoginPage openPage() {
        Selenide.open("/");
        return this;
    }

    public void enterLogin(String userName) {
        loginInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public SelenideElement findErrorMessage() {
        return errorElement;
    }

    public SelenideElement findSpanElementOnPage(String text) {
        return $x("//*[@id='" + text + "']");
    }

}
