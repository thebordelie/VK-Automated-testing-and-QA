package ru.ok.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.xpath;


public class LoginPage {
    private final By loginInputLocator = xpath("//input[@id='field_email']");
    private final By passwordInputLocator = xpath("//input[@id='field_password']");
    private final By loginButtonLocator = xpath("//input[@value='Войти в Одноклассники']");
    private final By errorMessageLocator = xpath("//div[@class='input-e login_error']");

    public LoginPage openPage() {
        Selenide.open("/");
        return this;
    }

    public LoginPage enterLogin(String userName) {
        $(loginInputLocator)
                .as("Login input")
                .shouldBe(visible)
                .sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(passwordInputLocator)
                .as("Password input")
                .shouldBe(visible)
                .sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        $(loginButtonLocator)
                .as("login button")
                .shouldBe(visible)
                .click();
        return this;
    }

    public SelenideElement getErrorMessage() {
        return $(errorMessageLocator)
                .as("Error message")
                .shouldBe(visible);
    }

    public SelenideElement findElementOnPage(String tag, String attribute, String value) {
        return $x(String.format("//%s[@%s='%s']", tag, attribute, value)).shouldBe(visible);
    }
}
