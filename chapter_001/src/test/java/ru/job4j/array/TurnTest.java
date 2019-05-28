package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenArray12345() {
        Turn turn = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turn.back(input);
        int[] expect = {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenArray5831() {
        Turn turn = new Turn();
        int[] input = new int[]{5, 8, 3, 1};
        int[] result = turn.back(input);
        int[] expect = {1, 3, 8, 5};
        assertThat(result, is(expect));
    }
}
