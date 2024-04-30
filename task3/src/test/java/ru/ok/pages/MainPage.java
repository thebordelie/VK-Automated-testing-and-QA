package ru.ok.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final By SEARCH_INPUT_LOCATOR = By.xpath("//input[@type='text' and @placeholder='Search site']");

    public MainPage enterTextInSearchBar(String text) {
        $(SEARCH_INPUT_LOCATOR)
                .shouldBe(visible)
                .sendKeys(text);
        return this;
    }

    public SearchResult pressSearchButton() {
        $(SEARCH_INPUT_LOCATOR)
                .shouldBe(visible)
                .pressEnter();
        return new SearchResult();
    }




}
