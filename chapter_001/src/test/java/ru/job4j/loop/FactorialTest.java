package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    Factorial factor = new Factorial();

    @Test
    public void whenCalcFactorialFor5Then120() {
        int result = factor.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenCalcFactorialFor0Then1() {
        int result = factor.calc(0);
        assertThat((result), is(1));
    }
}
