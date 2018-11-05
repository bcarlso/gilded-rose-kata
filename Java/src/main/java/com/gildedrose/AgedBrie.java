package com.gildedrose;

public class AgedBrie extends CatalogItem {

    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    public AgedBrie(String itemName, int itemSellIn, int itemQuality) {
        this(new Item(itemName, itemSellIn, itemQuality));
    }

    public void process() {
        int appreciation = item.sellIn > 0 ? APPRECIATION_RATE : APPRECIATION_RATE * 2;
        increaseQualityBy(appreciation);
        decreaseSellIn();
    }

}
