package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate input = new ArrayDuplicate();
        String[] income = {"one", "one", "two", "one", "3", "3", "two", "one", "five"};
        String[] expect = {"one", "two", "3", "five"};
        assertThat(input.remove(income), is(expect));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicates() {
        ArrayDuplicate input = new ArrayDuplicate();
        String[] income = {"one", "one", "one", "one"};
        String[] expect = {"one"};
        assertThat(input.remove(income), is(expect));
    }
}
