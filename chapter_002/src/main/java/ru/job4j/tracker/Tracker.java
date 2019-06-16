package ru.job4j.tracker;

import java.util.*;

public class Tracker {
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
                String newid = this.items[i].getId();
                this.items[i] = item;
                this.items[i].setId(newid);
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
        Item[] res = Arrays.copyOf(this.items, pos);
        int j = 0;
        for (int i = 0; i < this.pos; i++) {
            if (res[i].getName().equals(key)) {
                res[j] = this.items[i];
                j++;
            }
        }
        return Arrays.copyOf(res, j);
    }

    public Item findById(String id) {
        Item res = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                res = item;
                break;
            }
        }
        return res;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
