package com.gildedrose;

class AgedBrie extends BaseItem {

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
