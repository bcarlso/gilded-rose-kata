package com.gildedrose;

public abstract class CatalogItem {
    protected Item item;
    public abstract void processEoD();
    public CatalogItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public int sellIn() {
        return item.sellIn;
    }

    public int quality() {
        return item.quality;
    }

    protected void decreaseSellIn() {
        this.item.sellIn--;
    }


    protected boolean sellInHasPassed() {
        return item.sellIn < 0;
    }
}
