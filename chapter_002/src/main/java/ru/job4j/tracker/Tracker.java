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
        for (int i = 0; i <= pos; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                res = true;
            }
        }
        return res;
    }

    public boolean delete(String id) {
        boolean res = false;
        for (int i = 0; i <= pos; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                res = true;
            }
        }
        return res;
    }

    public Item[] findAll() {
        Item[] res = null;
        int j = 0;
        for (int i = 0; i <= this.pos; i++) {
            if (this.items[i] != null && res == null) {
                res = new Item[1];
                res[j] = this.items[i];
                j++;
            } else if (this.items[i] != null) {
                res = Arrays.copyOf(res, j + 1);
                res[j] = this.items[i];
                j++;
            }
        }
        return res;
    }

    public Item[] findByName(String key) {
        Item[] res = null;
        int j = 0;
        for (int i = 0; i <= this.pos; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key) && res == null) {
                res = new Item[1];
                res[0] = this.items[i];
                j++;
            } else if (this.items[i] != null && this.items[i].getName().equals(key)) {
                res = Arrays.copyOf(res, j + 1);
                res[j] = this.items[i];
                j++;
            }
        }
        return res;
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
