package ru.job4j.tracker;

import java.util.List;

public class DeleteItems implements UserAction {
    private final Output out;

    public DeleteItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete all items ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
                tracker.delete(item.getId());
                out.println("Item has deleted successfully.");
            }
        } else {
            out.println("Items doesn't exist");
        }
        return true;
    }
}
