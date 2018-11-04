package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void processEndOfDayUpdates() {
        for (Item item : items) {
            if (Sulfras.SULFURAS.equals(item.name)) {
                new Sulfras(item).process();
                continue;
            }

            if (AgedBrie.AGED_BRIE.equals(item.name)) {
                new AgedBrie(item).process();
                continue;
            }

            if (BackstagePasses.BACKSTAGE_PASSES.equals(item.name)) {
                new BackstagePasses(item).process();
                continue;
            }

            new StandardItem(item).process();
        }
    }

}
