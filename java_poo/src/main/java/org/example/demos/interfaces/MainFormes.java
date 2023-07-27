package org.example.demos.interfaces;

public class MainFormes {
    public static void main(String[] args) {
        Cercle cercle = new Cercle("Cercle 1", 5.);
        Cercle autreCercle = new Cercle("Cercle 2", 2.);
        Rectangle rectangle = new Rectangle("Rectangle 1", 7., 4.);
        Rectangle autreRectangle = new Rectangle("Rectangle 2", 12., 6.);

        System.out.println("Aire du cercle 1 : " + cercle.calculerAire());
        System.out.println("Aire du rectangle 1 : " + rectangle.calculerAire());
        System.out.println();

        // Utilisation de la méthode statique
        System.out.println(Forme.compareAires(cercle, rectangle));
        System.out.println(Forme.compareAires(autreCercle, autreRectangle));
        System.out.println();

        // L'héritage et le polymorphisme permettent de rassembler des objets différents dans une collection :
        Forme[] formes = {cercle, autreCercle, rectangle, autreRectangle};
        for (Forme forme : formes) {
            forme.afficherDetails();
            System.out.println();
        }

        // Utilisation du polymorphisme pour calculer l'aire totale :
        double aireTotale = 0;
        for (Forme forme : formes) {
            aireTotale += forme.calculerAire();
        }
        System.out.println("Aire totale des formes du tableau : " + aireTotale);

        // On peut aussi déclarer un tableau d'objets qui implémentent la même interface :
        Maison maison = new Maison("Rouge", 78);
        double aireTotale2 = 0;

        Calculable[] objetsCalculables = {cercle, rectangle, maison, autreCercle, autreRectangle};
        for (Calculable element : objetsCalculables) {
            aireTotale2 += element.calculerAire();
        }
        System.out.println("Aire totale des formes du tableau 2 : " + aireTotale2);
        System.out.println();
        System.out.println("-----------------------------------");

        // On peut utiliser "instanceof" pour redéfinir l'objet du tableau dans son type
        for (Calculable element : objetsCalculables) {
            // Utilisation de "instanceof"
            if (element instanceof Forme) {
                // Cast de l'objet
                ((Forme) element).afficherDetails();
                System.out.println();
            } else {
                System.out.println(element);
                System.out.println();
            }
        }
    }
}
