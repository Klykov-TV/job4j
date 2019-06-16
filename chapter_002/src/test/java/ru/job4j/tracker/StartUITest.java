package ru.job4j.tracker;

import org.junit.Test;

import javax.sound.midi.Track;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenUserAddsItemToTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "TestName", "Testing", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("TestName"));
    }

    @Test
    public void whenUserWantsToEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("TestName", "Testing");
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "NewName", "NewDesc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("NewName"));
    }

    @Test
    public void whenUserWantsToDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Hello", "Delete me pls");
        tracker.add(item);
        String id = item.getId();
        Item item1 = new Item("Hi", "Pls dont delete me");
        tracker.add(item1);
        Input input = new StubInput(new String[]{"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
    }
}
