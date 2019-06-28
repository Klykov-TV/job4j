package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutPut() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutPut() {
        System.setOut(this.stdout);
    }

    private String menu = "\r\n"
            + "0. Add the new item\r\n"
            + "1. Show all items\r\n"
            + "2. Update item\r\n"
            + "3. Delete item\r\n"
            + "4. Find item by ID\r\n"
            + "5. Find items by Name\r\n";

    @Test
    public void whenUserAddsItemToTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "TestName", "Testing", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("TestName"));
    }

    @Test
    public void whenUserWantsToFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("First", "Second");
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                        .append(menu)
                        .append("------------ Все существующие заявки. ------------\r\n")
                        + ("1.\r\n")
                        + ("Имя заявки: First\r\n")
                        + ("Описание заявки: Second\r\n")
                        + String.format("ID заявки: %s%s", id, "\r\n\r\n")
                )
        );
    }

    @Test
    public void whenUserWantsToEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("TestName", "Testing");
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "NewName", "NewDesc", "y"});
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
        Input input = new StubInput(new String[]{"3", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
    }

    @Test
    public void whenSearchingId() {
        Tracker tracker = new Tracker();
        Item item = new Item("First", "Second");
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                        .append(menu)
                        .append("------------ Поиск заявки по ID. ------------\r\n")
                        + ("Имя заявки: First\r\n")
                        + ("Описание заявки: Second\r\n")
                        + ("ID заявки: " + id + "\r\n\r\n")
                )
        );
    }

    @Test
    public void whenSearchingNames() {
        Tracker tracker = new Tracker();
        Item item = new Item("First", "Second");
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"5", "First", "y"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                        .append(menu)
                        .append("------------ Поиск заявок по имени. ------------\r\n\r\n")
                        + ("1.\r\n")
                        + ("Имя заявки: First\r\n")
                        + ("Описание заявки: Second\r\n")
                        + String.format("ID заявки: %s%s", id, "\r\n\r\n")
                )
        );
    }
}
