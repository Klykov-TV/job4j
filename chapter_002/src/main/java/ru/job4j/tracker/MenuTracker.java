package ru.job4j.tracker;

/**
 * @author Timofey Klykov
 * @since 26.06.2019
 */

public class MenuTracker {

    private UserAction[] actions = new UserAction[6];
    private Input input;
    private Tracker tracker;

    /**
     * Конструктор
     *
     * @param input   используемый input
     * @param tracker конкретное хранилише заявок
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполнение меню выбора действий
     */
    public void fillActions() {
        this.actions[0] = new AddItem(0, "Add item");
        this.actions[1] = new FindAllItem(1, "Show all items");
        this.actions[2] = new EditItem(2, "Edit item");
        this.actions[3] = new DeleteItem(3, "Delete item");
        this.actions[4] = new FindByIdItem(4, "Find item by ID");
        this.actions[5] = new FindByNameItem(5, "Find items by name");
    }

    /**
     * Выбор действия
     *
     * @param key уникальный ключ для выбора действия
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Вывод на экран возможных действий
     */
    public void show() {
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Добавление заявки
     */
    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки. ------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Новая заявка с ID : " + item.getId());
            System.out.println();
        }
    }

    /**
     * Поиск всех заявок
     */
    public class FindAllItem extends BaseAction {

        public FindAllItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все существующие заявки. ------------");
            Item[] all = tracker.findAll();
            for (int i = 0; i < all.length; i++) {
                StringBuilder item = new StringBuilder()
                        .append(String.format("%d.", i + 1))
                        .append(System.lineSeparator())
                        .append(String.format("Имя заявки: %s", all[i].getName()))
                        .append(System.lineSeparator())
                        .append(String.format("Описание заявки: %s", all[i].getDesc()))
                        .append(System.lineSeparator())
                        .append(String.format("ID заявки: %s", all[i].getId()))
                        .append(System.lineSeparator());
                System.out.println(item);
            }
        }
    }

    /**
     * Редактирование заявки
     */
    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение заявки. ------------");
            String id = input.ask("Введите ID заявки: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            System.out.println();
            if (tracker.replace(id, item)) {
                System.out.println("Заявка с ID " + item.getId());
                System.out.println("Новое имя: " + item.getName());
                System.out.println("Новое описание: " + item.getDesc());
            } else {
                System.out.println("Заявка не найдена.");
            }
            System.out.println();
        }

    }

    /**
     * Удаление заявки
     */
    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки. ------------");
            String id = input.ask("Введите ID заявки для удаления: ");
            if (tracker.delete(id)) {
                System.out.println("Звяка успешно удалена");
            } else {
                System.out.println("Заявка не найдена");
            }
            System.out.println();
        }
    }

    /**
     * Поиск заявки по ID
     */
    public class FindByIdItem extends BaseAction {

        public FindByIdItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID. ------------");
            String id = input.ask("Введите ID искомой заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                StringBuilder searched = new StringBuilder()
                        .append(String.format("Имя заявки: %s", item.getName()))
                        .append(System.lineSeparator())
                        .append(String.format("Описание заявки: %s", item.getDesc()))
                        .append(System.lineSeparator())
                        .append(String.format("ID заявки: %s", item.getId()))
                        .append(System.lineSeparator());
                System.out.println(searched);
            } else {
                System.out.println("Заявка не найдена.");
            }
        }
    }

    /**
     * Поиск заявки по имени
     */
    public class FindByNameItem extends BaseAction {

        public FindByNameItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени. ------------");
            String name = input.ask("Введите имя искомых заявок: ");
            Item[] item = tracker.findByName(name);
            System.out.println();
            if (item != null) {
                for (int i = 0; i < item.length; i++) {
                    StringBuilder searched = new StringBuilder()
                            .append(String.format("%d.", i + 1))
                            .append(System.lineSeparator())
                            .append(String.format("Имя заявки: %s", item[i].getName()))
                            .append(System.lineSeparator())
                            .append(String.format("Описание заявки: %s", item[i].getDesc()))
                            .append(System.lineSeparator())
                            .append(String.format("ID заявки: %s", item[i].getId()))
                            .append(System.lineSeparator());
                    System.out.println(searched);
                }
            } else {
                System.out.println("Заявки не найдены.");
            }
        }
    }

}
