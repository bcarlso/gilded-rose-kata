package com.gildedrose;

public class Conjured extends DepreciatingCatalogItem {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void processEoD() {
        decreaseSellIn();

        if (sellInHasPassed())
            decreaseQualityBy(STANDARD_DEPRECIATION * 4);
        else
            decreaseQualityBy(STANDARD_DEPRECIATION * 2);
    }
}
