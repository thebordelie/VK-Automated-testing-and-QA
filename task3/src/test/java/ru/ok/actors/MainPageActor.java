package ru.ok.actors;

import lombok.RequiredArgsConstructor;
import ru.ok.pages.MainPage;
import ru.ok.pages.SearchResult;

@RequiredArgsConstructor
public class MainPageActor {
    private final MainPage mainPage;

    public SearchResult searchOnSite(String text) {
        return mainPage
                .openPage()
                .enterTextInSearchBar(text)
                .pressSearchButton();
    }
}
