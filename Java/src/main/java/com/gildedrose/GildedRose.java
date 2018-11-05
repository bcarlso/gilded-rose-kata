package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {

    Item[] items;
    private final EndOfDayItemProcessor[] itemProcessors;

    public GildedRose(Item[] items) {
        this.items = items;
        itemProcessors = new EndOfDayItemProcessor[items.length];
        for (int i = 0; i < items.length; i++) {
            if (Sulfras.SULFURAS.equals(items[i].name))
                itemProcessors[i] = (new Sulfras(items[i]));
            else if (AgedBrie.AGED_BRIE.equals(items[i].name))
                itemProcessors[i] = (new AgedBrie(items[i]));
            else if (BackstagePasses.BACKSTAGE_PASSES.equals(items[i].name))
                itemProcessors[i] = (new BackstagePasses(items[i]));
            else
                itemProcessors[i] = (new StandardItem(items[i]));
        }
    }

    public void processEndOfDayUpdates() {
        for (EndOfDayItemProcessor ip : itemProcessors) {
            ip.process();
        }
    }

    public Item item(int i) {
        return items[i];
    }

    int getSellInForItem(int i) {
        return item(i).sellIn;
    }

    int getQualityForItem(int i) {
        return item(i).quality;
    }
}
