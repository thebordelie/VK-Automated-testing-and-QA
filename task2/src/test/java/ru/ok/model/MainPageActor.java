package ru.ok.model;

import lombok.Data;

@Data
public class MainPageActor {
    private final MainPage mainPage;

    public MainPage searchOnSite(String text) {
        mainPage.openPage();
        mainPage.enterTextInSearchBar(text);
        mainPage.pressSearchButton();
        mainPage.pressGroupsButton();
        return mainPage;
    }

    public MainPage switchToGroutTab() {
        mainPage.pressGroupsButton();
        return mainPage;
    }


}
