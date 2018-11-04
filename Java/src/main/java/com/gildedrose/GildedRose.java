package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int QUALITY_FLOOR = 0;
    public static final int QUALITY_CEILING = 50;
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
                increaseQualityOf(item);
                if (item.sellIn <= 0)
                    increaseQualityOf(item);
                decreaseSellInFor(item);
                continue;
            }

            if (BACKSTAGE_PASSES.equals(item.name)) {
                increaseQualityOf(item);

                if (item.sellIn < 11) {
                    increaseQualityOf(item);
                }

                if (item.sellIn < 6) {
                    increaseQualityOf(item);
                }

                decreaseSellInFor(item);

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                continue;
            }

            if (hasQuality(item)) {
                decreaseQualityOf(item);
            }

            decreaseSellInFor(item);

            if (item.sellIn < 0) {
                if (hasQuality(item)) {
                    decreaseQualityOf(item);
                }
            }


        }
    }

    private void decreaseSellInFor(Item item) {
        item.sellIn--;
    }

    private void decreaseQualityOf(Item item) {
        item.quality--;
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < QUALITY_CEILING)
            item.quality++;
    }

    private boolean hasQuality(Item item) {
        return item.quality > QUALITY_FLOOR;
    }
}
