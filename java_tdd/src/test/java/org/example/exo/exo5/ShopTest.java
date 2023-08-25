package org.example.exo.exo5;

import org.example.exo.exo5.exception.MaxQualityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {

    private Product product;
    private Product result;
    private Shop shop;

    public void init(int sellIn, int quality, String name, String category) {
        shop = new Shop();
        product = new Product(sellIn, quality, name, category);
    }

    @Test
    public void testUpdateSellInShouldBe2AndQuality49WhenSellInIs3AndQualityIs50() {
        // Arrange
        init(3, 50, "blanc de poulet", "viande");

        // Act
        result = shop.update(product);

        // Assert
        Assertions.assertEquals(49, result.getQuality());
    }

    @Test
    public void testUpdateQualityShouldBe48WhenSellInIs0AndQualityIs50() {
        init(0, 50, "blanc de poulet", "viande");
        result = shop.update(product);
        Assertions.assertEquals(48, result.getQuality());
    }

    @Test
    public void testUpdateQualityShouldNotBeNegativeWhenQualityIs0() {
        init(5, 0, "blanc de poulet", "viande");
        result = shop.update(product);
        Assertions.assertFalse(result.getQuality() < 0);
    }

    @Test
    public void testUpdateQualityShouldNotBeNegativeWhenSellInIs0QualityIs0() {
        init(0, 0, "blanc de poulet", "viande");
        result = shop.update(product);
        Assertions.assertFalse(result.getQuality() < 0);
    }


    @Test
    public void testUpdateShouldThrowExceptionWhenQualityIsAbove50() {
        init(5, 51, "blanc de poulet", "viande");
        Assertions.assertThrowsExactly(MaxQualityException.class, () -> shop.update(product));
    }

    @Test
    public void testUpdateQualityShouldBe41WhenQualityIs40AndProductIsBrie() {
        init(5, 40, "brie vieilli", "laitier");
        result = shop.update(product);
        Assertions.assertEquals(41, result.getQuality());
    }

    @Test
    public void testUpdateQualityShouldBe48WhenQualityIs50AndProductIsLaitier() {
        init(5, 50, "yaourt", "laitier");
        result = shop.update(product);
        Assertions.assertEquals(48, result.getQuality());
    }

    @Test
    public void testUpdateQualityShouldBe46WhenSellInIs0AndQualityIs50AndProductIsLaitier() {
        init(0, 50, "yaourt", "laitier");
        result = shop.update(product);
        Assertions.assertEquals(46, result.getQuality());
    }
}
