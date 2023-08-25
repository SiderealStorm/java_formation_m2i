package org.example.exo.exo5;

import org.example.exo.exo5.exception.MaxQualityException;
import org.example.exo.exo5.exception.NegativeQualityException;

public class Shop {

    // Méthode après Refactor
    public void update(Product product) {
        if (product.getQuality() > 50) {
            throw new MaxQualityException();
        } else if (product.getQuality() < 0) {
            throw new NegativeQualityException();
        }

        int decrease = 1;

        // Remarque : on peut ajouter la condition product.getName() != null
        // au cas où le nom de produit ne serait pas obligatoire
        if (product.getName().equals("brie vieilli")) {
            if (product.getQuality() == 50) {
                decrease = 0;
            } else {
                decrease = -1;
            }
        } else {
            // Même remarque que pour le nom
            if (product.getCategory().equals("laitier")) {
                decrease *= 2;
            }
            if (product.getSellIn() <= 0) {
                decrease *= 2;
            }
        }

        if (product.getQuality() >= decrease) {
            product.setQuality(product.getQuality() - decrease);
        } else {
            product.setQuality(0);
        }
        product.setSellIn(product.getSellIn() - 1);
    }


    // Méthode avant Refactor
    /*
    public void update(Product product) {
        if (product.getQuality() > 50) {
            throw new MaxQualityException();
        }
        if (product.getQuality() < 0) {
            throw new NegativeQualityException();
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
    }
     */
}
