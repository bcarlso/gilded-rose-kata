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
        for (int i = 0; i < items.length; i++) {
            if (AGED_BRIE.equals(items[i].name) || BACKSTAGE_PASSES.equals(items[i].name)) {
                handleItemWithIncreasingQuality(items[i]);
            } else {
                if (hasQuality(items[i])) {
                    if (!SULFURAS.equals(items[i].name)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }

            if (!SULFURAS.equals(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!AGED_BRIE.equals(items[i].name)) {
                    if (!BACKSTAGE_PASSES.equals(items[i].name)) {
                        if (hasQuality(items[i])) {
                            if (!SULFURAS.equals(items[i].name)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < QUALITY_CEILING) {
                        increaseQualityOf(items[i]);
                    }
                }
            }
        }
    }

    private void handleItemWithIncreasingQuality(Item item) {
        if(AGED_BRIE.equals(item.name))
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
