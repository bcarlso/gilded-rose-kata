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

            if (qualityIncreasesWithAgeFor(item)) {
                handleItemWithIncreasingQuality(item);
            } else {
                if (hasQuality(item)) {
                        decreaseQualityOf(item);
                }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (AGED_BRIE.equals(item.name)) {
                    increaseQualityOf(item);
                } else {
                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        item.quality = 0;
                    } else {
                        if (hasQuality(item)) {
                            decreaseQualityOf(item);
                        }
                    }
                }
            }
        }
    }

    private boolean qualityIncreasesWithAgeFor(Item item) {
        return AGED_BRIE.equals(item.name) || BACKSTAGE_PASSES.equals(item.name);
    }

    private void decreaseQualityOf(Item item) {
        item.quality--;
    }

    private void handleItemWithIncreasingQuality(Item item) {
        if (AGED_BRIE.equals(item.name))
            increaseQualityOf(item);

        if (BACKSTAGE_PASSES.equals(item.name)) {
            increaseQualityOf(item);
            if (item.sellIn < 11) {
                increaseQualityOf(item);
            }

            if (item.sellIn < 6) {
                increaseQualityOf(item);
            }
        }
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < QUALITY_CEILING)
            item.quality++;
    }

    private boolean hasQuality(Item item) {
        return item.quality > QUALITY_FLOOR;
    }
}
