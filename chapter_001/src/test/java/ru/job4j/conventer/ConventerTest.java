package ru.job4j.conventer;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConventerTest {
    @Test
    public void whenConv140RubToEuroThenTwo() {
        Conventer convert = new Conventer();
        int result = convert.rubleToEuro(140);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void whenConv180RubToUSDThenThree() {
        Conventer convert = new Conventer();
        int result = convert.rubleToUSD(180);
        int expected = 3;
        assertThat(result, is(expected));
    }

    @Test
    public void whenConv5EuroToRubThen350() {
        Conventer convert = new Conventer();
        int result = convert.euroToRuble(5);
        int expected = 350;
        assertThat(result, is(expected));
    }

    @Test
    public void whenConv4USDToRubThen240() {
        Conventer convert = new Conventer();
        int result = convert.usdToRuble(4);
        int expected = 240;
        assertThat(result, is(expected));
    }
}
