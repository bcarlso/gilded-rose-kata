package com.gildedrose;

public class BackstagePasses extends CatalogItem {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int WORTHLESS = 0;

    public BackstagePasses(Item item) {
        super(item);
    }

    public BackstagePasses(String name, int sellIn, int quality) {
        this(new Item(name, sellIn, quality));
    }

    public void process() {

        if (concertWithin(5))
            increaseQualityBy(APPRECIATION_RATE * 3);
        else if (concertWithin(10))
            increaseQualityBy(APPRECIATION_RATE * 2);
        else
            increaseQualityBy(APPRECIATION_RATE);

        decreaseSellIn();

        if (sellInHasPassed()) {
            item.quality = WORTHLESS;
        }
    }

    private boolean concertWithin(int days) {
        return item.sellIn <= days;
    }

}
