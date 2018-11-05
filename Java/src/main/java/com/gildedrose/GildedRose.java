package com.gildedrose;

class GildedRose {

    private final CatalogItem[] items;

    public GildedRose(CatalogItem...items) {
        this.items = items;
    }

    public void processEndOfDayUpdates() {
        for (CatalogItem ip : items) {
            ip.processEoD();
        }
    }

    public CatalogItem item(int i) {
        return items[i];
    }

}
