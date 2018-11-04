package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.builder.Create;
import org.junit.Test;

public class GildedRoseTest {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
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

        assertEquals(0, gr.items[0].sellIn);
        assertEquals(1, gr.items[0].quality);

        assertEquals(14, gr.items[1].sellIn);
        assertEquals(9, gr.items[1].quality);
    }

    @Test
    public void Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        gr = runEndOfDayUsing(Create.item().isExpired().quality(5).obj());
        assertEquals(3, gr.items[0].quality);
    }

    @Test
    public void The_quality_of_an_item_is_never_negative() {
        gr = runEndOfDayUsing(Create.item().sellIn(1).quality(0).obj());
        assertEquals(0, this.gr.items[0].quality);
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_the_older_it_gets() {
        gr = runEndOfDayUsing(Create.item().name(AGED_BRIE).sellIn(1).quality(5).obj());
        assertEquals(6, gr.items[0].quality);
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_twice_as_fast_after_the_sell_in_is_passed() {
        gr = runEndOfDayUsing(Create.item().name(AGED_BRIE).isExpired().quality(5).obj());
        assertEquals(7, gr.items[0].quality);
    }

    @Test
    public void The_quality_of_Aged_Brie_is_never_more_than_50() {
        gr = runEndOfDayUsing(Create.item().name(AGED_BRIE).quality(50).obj());
        assertEquals(50, gr.items[0].quality);
    }

    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_sold_or_decreases_in_quality() {
        gr = runEndOfDayUsing(Create.item().name("Sulfuras, Hand of Ragnaros").sellIn(8).quality(10).obj());

        assertEquals(8, gr.items[0].sellIn);
        assertEquals(10, gr.items[0].quality);
    }

    @Test
    public void Backstage_passes_increases_in_quality_as_its_sell_in_value_approaches() {
        gr = runEndOfDayUsing(Create.item().name(BACKSTAGE_PASSES).sellIn(100).quality(10).obj());
        assertEquals(11, gr.items[0].quality);
    }

    @Test
    public void Backstage_passes_increases_in_quality_as_its_sell_in_value_approaches_but_cannot_exceed_50() {
        gr = runEndOfDayUsing(Create.item().name(BACKSTAGE_PASSES).sellIn(100).quality(50).obj());
        assertEquals(50, gr.items[0].quality);
    }

    @Test
    public void Backstage_passes_increases_in_quality_twice_as_fast_when_within_10_days() {
        gr = runEndOfDayUsing(Create.item().name(BACKSTAGE_PASSES).sellIn(10).quality(10).obj());
        assertEquals(12, gr.items[0].quality);
    }

    @Test
    public void Backstage_passes_increases_in_quality_three_times_as_fast_when_within_5_days() {
        gr = runEndOfDayUsing(Create.item().name(BACKSTAGE_PASSES).sellIn(5).quality(10).obj());
        assertEquals(13, gr.items[0].quality);
    }

    @Test
    public void Backstage_passes_quality_goes_to_zero_after_the_show() {
        gr = runEndOfDayUsing(Create.item().name(BACKSTAGE_PASSES).isExpired().obj());
        assertEquals(0, gr.items[0].quality);
    }

    private GildedRose runEndOfDayUsing(Item...items) {
        gr = new GildedRose(items);
        gr.processEndOfDayUpdates();
        return gr;
    }

}