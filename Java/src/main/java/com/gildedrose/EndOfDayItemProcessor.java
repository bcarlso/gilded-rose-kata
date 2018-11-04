package com.gildedrose;

public abstract class EndOfDayItemProcessor {
    public static final int QUALITY_CEILING = 50;
    public static final int APPRECIATION_RATE = 1;
    protected Item item;

    public EndOfDayItemProcessor(Item item) {
        this.item = item;
    }

    public abstract void process();

    protected void decreaseSellIn() {
        this.item.sellIn--;
    }

    protected void increaseQualityBy(int value) {
        if (this.item.quality < QUALITY_CEILING)
            this.item.quality = this.item.quality + value;
    }
}