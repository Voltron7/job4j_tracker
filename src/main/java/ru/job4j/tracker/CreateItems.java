package ru.job4j.tracker;

public class CreateItems implements UserAction {
    private final Output out;

    public CreateItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create new items ===");
        for (int i = 0; i < 777777; i++) {
            Item item = new Item(i, "NameNumber " + i);
            tracker.add(item);
            out.println("Added item: " + item);
        }
        return true;
    }
}
