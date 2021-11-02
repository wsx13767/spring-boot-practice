package com.siang.springboot.practice.springbootpractice.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll");
    }

    @DisplayName("測試加法")
    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2 , 3);
        assertEquals(5, result);
    }

    @Disabled
    @Test
    public void divide() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }
}