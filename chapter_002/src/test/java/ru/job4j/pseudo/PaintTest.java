package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutPut() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutPut() {
        System.setOut(this.stdout);
        System.out.println("Execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("+ + + +")
                                .append("+     +")
                                .append("+     +")
                                .append("+ + + +")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
