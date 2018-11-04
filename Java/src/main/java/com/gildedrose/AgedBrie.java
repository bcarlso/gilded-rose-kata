package com.gildedrose;

class AgedBrie extends EndOfDayItemProcessor {

    public static final String AGED_BRIE = "Aged Brie";
    public static final int APPRECIATION_RATE = 1;

    public AgedBrie(Item item) {
        super(item);
    }

    public void process() {
        int appreciation = item.sellIn > 0 ? APPRECIATION_RATE : APPRECIATION_RATE * 2;
        increaseQualityBy(appreciation);
        decreaseSellIn();
    }

}
