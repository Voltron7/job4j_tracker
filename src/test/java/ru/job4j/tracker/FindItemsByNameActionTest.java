package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemsByNameActionTest {

    @Test
    public void whenFindItemsByNameIsSuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "Item");
        tracker.add(item);
        FindItemsByNameAction findItemsByName = new FindItemsByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Item");

        findItemsByName.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln + item + ln);
        assertThat(tracker.findAll()).hasSize(1);
    }

    @Test
    public void whenFindItemsByNameIsUnsuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String nameToFind = "Item";
        FindItemsByNameAction findItemsByName = new FindItemsByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(nameToFind);

        findItemsByName.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Find items by name ===" + ln + "Заявки с именем: " + nameToFind + " не найдены." + ln);
    }
}