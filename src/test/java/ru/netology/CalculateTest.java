package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {
    Calculate calculate;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start all testing");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Finish all testing");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Test begin");
        calculate = new Calculate();
    }

    @AfterEach
    public void afterEachTests() {
        System.out.println("Test over");
        calculate = null;
    }

    @Test
    void testTaxEarnings() {
        int x = 35000;
        int result = calculate.taxEarnings(x);
        assertNotNull(result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testSourceTaxEarnings(int x, int y) {
        int result = calculate.taxEarnings(x);
        assertEquals(result, y);
    }


    @Test
    void taxEarningsMinusSpendings() {
        int x = 100, y = 50, expected = 7;
        int result = calculate.taxEarningsMinusSpendings(x, y);
        assertEquals(expected,result);

    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(35000, 2100));
    }
}