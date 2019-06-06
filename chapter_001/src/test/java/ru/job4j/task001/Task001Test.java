package ru.job4j.task001;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Task001Test {
    Task001 task = new Task001();

    @Test
    public void whenRight() {
        int[] first = {2, 4, 5, 7, 9, 9,};
        int[] second = {1, 3, 3, 5, 6, 7, 8, 9};
        int[] result = task.combined(first, second);
        int[] expect = {1, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9, 9, 9};
        assertThat(result, is(expect));
    }

}
