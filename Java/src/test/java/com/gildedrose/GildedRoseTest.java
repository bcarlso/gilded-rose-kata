package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.builder.Create;
import org.junit.Test;

public class GildedRoseTest {

    private GildedRose gr;

    @Test
    public void All_items_have_a_sell_in_value_which_denotes_the_number_of_days_we_have_to_sell_the_item() {
        CatalogItem item = Create.standardItem().sellIn(5).obj();
        assertEquals(5, item.sellIn());
    }

    @Test
    public void All_items_have_a_quality_value_which_denotes_how_valuable_the_item_is() {
        CatalogItem item = Create.standardItem().quality(3).obj();
        assertEquals(3, item.quality());
    }

    @Test
    public void At_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
        CatalogItem first = Create.standardItem().sellIn(1).quality(2).obj();
        CatalogItem second = Create.standardItem().sellIn(15).quality(10).obj();

        gr = new GildedRose(new CatalogItem[]{first, second});
        gr.processEndOfDayUpdates();

        assertEquals(0, gr.item(0).sellIn());
        assertEquals(1, gr.item(0).quality());

        assertEquals(14, gr.item(1).sellIn());
        assertEquals(9, gr.item(1).quality());
    }

    @Test
    public void Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        gr = new GildedRose(new CatalogItem[]{Create.standardItem().isExpired().quality(5).obj()});
        gr.processEndOfDayUpdates();
        assertEquals(3, gr.item(0).quality());
    }

    @Test
    public void The_quality_of_an_item_is_never_negative() {
        gr = new GildedRose(new CatalogItem[]{Create.standardItem().sellIn(1).quality(0).obj()});
        gr.processEndOfDayUpdates();
        assertEquals(0, gr.item(0).quality());
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_the_older_it_gets() {
        gr = new GildedRose(new CatalogItem[]{Create.agedBrie().sellIn(1).quality(5).obj()});
        gr.processEndOfDayUpdates();
        assertEquals(6, gr.item(0).quality());
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_twice_as_fast_after_the_sell_in_is_passed() {
        gr = new GildedRose(new CatalogItem[]{Create.agedBrie().isExpired().quality(5).obj()});
        gr.processEndOfDayUpdates();
        assertEquals(7, gr.item(0).quality());
    }

    @Test
    public void The_quality_of_Aged_Brie_is_never_more_than_50() {
        gr = new GildedRose(new CatalogItem[]{Create.agedBrie().quality(50).obj()});
        gr.processEndOfDayUpdates();

        assertEquals(50, gr.item(0).quality());
    }

    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_sold_or_decreases_in_quality() {
        gr = new GildedRose(new CatalogItem[]{Create.sulfuras().sellIn(8).quality(10).obj()});
        gr.processEndOfDayUpdates();

        assertEquals(8, gr.item(0).sellIn());
        assertEquals(10, gr.item(0).quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_as_its_sell_in_value_approaches() {
        gr = new GildedRose(new CatalogItem[]{Create.backstagePasses().sellIn(100).quality(10).obj()});
        gr.processEndOfDayUpdates();

        assertEquals(11, gr.item(0).quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_as_its_sell_in_value_approaches_but_cannot_exceed_50() {
        gr = new GildedRose(new CatalogItem[]{Create.backstagePasses().sellIn(100).quality(50).obj()});
        gr.processEndOfDayUpdates();

        assertEquals(50, gr.item(0).quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_twice_as_fast_when_within_10_days() {
        gr = new GildedRose(new CatalogItem[]{Create.backstagePasses().sellIn(10).quality(10).obj()});
        gr.processEndOfDayUpdates();

        assertEquals(12, gr.item(0).quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_three_times_as_fast_when_within_5_days() {
        gr = new GildedRose(new CatalogItem[]{Create.backstagePasses().sellIn(5).quality(10).obj()});
        gr.processEndOfDayUpdates();

        assertEquals(13, gr.item(0).quality());
    }

    @Test
    public void Backstage_passes_quality_goes_to_zero_after_the_show() {
        gr = new GildedRose(new CatalogItem[]{Create.backstagePasses().isExpired().obj()});
        gr.processEndOfDayUpdates();

        assertEquals(0, gr.item(0).quality());
    }

}
