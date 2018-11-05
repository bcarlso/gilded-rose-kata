package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {
    @Test
    public void Never_has_to_be_sold_or_decreases_in_quality() {
        CatalogItem item = Create.sulfuras().sellIn(8).quality(10).obj();
        item.process();

        assertEquals(8, item.sellIn());
        assertEquals(10, item.quality());
    }
}
