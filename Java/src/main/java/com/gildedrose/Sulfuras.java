package com.gildedrose;

public class Sulfuras extends EndOfDayItemProcessor {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super(item);
    }

    public Sulfuras(String name, int sellIn, int quality) {
        this(new Item(name, sellIn, quality));
    }

    @Override
    public void process() {
        ;
    }
}
