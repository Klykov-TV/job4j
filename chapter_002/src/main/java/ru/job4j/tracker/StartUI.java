package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String choice = this.input.ask("Select: ");
            switch (choice) {
                case ADD:
                    createItem();
                    break;
                case "1":
                    showAllItems();
                    break;
                case "2":
                    edit();
                    break;
                case "3":
                    del();
                    break;
                case "4":
                    idSearch();
                    break;
                case "5":
                    nameSearch();
                    break;
                case EXIT:
                    System.out.println("Завершение программы...");
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор операции. Повторите ввод");
                    System.out.println();
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки. ------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с ID : " + item.getId());
        System.out.println();
    }

    public void showAllItems() {
        System.out.println("------------ Все существующие заявки. ------------");
        Item[] all = this.tracker.findAll();
        if (all != null) {
            for (int i = 0; i < all.length; i++) {
                System.out.println(i + 1 + ".");
                System.out.println("Имя заявки: " + all[i].getName());
                System.out.println("Описание заявки: " + all[i].getDesc());
                System.out.println("ID заявки: " + all[i].getId());
                System.out.println();
            }
        } else {
            System.out.println("Заявки не найдены");
        }
    }

    private void edit() {
        System.out.println("------------ Изменение заявки. ------------");
        String id = this.input.ask("Введите ID заявки: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc);
        System.out.println();
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка с ID " + item.getId());
            System.out.println("Новое имя: " + item.getName());
            System.out.println("Новое описание: " + item.getDesc());
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println();
    }

    private void del() {
        System.out.println("------------ Удаление заявки. ------------");
        String id = this.input.ask("Введите ID заявки для удаления: ");
        if (this.tracker.delete(id)) {
            System.out.println("Звяка успешно удалена");
        } else {
            System.out.println("Заявка не найдена");
        }
        System.out.println();
    }

    private void idSearch() {
        System.out.println("------------ Поиск заявки по ID. ------------");
        String id = this.input.ask("Введите ID искомой заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Описание заявки: " + item.getDesc());
            System.out.println("ID заявки: " + item.getId());
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println();
    }

    private void nameSearch() {
        System.out.println("------------ Поиск заявок по имени. ------------");
        String name = this.input.ask("Введите имя искомых заявов: ");
        Item[] item = this.tracker.findByName(name);
        if (item != null) {
            for (int i = 0; i < item.length; i++) {
                System.out.println(i + 1 + ".");
                System.out.println("Имя заявки: " + item[i].getName());
                System.out.println("Описание заявки: " + item[i].getDesc());
                System.out.println("ID заявки: " + item[i].getId());
                System.out.println();
            }
        } else {
            System.out.println("Заявки не найдены.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
