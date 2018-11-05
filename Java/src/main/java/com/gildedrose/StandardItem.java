package com.gildedrose;

public class StandardItem extends CatalogItem {
    public static final int WORTHLESS = 0;
    public static final int STANDARD_DEPRECIATION = 1;

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void process() {
        decreaseSellIn();

        if (sellInHasPassed()) {
            decreaseQualityOf(STANDARD_DEPRECIATION * 2);
        } else
            decreaseQualityOf(STANDARD_DEPRECIATION);
    }

    private void decreaseQualityOf(int amount) {
        if (item.quality > WORTHLESS)
            item.quality -= amount;
    }
}
