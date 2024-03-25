package ru.ok.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ok.model.LoginOrchestrator;
import ru.ok.model.LoginPage;
import ru.ok.model.MainPage;
import ru.ok.model.MainPageActor;

import static com.codeborne.selenide.Condition.text;

public class MainPageTest {
    private final MainPageActor mainPageActor = new MainPageActor(new MainPage());
    private static final LoginOrchestrator loginOrchestrator = new LoginOrchestrator(new LoginPage());

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru/";
        loginOrchestrator.loginOnPage("technopol52", "technopolisPassword");
    }

    @Test
    @DisplayName("check search results for existing groups")
    public void checkSearchOnExistingGroups() {
        mainPageActor.searchOnSite("Закуски");
        mainPageActor
                .switchToGroutTab()
                .getInfoAboutGroups()
                .shouldHave(text("Найдено"));
    }

    @Test
    @DisplayName("check search results for groups that don't exists")
    public void checkSearchOnNonExistingGroups() {
        mainPageActor.searchOnSite("12345678911");
        mainPageActor
                .switchToGroutTab()
                .getInfoAboutGroups()
                .shouldHave(text("Таких групп не нашлось"));
    }
}
