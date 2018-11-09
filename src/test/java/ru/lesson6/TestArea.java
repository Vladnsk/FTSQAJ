package ru.lesson6;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static ru.lesson6.Area.*;

public class TestArea {

    static int count = 0;
    static int countOk = 0;

    @BeforeAll
    static void beforeAllPrint() {
        System.out.println("------ТЕСТИРОВАНИЕ МЕТОДОВ ПЛОЩАДИ КРУГА, КВАДРАТА И ТРЕУГОЛЬНИКА------\n");
    }

    @AfterAll
    static void afterAllPrint() {
        System.out.println("------ТЕСТИРОВАНИЕ ЗАВЕРШЕНО------");
        System.out.println("Всего запущено тестов: " + count
                + "\nУспешно пройдено: " + countOk + "\nПровалено: " + (count - countOk));
    }

    @AfterEach
    void countTest() {
        count++;
    }

    @ParameterizedTest
    @Tag("Circle")
    @Tag("Negative")
    @DisplayName("Тесты площади круга с отрицательным и нулевым радиусом")
    @ValueSource(doubles = {-1, 0})
    void testCircleNegative(double argument) {
        assertThrows(ArithmeticException.class, () -> areaOfCircle(argument));
        countOk++;
    }

    @ParameterizedTest
    @Tag("Square")
    @Tag("Negative")
    @DisplayName("Тесты площади квадрата с отрицательным и нулевым радиусом")
    @ValueSource(doubles = {-1, 0})
    void testSquareNegative(double argument) {
        try {
            areaOfSquare(argument);
            fail("Не было выброшено ожидаемое исключение");
        } catch (ArithmeticException e) {
            countOk++;
        }
    }

    @ParameterizedTest
    @Tag("Triangle")
    @Tag("Negative")
    @DisplayName("Тесты площади треугольника с отрицательными и нулевыми основанием и высотой")
    @CsvSource({"-1, 1", "0, 1", "1, -1", "1, 0"})
    void testTriangleNegative(double base, double height) {
        assertThrows(ArithmeticException.class, () -> areaOfTriangle(base, height));
        countOk++;
    }

    @Test
    @Tag("Square")
    @Tag("Positive")
    @DisplayName("Позитивный тест площади квадрата")
    void testSquarePositive() {
        assert areaOfSquare(5) == 25;
        countOk++;
    }

    @Test
    @Tag("Circle")
    @Tag("Positive")
    @DisplayName("Позитивный тест площади круга")
    void testCirclePositive() {
        MatcherAssert.assertThat(areaOfCircle(1), Matchers.equalTo(Math.PI));
        countOk++;
    }

    @Test
    @Tag("Triangle")
    @Tag("Positive")
    @DisplayName("Позитивный тест площади треугольника")
    void testTrianglePositive() {
        Assertions.assertEquals(25, areaOfTriangle(5, 10),
                "Результат не соответствует ожиданию");
        countOk++;
    }
}
