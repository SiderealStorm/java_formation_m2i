package org.example.exo.exo5;

public class Product {

    private int sellIn;
    private int quality;
    private String name;
    private String category;

    public Product(int sellIn, int quality, String name, String category) {
        this.sellIn = sellIn;
        this.quality = quality;
        this.name = name;
        this.category = category;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
