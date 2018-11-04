package com.gildedrose;

class AgedBrie extends BaseItem {

    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    public void invoke() {
        increaseQuality();
        if (item.sellIn <= 0)
            increaseQuality();
        decreaseSellIn();
    }
}
