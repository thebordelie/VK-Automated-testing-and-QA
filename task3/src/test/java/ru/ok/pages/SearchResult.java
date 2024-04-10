package ru.ok.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class SearchResult {
    private By searchInfoLocator = xpath("//h2[@class='heading__unijc __h2__unijc']");

    public SelenideElement getInfoAboutSearch() {
        return $(searchInfoLocator).shouldBe(visible);
    }

}
