package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Timofey Klykov
 * @version $Id$
 * @since 05.2019
 */
public class CalculateTest {
 /**
 * Test echo.
 */

@Test
 public void whenTakeNameThenThreeEchoPlusName() {
    String input = "Timofey Klykov";
    String expect = "Echo, echo, echo : Timofey Klykov"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
 }

}