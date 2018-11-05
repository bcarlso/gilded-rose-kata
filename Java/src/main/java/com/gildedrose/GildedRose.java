package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {

    Item[] items;
    private final List<EndOfDayItemProcessor> itemProcessors;

    public GildedRose(Item[] items) {
        this.items = items;
        itemProcessors = new ArrayList<>(items.length);
        for (Item i : items) {
            if (Sulfras.SULFURAS.equals(i.name))
                itemProcessors.add(new Sulfras(i));
            else if (AgedBrie.AGED_BRIE.equals(i.name))
                itemProcessors.add(new AgedBrie(i));
            else if (BackstagePasses.BACKSTAGE_PASSES.equals(i.name))
                itemProcessors.add(new BackstagePasses(i));
            else
                itemProcessors.add(new StandardItem(i));
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
