package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.builder.Create;
import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

    private GildedRose gr;

    @Test
    public void All_items_have_a_sell_in_value_which_denotes_the_number_of_days_we_have_to_sell_the_item() {
        Item item = Create.item().sellIn(5).obj();
        assertEquals(5, item.sellIn);
    }

    @Test
    public void All_items_have_a_quality_value_which_denotes_how_valuable_the_item_is() {
        Item item = Create.item().quality(3).obj();
        assertEquals(3, item.quality);
    }

    @Test
    public void At_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
        Item first = Create.item().sellIn(1).quality(2).obj();
        Item second = Create.item().sellIn(15).quality(10).obj();

        gr = runEndOfDayUsing(first, second);

        assertItem(gr.items[0], 0, 1);
        assertItem(gr.items[1], 14, 9);
    }

    @Test
    public void Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        gr = runEndOfDayUsing(Create.item().name("Item Name").sellIn(0).quality(5).obj());
        assertItem(gr.items[0], -1, 3);
    }

    @Test
    public void The_quality_of_an_item_is_never_negative() {
        gr = runEndOfDayUsing(Create.item().name("Item Name").sellIn(1).quality(0).obj());
        assertItem(this.gr.items[0], 0, 0);
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_the_older_it_gets() {
        gr = runEndOfDayUsing(Create.item().name("Aged Brie").sellIn(1).quality(5).obj());
        assertEquals(6, gr.items[0].quality);
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_twice_as_fast_after_the_sell_in_is_passed() {
        gr = runEndOfDayUsing(Create.item().name("Aged Brie").quality(5).obj());
        assertEquals(7, gr.items[0].quality);
    }

    private GildedRose runEndOfDayUsing(Item...items) {
        gr = new GildedRose(items);
        gr.processEndOfDayUpdates();
        return gr;
    }

    private void assertItem(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
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
