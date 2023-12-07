package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @AfterEach
    public void clearItems() {
        try (HbmTracker tracker = new HbmTracker()) {
            for (Item item : tracker.findAll()) {
                tracker.delete(item.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemAndFindByGeneratedIdThenMustBeEqual() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            int itemId = item.getId();
            Item changedItem = new Item("test");
            tracker.replace(itemId, changedItem);
            assertThat(tracker.findById(itemId).getName()).isEqualTo("test");
        }
    }

    @Test
    public void whenDeleteItemAndFindByGeneratedIdThenNull() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            int itemId = item.getId();
            tracker.delete(itemId);
            assertThat(tracker.findById(itemId)).isNull();
        }
    }

    @Test
    public void whenFindAllItemsThenMustBeEqual() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            Item item1 = new Item();
            item1.setName("test1");
            tracker.add(item);
            tracker.add(item1);
            assertThat(tracker.findAll()).hasSize(2).containsExactly(item, item1);
        }
    }

    @Test
    public void whenFindItemsByNameThenMustBeEqual() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            Item item1 = new Item();
            item1.setName("test1");
            Item item2 = new Item();
            item2.setName("test");
            tracker.add(item);
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findByName("test")).hasSize(2).isEqualTo(List.of(item, item2));
        }
    }
}