package com.gildedrose.builder;

import com.gildedrose.Item;

public class Create {

    private String itemName = "Item Name";
    private int itemSellIn = 1;
    private int itemQuality = 1;

    public static Create item() {
        return new Create();
    }

    public Create name(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Create sellIn(int itemSellIn) {
        this.itemSellIn = itemSellIn;
        return this;
    }

    public Create quality(int itemQuality) {
        this.itemQuality = itemQuality;
        return this;
    }

    public Item obj() {
        return new Item(itemName, itemSellIn, itemQuality);
    }

    public Create isExpired() {
        this.sellIn(0);
        return this;
    }
}
