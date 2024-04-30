package ru.ok.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.xpath;


public class LoginPage {
    private final By LOGIN_INPUT_LOCATOR = xpath("//input[@id='field_email']");
    private final By PASSWORD_INPUT_LOCATOR = xpath("//input[@id='field_password']");
    private final By LOGIN_BUTTON_LOCATOR = xpath("//input[@value='Войти в Одноклассники']");
    private final By ERROR_MESSAGE_LOCATOR = xpath("//div[@class='input-e login_error']");

    public LoginPage enterLogin(String userName) {
        $(LOGIN_INPUT_LOCATOR)
                .as("Login input")
                .shouldBe(visible)
                .sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(PASSWORD_INPUT_LOCATOR)
                .as("Password input")
                .shouldBe(visible)
                .sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        $(LOGIN_BUTTON_LOCATOR)
                .as("login button")
                .shouldBe(visible)
                .click();
        return this;
    }

    public String getErrorMessage() {
        return $(ERROR_MESSAGE_LOCATOR)
                .as("Error message")
                .shouldBe(visible)
                .getText();
    }

    public SelenideElement findElementOnPage(String tag, String attribute, String value) {
        return $x(String.format("//%s[@%s='%s']", tag, attribute, value)).shouldBe(visible);
    }
}
