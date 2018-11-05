package com.gildedrose;

public abstract class AppreciatingCatalogItem extends CatalogItem {
    protected static final int QUALITY_CEILING = 50;
    protected static final int APPRECIATION_RATE = 1;

    public AppreciatingCatalogItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void increaseQualityBy(int value) {
        if (this.item.quality < QUALITY_CEILING)
            this.item.quality += value;
    }
}
