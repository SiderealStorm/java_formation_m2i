package org.example.exo.exo5;

import org.example.exo.exo5.exception.MaxQualityException;
import org.example.exo.exo5.exception.NegativeQualityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {

    private Product product;
    private Shop shop;

    public void init(int sellIn, int quality, String name, String category) {
        shop = new Shop();
        product = new Product(sellIn, quality, name, category);
    }

    // Correction : on vérifie d'abord que les DEUX paramètres baissent
    @Test
    public void testUpdateShouldDecreaseQuality() {
        // Arrange
        init(3, 50, "blanc de poulet", "viande");

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(49, product.getQuality());
    }

    @Test
    public void testUpdateShouldDecreaseSellIn() {
        // Arrange
        init(3, 50, "blanc de poulet", "viande");

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(2, product.getSellIn());
    }


    @Test
    public void testUpdateShouldDecreaseQualityTwiceWhenSellInIs0() {
        init(0, 50, "blanc de poulet", "viande");
        shop.update(product);
        Assertions.assertEquals(48, product.getQuality());
    }

    // Correction : ajout du cas où le produit est déjà négatif
    @Test
    public void testUpdateQualityShouldNotBeNegativeWhenNegative() {
        init(5, -1, "blanc de poulet", "viande");
        Assertions.assertThrowsExactly(NegativeQualityException.class, () -> shop.update(product));
    }

    @Test
    public void testUpdateQualityShouldNotBecomeNegativeWhenDecreasing() {
        init(0, 0, "blanc de poulet", "viande");
        shop.update(product);
        Assertions.assertEquals(0, product.getQuality());
    }

    @Test
    public void testUpdateShouldThrowExceptionWhenQualityIsAbove50() {
        init(5, 51, "blanc de poulet", "viande");
        Assertions.assertThrowsExactly(MaxQualityException.class, () -> shop.update(product));
    }

    @Test
    public void testUpdateShouldIncreaseQualityWhenProductIsBrie() {
        init(5, 40, "brie vieilli", "laitier");
        shop.update(product);
        Assertions.assertEquals(41, product.getQuality());
    }

    @Test
    public void testUpdateShouldNotIncreaseQualityWhenQualityIs50ProductIsBrie() {
        init(5, 50, "brie vieilli", "laitier");
        shop.update(product);
        Assertions.assertEquals(50, product.getQuality());
    }

    @Test
    public void testUpdateShouldDecreaseQualityTwiceWhenProductIsLaitier() {
        init(5, 50, "yaourt", "laitier");
        shop.update(product);
        Assertions.assertEquals(48, product.getQuality());
    }

    @Test
    public void testUpdateShouldDecreaseQualityBy4WhenSellInIs0AndProductIsLaitier() {
        init(0, 50, "yaourt", "laitier");
        shop.update(product);
        Assertions.assertEquals(46, product.getQuality());
    }
}
