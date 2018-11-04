package com.gildedrose;

public abstract class EndOfDayItemProcessor {
    public static final int QUALITY_CEILING = 50;
    protected Item item;

    public EndOfDayItemProcessor(Item item) {
        this.item = item;
    }

    public abstract void process();

    protected void decreaseSellIn() {
        this.item.sellIn--;
    }

    protected void increaseQuality() {
        if (this.item.quality < QUALITY_CEILING)
            this.item.quality++;
    }
}
