package ru.ok.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private By searchInputLocator = By.xpath("//input[@type='text' and @placeholder='Искать на сайте']");

    public MainPage openPage() {
        Selenide.open("/");
        return this;
    }

    public MainPage enterTextInSearchBar(String text) {
        $(searchInputLocator)
                .shouldBe(visible)
                .sendKeys(text);
        return this;
    }

    public SearchResult pressSearchButton() {
        $(searchInputLocator)
                .shouldBe(visible)
                .pressEnter();
        return new SearchResult();
    }




}
