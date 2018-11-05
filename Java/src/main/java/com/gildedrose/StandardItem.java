package com.gildedrose;

class StandardItem extends EndOfDayItemProcessor {
    public static final int WORTHLESS = 0;
    public static final int STANDARD_DEPRECIATION = 1;

    public StandardItem(Item item) {
        super(item);
    }

    @Override
    public void process() {
        decreaseSellIn();

        if (sellInHasPassed()) {
            decreaseQualityOf(STANDARD_DEPRECIATION * 2);
        } else
            decreaseQualityOf(STANDARD_DEPRECIATION);
    }

    private void decreaseQualityOf(int amount) {
        if (item.quality > WORTHLESS)
            item.quality -= amount;
    }
}
