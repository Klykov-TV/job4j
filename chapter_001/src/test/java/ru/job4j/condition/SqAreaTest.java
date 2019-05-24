package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SqAreaTest {
    @Test
    public void checkit() {
        assertThat(new SqArea().square(24, 2), is(32));
    }
}
