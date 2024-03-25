package ru.ok.model;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MainPage {
    private final SelenideElement searchElement = $x("//input[@type='text' and @placeholder='Искать на сайте']");
    private final SelenideElement infoAboutGroups = $x("//h2[@class='heading__unijc __h2__unijc' and contains(text(), 'групп')]");
    private final SelenideElement groupsButton = $x("//button[@id='tab-groups' and text()='Группы']");

    public MainPage openPage() {
        Selenide.open("/");
        return this;
    }

    public void enterTextInSearchBar(String text) {
        searchElement.sendKeys(text);
    }

    public MainPage pressSearchButton() {
        searchElement.pressEnter();
        return this;
    }

    public MainPage pressGroupsButton() {
        groupsButton.click();
        return this;
    }
}
