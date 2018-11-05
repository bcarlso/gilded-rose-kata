package com.gildedrose;

public abstract class DepreciatingCatalogItem extends CatalogItem {
    protected static final int WORTHLESS = 0;
    protected static final int STANDARD_DEPRECIATION = 1;

    protected DepreciatingCatalogItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void decreaseQualityBy(int amount) {
        if (item.quality > WORTHLESS)
            item.quality -= amount;
    }
}
