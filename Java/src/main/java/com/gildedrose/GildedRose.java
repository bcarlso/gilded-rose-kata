package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void processEndOfDayUpdates() {
        for (Item item : items) {
            if (SULFURAS.equals(item.name)) {
                continue;
            }

            if (AGED_BRIE.equals(item.name)) {
                new AgedBrie(item).invoke();
                continue;
            }

            if (BACKSTAGE_PASSES.equals(item.name)) {
                new BackstagePasses(item).invoke();
                continue;
            }

            new StandardItem(item).invoke();
        }
    }

}
