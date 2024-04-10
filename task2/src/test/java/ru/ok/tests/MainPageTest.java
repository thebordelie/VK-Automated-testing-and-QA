package ru.ok.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import ru.ok.model.LoginPageActor;
import ru.ok.model.LoginPage;
import ru.ok.model.MainPage;
import ru.ok.model.MainPageActor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    private final MainPageActor mainPageActor = new MainPageActor(new MainPage());
    private static final LoginPageActor loginPageActor = new LoginPageActor(new LoginPage());

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru/";
        WebDriverManager.chromedriver().driverVersion("123").setup();
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--headless\"");
        System.setProperty("webdriver.chrome.driver", "//usr//bin//chromedriver");
        loginPageActor.loginOnPage("technopol52", "technopolisPassword");
    }

    @AfterEach
    public void closeSession() {
        Selenide.closeWebDriver();
    }


    @Test
    @DisplayName("check search results for groups that don't exists")
    public void checkSearchOnNonExistingGroups() {
        mainPageActor.searchOnSite("12345678911123525127350892745");
        assertEquals(mainPageActor
                .switchToGroutTab()
                .getInfoAboutGroups()
                .getText(), "Таких групп не нашлось");
    }
}
