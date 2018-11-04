package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int QUALITY_FLOOR = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void processEndOfDayUpdates() {
        for (Item item : items) {
            if (SULFURAS.equals(item.name)) {
                continue;
            }

            if (AGED_BRIE.equals(item.name)) {
                new AgedBrie(item).invoke();
                continue;
            }

            if (BACKSTAGE_PASSES.equals(item.name)) {
                new BackstagePasses(item).invoke();
                continue;
            }

            new StandardItem(item).invoke();
        }
    }

    private class AgedBrie extends BaseItem {

        public AgedBrie(Item item) {
            super(item);
        }

        public void invoke() {
            increaseQualityOf(item);
            if (item.sellIn <= 0)
                increaseQualityOf(item);
            decreaseSellInFor(item);
        }
    }

    private class BackstagePasses extends BaseItem {
        public BackstagePasses(Item item) {
            super(item);
        }

        public void invoke() {
            increaseQualityOf(item);

            if (item.sellIn < 11) {
                increaseQualityOf(item);
            }

            if (item.sellIn < 6) {
                increaseQualityOf(item);
            }

            decreaseSellInFor(item);

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }

    private class StandardItem extends BaseItem {
        public StandardItem(Item item) {
            super(item);
        }

        @Override
        public void invoke() {
            if (hasQuality(item)) {
                decreaseQualityOf(item);
            }

            decreaseSellInFor(item);

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
}
