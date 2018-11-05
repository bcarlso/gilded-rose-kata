package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgedBrieTest {
    @Test
    public void Aged_Brie_actually_increases_in_quality_the_older_it_gets() {
        CatalogItem item = Create.agedBrie().sellIn(1).quality(5).obj();
        item.process();
        assertEquals(6, item.quality());
    }

    @Test
    public void Aged_Brie_actually_increases_in_quality_twice_as_fast_after_the_sell_in_is_passed() {
        CatalogItem item = Create.agedBrie().isExpired().quality(5).obj();
        item.process();
        assertEquals(7, item.quality());
    }

    @Test
    public void The_quality_of_Aged_Brie_is_never_more_than_50() {
        CatalogItem item = Create.agedBrie().quality(50).obj();
        item.process();

        assertEquals(50, item.quality());
    }


}
