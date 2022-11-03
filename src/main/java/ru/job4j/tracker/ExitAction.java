package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit from app";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit from app ===");
        return false;
    }
}
