package ru.job4j.tracker;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private int[] range = new int[] {0, 1, 2, 3, 4, 5};

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            System.out.println();
            menu.show();
            menu.select(input.ask("Select: ", this.range));
        } while (!"y".equals(this.input.ask("Press y to Exit:  ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
