package ru.job4j.single;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import ru.job4j.tracker.Item;
import org.junit.Test;

public class TrackerSingleTest {

    @Test
    public void whenUsingEnumToLimit() {
        TrackerSingle1 single1 = TrackerSingle1.INSTANCE;
        TrackerSingle1 single2 = TrackerSingle1.INSTANCE;
        Item item = new Item("same", "name");
        single1.add(item);
        assertThat(single2.findAll()[0].getName(), is("same"));
    }

    @Test
    public void whenUsingStaticFieldToLimit() {
        TrackerSingle2 single1 = TrackerSingle2.getInstance();
        TrackerSingle2 single2 = TrackerSingle2.getInstance();
        Item item = new Item("single1", "whatever");
        single1.add(item);
        assertThat(single2.findAll()[0].getName(), is("single1"));
    }

    @Test
    public void whenUsingStaticFinalFieldToLimit() {
        TrackerSingle3 single1 = TrackerSingle3.getInstance();
        TrackerSingle3 single2 = TrackerSingle3.getInstance();
        Item item = new Item("single1", "whatever");
        single1.add(item);
        assertThat(single2.findAll()[0].getName(), is("single1"));
    }

    @Test
    public void whenUsingStaticFinalClassToLimit() {
        TrackerSingle4 single1 = TrackerSingle4.getInstance();
        TrackerSingle4 single2 = TrackerSingle4.getInstance();
        Item item = new Item("single1", "whatever");
        single1.add(item);
        assertThat(single2.findAll()[0].getName(), is("single1"));
    }

}
