package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    FindLoop loop = new FindLoop();

    @Test
    public void whenEl3() {
        int[] input = new int[]{1, 2, 3};
        int value = 3;
        int result = loop.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenElMissing() {
        int[] input = new int[]{4, 12, 83, 1};
        int value = 8;
        int result = loop.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
