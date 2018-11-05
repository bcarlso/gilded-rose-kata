package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogItemTest {
    @Test
    public void All_items_have_a_sell_in_value_which_denotes_the_number_of_days_we_have_to_sell_the_item() {
        CatalogItem item = new TestableCatalogItem(null, 5, 0);
        assertEquals(5, item.sellIn());
    }

    @Test
    public void All_items_have_a_quality_value_which_denotes_how_valuable_the_item_is() {
        CatalogItem item = new TestableCatalogItem(null, 0, 50);
        assertEquals(50, item.quality());
    }

    public class TestableCatalogItem extends CatalogItem {

        public TestableCatalogItem(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        @Override
        public void process() {
            ;
        }
    }
}
