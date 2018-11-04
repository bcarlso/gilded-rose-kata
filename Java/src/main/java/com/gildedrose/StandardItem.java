package com.gildedrose;

class StandardItem extends EndOfDayItemProcessor {
    public static final int QUALITY_FLOOR = 0;

    public StandardItem(Item item) {
        super(item);
    }

    @Override
    public void process() {
        if (hasQuality(item)) {
            decreaseQualityOf(item);
        }

        decreaseSellIn();

        if (item.sellIn < 0) {
            if (hasQuality(item)) {
                decreaseQualityOf(item);
            }
        }
    }

    private boolean hasQuality(Item item) {
        return item.quality > QUALITY_FLOOR;
    }

    private void decreaseQualityOf(Item item) {
        item.quality--;
    }
}
