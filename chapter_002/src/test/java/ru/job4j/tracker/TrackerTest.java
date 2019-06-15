package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemFromMiddle() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("item2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("item3", "desc3", 12345L);
        tracker.add(item3);
        String id2 = item2.getId();
        tracker.delete(id2);
        assertThat(tracker.findAll()[1].getName(), is("item3"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("item2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("item3", "desc3", 12345L);
        tracker.add(item3);
        assertThat(tracker.findAll().length, is(3));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("item2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("item3", "desc3", 12343L);
        tracker.add(item3);
        Item item4 = new Item("item2", "desc4", 12345L);
        tracker.add(item4);
        assertThat(tracker.findByName("item2").length, is(2));
    }

    @Test
    public void whenFindByID() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("item2", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("item3", "desc3", 12343L);
        tracker.add(item3);
        Item item4 = new Item("item4", "desc4", 12345L);
        tracker.add(item4);
        String idOf4 = item4.getId();
        assertThat(tracker.findById(idOf4).getName(), is("item4"));
    }
}

