package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {
    @Test
    public void is_a_legendary_item_and_as_such_its_quality_is_80() {
        CatalogItem item = Create.sulfuras().obj();
        assertEquals(80, item.quality());
    }

    @Test
    public void Never_has_to_be_sold() {
        CatalogItem item = Create.sulfuras().obj();
        item.processEoD();
        assertEquals(Integer.MAX_VALUE, item.sellIn());
    }

    @Test
    public void Never_decreases_in_quality()
    {
        CatalogItem item = Create.sulfuras().sellIn(8).quality(10).obj();
        item.processEoD();

        assertEquals(80, item.quality());
    }
}
