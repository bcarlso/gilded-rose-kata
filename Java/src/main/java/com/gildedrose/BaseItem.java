package com.gildedrose;

public abstract class BaseItem implements IItem {
    public static final int QUALITY_CEILING = 50;
    protected Item item;

    public BaseItem(Item item) {
        this.item = item;
    }

    protected void decreaseSellIn() {
        this.item.sellIn--;
    }

    protected void increaseQuality() {
        if (this.item.quality < QUALITY_CEILING)
            this.item.quality++;
    }
}
