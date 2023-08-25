package org.example.exo.exo5;

import org.example.exo.exo5.exception.MaxQualityException;

public class Shop {

    // Méthode avant Refactor
    public Product update(Product product) {
        if (product.getQuality() > 50) {
            throw new MaxQualityException();
        }

        product.setSellIn(product.getSellIn() - 1);

        if (product.getName().equals("brie vieilli")) {
            product.setQuality(product.getQuality() + 1);
        } else if (product.getCategory().equals("laitier")) {
            if (product.getSellIn() <= 0) {
                if (product.getQuality() > 4) {
                    product.setQuality(product.getQuality() - 4);
                }
            } else {
                if (product.getQuality() > 2) {
                    product.setQuality(product.getQuality() - 2);
                }
            }
        } else {
            if (product.getSellIn() <= 0) {
                if (product.getQuality() > 2) {
                    product.setQuality(product.getQuality() - 2);
                }
            } else {
                if (product.getQuality() > 1) {
                    product.setQuality(product.getQuality() - 1);
                }
            }
        }
            return product;
    }
}
