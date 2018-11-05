package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardItemTest {
    @Test
    public void At_the_end_of_each_day_quality_is_reduced() {
        CatalogItem item = Create.standardItem().sellIn(1).quality(2).obj();
        item.process();

        assertEquals(1, item.quality());
    }

    @Test
    public void At_the_end_of_each_day_sell_in_days_are_reduced() {
        CatalogItem item = Create.standardItem().sellIn(1).quality(2).obj();
        item.process();

        assertEquals(0, item.sellIn());
    }

        @Test
    public void Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        CatalogItem item = Create.standardItem().isExpired().quality(5).obj();
        item.process();

        assertEquals(3, item.quality());
    }

    @Test
    public void The_quality_of_an_item_is_never_negative() {
        CatalogItem item = Create.standardItem().sellIn(1).quality(0).obj();
        item.process();

        assertEquals(0, item.quality());
    }

}
