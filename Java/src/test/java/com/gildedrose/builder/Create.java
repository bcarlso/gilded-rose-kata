package com.gildedrose.builder;

import com.gildedrose.*;

public class Create {

    private String itemName = "Item Name";
    private int itemSellIn = 1;
    private int itemQuality = 1;

    public static Create item() {
        return new Create();
    }

    public static Create standardItem() {
        return item();
    }

    public static Create agedBrie() {
        Create item = item();
        item.name(AgedBrie.AGED_BRIE);
        return item;
    }

    public static Create sulfuras() {
        Create item = item();
        item.name(Sulfuras.SULFURAS);
        return item;
    }

    public static Create backstagePasses() {
        Create item = item();
        item.name(BackstagePasses.BACKSTAGE_PASSES);
        return item;
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

    public EndOfDayItemProcessor obj() {
        if(AgedBrie.AGED_BRIE.equals(itemName))
            return new AgedBrie(itemName, itemSellIn, itemQuality);

        if(Sulfuras.SULFURAS.equals(itemName))
            return new Sulfuras(itemName, itemSellIn, itemQuality);

        if(BackstagePasses.BACKSTAGE_PASSES.equals(itemName))
            return new BackstagePasses(itemName, itemSellIn, itemQuality);

        return new StandardItem(itemName, itemSellIn, itemQuality);
    }

    public Create isExpired() {
        this.sellIn(0);
        return this;
    }

}
