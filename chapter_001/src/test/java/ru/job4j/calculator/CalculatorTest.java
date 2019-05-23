package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDiv10On5Then2() {
        Calculator calc = new Calculator();
        double result = calc.div(10D, 5D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractThreeMinusOneThen2() {
        Calculator calc = new Calculator();
        double result = calc.subtract(3D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleTwoMultiplyTwoThenFour() {
        Calculator calc = new Calculator();
        double result = calc.multiple(2D, 2D);
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
