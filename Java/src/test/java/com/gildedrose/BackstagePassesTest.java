package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackstagePassesTest {
    @Test
    public void Backstage_passes_increases_in_quality_as_its_sell_in_value_approaches() {
        CatalogItem item = Create.backstagePasses().sellIn(100).quality(10).obj();
        item.process();

        assertEquals(11, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_as_its_sell_in_value_approaches_but_cannot_exceed_50() {
        CatalogItem item = Create.backstagePasses().sellIn(100).quality(50).obj();
        item.process();

        assertEquals(50, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_twice_as_fast_when_within_10_days() {
        CatalogItem item = Create.backstagePasses().sellIn(10).quality(10).obj();
        item.process();

        assertEquals(12, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_three_times_as_fast_when_within_5_days() {
        CatalogItem item = Create.backstagePasses().sellIn(5).quality(10).obj();
        item.process();

        assertEquals(13, item.quality());
    }

    @Test
    public void Backstage_passes_quality_goes_to_zero_after_the_show() {
        CatalogItem item = Create.backstagePasses().isExpired().obj();
        item.process();

        assertEquals(0, item.quality());
    }

}
