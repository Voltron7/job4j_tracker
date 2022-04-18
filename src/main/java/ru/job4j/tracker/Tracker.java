package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean delete(int id) {
        if (id != -1) {
            System.arraycopy(items, indexOf(id) + 1, items, indexOf(id), size - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public Item[] findAll() {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
                rsl = item;
                break;
        }
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] copyItems = new Item[size];
        int copySize = 0;
        for (int index = 0; index < size; index++) {
            Item item = this.items[index];
            if (item.getName().equals(key)) {
                copyItems[copySize++] = item;
            }
        }
        return Arrays.copyOf(copyItems, copySize);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }
}