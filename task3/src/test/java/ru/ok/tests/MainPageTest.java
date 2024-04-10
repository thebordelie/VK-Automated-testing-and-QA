package ru.ok.tests;


import org.junit.jupiter.api.*;
import ru.ok.actors.LoginPageActor;
import ru.ok.actors.MainPageActor;
import ru.ok.pages.LoginPage;
import ru.ok.pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends BaseTest {
    private final MainPageActor mainPageActor = new MainPageActor(new MainPage());
    private static final LoginPageActor loginPageActor = new LoginPageActor(new LoginPage());

    @BeforeAll
    public static void setup() {
        BaseTest.setup();
        loginPageActor.loginOnPage("technopol52", "technopolisPassword");
    }


    @TestFactory
    @DisplayName("check different data for search")
    public Stream<DynamicTest> checkResultsAfterSearch() {
        List<String> inputList = List.of("Группы в ОК", "Группы", "Люди");
        return inputList.stream().map(
                input -> DynamicTest.dynamicTest(
                        String.format("test for input %s", input),
                        () -> assertTrue(mainPageActor
                                .searchOnSite(input)
                                .getInfoAboutSearch().getText().contains("Найдено")
                        )
                )
        );
    }
}
