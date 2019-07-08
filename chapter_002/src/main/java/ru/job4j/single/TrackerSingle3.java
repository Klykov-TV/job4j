package ru.job4j.single;

import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Random;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();

    private TrackerSingle3() {

    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    Item[] items = new Item[100];
    private int pos = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.pos++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean res = false;
        for (int i = 0; i < pos; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                String newId = this.items[i].getId();
                this.items[i] = item;
                this.items[i].setId(newId);
                res = true;
            }
        }
        return res;
    }

    public boolean delete(String id) {
        boolean res = false;
        for (int i = 0; i < pos; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.pos--;
                res = true;
            }
        }
        return res;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.pos);
    }

    public Item[] findByName(String key) {
        Item[] res = new Item[0];
        int j = 0;
        for (int i = 0; i < this.pos; i++) {
            if (items[i].getName().equals(key)) {
                res = Arrays.copyOf(res, j + 1);
                res[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(res, j);
    }

    public Item findById(String id) {
        Item res = null;
        for (int i = 0; i < pos; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                res = this.items[i];
                break;
            }
        }
        return res;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}
