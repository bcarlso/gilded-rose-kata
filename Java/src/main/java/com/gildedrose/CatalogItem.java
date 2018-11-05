package com.gildedrose;

public abstract class CatalogItem {
    public static final int QUALITY_CEILING = 50;
    public static final int APPRECIATION_RATE = 1;
    protected Item item;

    public CatalogItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public abstract void process();

    protected void decreaseSellIn() {
        this.item.sellIn--;
    }

    protected void increaseQualityBy(int value) {
        if (this.item.quality < QUALITY_CEILING)
            this.item.quality = this.item.quality + value;
    }

    protected boolean sellInHasPassed() {
        return item.sellIn < 0;
    }

    public int sellIn() {
        return item.sellIn;
    }

    public int quality() {
        return item.quality;
    }
}
