package org.example.exos.exo4;

public class WaterTank {

    private double netWeight;
    private int maxCapacity;
    private double level;

    private static double totalVolume;

    public WaterTank() {}

    public WaterTank(double netWeight, int maxCapacity) {
        this.netWeight = netWeight;
        this.maxCapacity = maxCapacity;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public static double getTotalVolume() {
        return totalVolume;
    }

    // On ne permet pas de changer le poids à vide, la capacité maximum et le volume total, donc pas de setters

    // On ajoute un calcul du poids de la cuve :
    public double getWeight() {
        return this.netWeight + this.level;
    }

    @Override
    public String toString() {
        return "Citerne : " + level + "/" + maxCapacity + " L ; poids à vide : " + netWeight + " kg ; poids total : " + getWeight() + " kg";
    }

    public void fill(double volume) {
        if (level + volume <= maxCapacity) {
           level += volume;
           totalVolume += volume;
        } else {
            System.out.println("La cuve est pleine, " + (maxCapacity - volume) + " L d'eau n'ont pas pû être ajoutés");
            totalVolume += maxCapacity - level;
            level = maxCapacity;
        }
    }

    public void empty(double volume) {
        if (level - volume >= 0) {
            level -= volume;
            totalVolume -= volume;
        } else {
            System.out.println("La cuve est vide, " + (volume - level) + " L d'eau n'ont pas pû être retirés");
            totalVolume -= level;
            level = 0;
        }
    }

}
