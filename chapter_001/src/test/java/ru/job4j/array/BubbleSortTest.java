package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void whenArrayStores10Elements() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[]{1, 8, 3, 5, 7, 10, 32, 4, 9, 6};
        int[] result = bubble.sort(input);
        int[] expect = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 32};
        assertThat(result, is(expect));
    }
}
