package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void All_items_have_a_sell_in_value_which_denotes_the_number_of_days_we_have_to_sell_the_item() {
        Item item = new Item("foo", 5, 0);
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
        gr.updateQuality();

        Item firstItem = gr.items[0];
        assertEquals(0, firstItem.sellIn);
        assertEquals(1, firstItem.quality);

        Item secondItem = gr.items[1];
        assertEquals(14, secondItem.sellIn);
        assertEquals(9, secondItem.quality);
    }

    @Test
    @Ignore
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
