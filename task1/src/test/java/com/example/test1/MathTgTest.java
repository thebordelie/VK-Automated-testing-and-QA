package com.example.test1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTgTest {
    @ParameterizedTest(name = "sin({0}) = {1}")
    @DisplayName("Check between dots [-pi/2; +pi/2]")
    @CsvFileSource(resources = "/table_value.csv", numLinesToSkip = 1, delimiter = ';')
    void checkTanBetweenDots(double x, double y) {
        assertAll(
                () -> assertEquals(y, MathTan.calculateTan(x, 100), 0.01)
        );
    }
}
