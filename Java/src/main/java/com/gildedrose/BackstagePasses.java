package com.gildedrose;

class BackstagePasses extends BaseItem {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(Item item) {
        super(item);
    }

    public void invoke() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }

        decreaseSellIn();

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
