package com.gildedrose;

class AgedBrie extends EndOfDayItemProcessor {

    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    public void process() {
        increaseQuality();
        if (item.sellIn <= 0)
            increaseQuality();
        decreaseSellIn();
    }
}
