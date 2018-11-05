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
}
