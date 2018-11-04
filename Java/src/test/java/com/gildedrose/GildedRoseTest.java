package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void All_items_have_a_sell_in_value_which_denotes_the_number_of_days_we_have_to_sell_the_item() {
        Item item = Create.item().name("Item Name").sellIn(5).quality(0).obj();
        assertEquals(5, item.sellIn);
    }

    @Test
    public void All_items_have_a_quality_value_which_denotes_how_valuable_the_item_is() {
        Item item = new Item("foo", 0, 3);
        assertEquals(3, item.quality);
    }

    @Test
    public void At_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
        GildedRose gr = new GildedRose(new Item[]{new Item("First Item", 1, 2), new Item("Second Item", 15, 10)});

        gr.processEndOfDayUpdates();

        assertItem(gr.items[0], 0, 1);
        assertItem(gr.items[1], 14, 9);
    }

    @Test
    public void Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        GildedRose gr = new GildedRose(new Item[]{new Item("Item Name", 0, 5)});
        gr.processEndOfDayUpdates();
        assertItem(gr.items[0], -1, 3);
    }

    @Test
    public void The_quality_of_an_item_is_never_negative() {
        GildedRose gr = new GildedRose(new Item[]{new Item("Item Name", 1, 0)});
        gr.processEndOfDayUpdates();
        assertItem(gr.items[0], 0, 0);
    }

    private void assertItem(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }

    public static class Create {

        private String itemName;
        private int itemSellIn;
        private int itemQuality;

        public static Create item() {
            return new Create();
        }

        public Create name(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Create sellIn(int itemSellIn) {
            this.itemSellIn = itemSellIn;
            return this;
        }

        public Create quality(int itemQuality) {
            this.itemQuality = itemQuality;
            return this;
        }

        public Item obj() {
            return new Item(itemName, itemSellIn, itemQuality);
        }
    }

    @Test
    @Ignore
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.processEndOfDayUpdates();
        assertEquals("fixme", app.items[0].name);
    }

}
