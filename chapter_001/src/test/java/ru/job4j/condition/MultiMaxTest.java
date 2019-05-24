package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {

    MultiMax check = new MultiMax();

    @Test
    public void whenFirstMax() {
        int result = check.max(10, 3, 1);
        assertThat(result, is(10));
    }

    @Test
    public void whenSecondMax() {
        int result = check.max(10, 23, 1);
        assertThat(result, is(23));
    }

    @Test
    public void whenThirdMax() {
        int result = check.max(1, 3, 12);
        assertThat(result, is(12));
    }
}
