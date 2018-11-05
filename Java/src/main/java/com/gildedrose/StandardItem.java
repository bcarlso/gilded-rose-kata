package com.gildedrose;

public class StandardItem extends DepreciatingCatalogItem {
    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void processEoD() {
        decreaseSellIn();

        if (sellInHasPassed()) {
            decreaseQualityBy(STANDARD_DEPRECIATION * 2);
        } else
            decreaseQualityBy(STANDARD_DEPRECIATION);
    }
}
