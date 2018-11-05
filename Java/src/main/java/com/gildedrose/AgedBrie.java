package com.gildedrose;

public class AgedBrie extends AppreciatingCatalogItem {

    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(String itemName, int itemSellIn, int itemQuality) {
        super(itemName, itemSellIn, itemQuality);
    }

    public void process() {
        int appreciation = item.sellIn > 0 ? APPRECIATION_RATE : APPRECIATION_RATE * 2;
        increaseQualityBy(appreciation);
        decreaseSellIn();
    }

}
