package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConjuredTest {
    @Test
    public void Degrades_in_quality_twice_as_fast_as_normal_items_when_sell_in_not_expired() {
        CatalogItem item = Create.conjured().sellIn(1).quality(4).obj();
        item.processEoD();

        assertEquals(0, item.sellIn());
        assertEquals(2, item.quality());
    }

    @Test
    public void Degrades_in_quality_four_times_as_fast_as_normal_items_when_sell_in_is_expired() {
        CatalogItem item = Create.conjured().sellIn(0).quality(4).obj();
        item.processEoD();

        assertEquals(-1, item.sellIn());
        assertEquals(0, item.quality());
    }

}
