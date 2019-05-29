package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {

    ArrayChar word = new ArrayChar();

    @Test
    public void whenStartsWithPrefixThenTrue() {
        boolean result = word.startsWith("hello", "hell");
        boolean expect = true;
        assertThat(result, is(expect));
    }

    @Test
    public void whenNotStartsWithPrefixThenFalse() {
        boolean result = word.startsWith("hello", "Ola");
        boolean expect = false;
        assertThat(result, is(expect));
    }
}

