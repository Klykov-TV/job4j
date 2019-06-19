package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void testingTriangle() {
        Shape tri = new Triangle();
        assertThat(tri.draw(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" + + ")
                                .append("+ + +")
                                .toString()
                )
        );
    }
}
