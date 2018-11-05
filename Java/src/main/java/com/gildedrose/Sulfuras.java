package com.gildedrose;

public class Sulfuras extends CatalogItem {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Sulfuras() {
        this(SULFURAS, Integer.MAX_VALUE, 80);
    }

    @Override
    public void processEoD() {
        ;
    }
}
