package com.gildedrose;

class GildedRose {

    private final EndOfDayItemProcessor[] itemProcessors;

    public GildedRose(EndOfDayItemProcessor[] items) {
        itemProcessors = items;
    }

    public void processEndOfDayUpdates() {
        for (EndOfDayItemProcessor ip : itemProcessors) {
            ip.process();
        }
    }

    public EndOfDayItemProcessor item(int i) {
        return itemProcessors[i];
    }

    int getSellInForItem(int i) {
        return item(i).sellIn();
    }

    int getQualityForItem(int i) {
        return item(i).quality();
    }
}
