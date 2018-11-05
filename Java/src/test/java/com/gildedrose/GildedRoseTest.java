package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.builder.Create;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void At_the_end_of_each_day_our_system_performs_end_of_day_processing_on_every_item() {
        MockCatalogItem first = new MockCatalogItem();
        MockCatalogItem second = new MockCatalogItem();

        GildedRose gr = new GildedRose(first, second);
        gr.processEndOfDayUpdates();

        first.verifyEndOfDayProcessingWasCalled();
        second.verifyEndOfDayProcessingWasCalled();

    }

    class MockCatalogItem extends CatalogItem {

        private boolean endOfDayProcessingWasCalled;

        private MockCatalogItem(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        public MockCatalogItem() {
            this("Mock Item", 0, 0);
        }

        @Override
        public void processEoD() {
            this.endOfDayProcessingWasCalled = true;
        }

        public void verifyEndOfDayProcessingWasCalled() {
            assertTrue(this.endOfDayProcessingWasCalled);
        }
    }
}
