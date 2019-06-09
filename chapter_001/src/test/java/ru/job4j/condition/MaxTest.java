package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax4To1Then2() {
        Max max = new Max();
        int result = max.max(4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenMaxofThree() {
        Max ofthree = new Max();
        int result = ofthree.max(2, 2, 8);
        assertThat(result, is(8));
    }

    @Test
    public void whenMaxOfFour() {
        Max offour = new Max();
        int result = offour.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }
}
