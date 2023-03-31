package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemByIdActionTest {

    @Test
    public void whenFindItemByIdIsSuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "Item");
        tracker.add(item);
        FindItemByIdAction findItemById = new FindItemByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findItemById.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + item + ln);
        assertThat(tracker.findAll()).hasSize(1);
    }

    @Test
    public void whenFindItemByIdIsUnsuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        int idToFind = 1;
        FindItemByIdAction findItemById = new FindItemByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(idToFind);

        findItemById.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Find item by id ===" + ln + "Заявка с введенным id: " + idToFind + " не найдена." + ln);
    }
}