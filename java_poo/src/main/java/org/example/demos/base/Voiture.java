package org.example.demos.base;

public class Voiture {

    // Attributs d'instance ; syntaxe : visibilité type nom;

    // public = accessible en dehors de la classe
    public String couleur;
    public int carburant;
    public int puissance;

    // private = accessible uniquement dans la classe
    private String marque;

    // protected = accessible dans la classe et les classes enfants
    protected int nbPortes;


    // Constructeurs : définissent comment construire les objets de la classe

    // Définir un constructeur écrase le constructeur par défaut
    public Voiture(String couleur, int carburant, int puissance, String marque, int nbPortes) {
        // Le mot-clé "this" permet d'éviter l'ambiguité en désignant l'attribut de l'objet
        this.couleur = couleur;
        this.carburant = carburant;
        this.puissance = puissance;
        this.marque = marque;
        this.nbPortes = nbPortes;
        // Message pour l'exemple
        System.out.println("Utilisation du constructeur avec paramètres");
    }

    // Constructeur vide (par défaut) : toujours utile donc à ré-implémenter
    public Voiture() {
        // Message pour l'exemple
        System.out.println("Utilisation du constructeur vide");
    }

    // On peut créer autant de constructeurs que nécessaire à condition que leur signature soit différente (polymorphisme)
    public Voiture(String couleur) {
        this.couleur = couleur;
        // Message pour l'exemple
        System.out.println("Utilisation du constructeur avec la couleur");
    }

    // Il est possible d'appeler un constructeur dans un constructeur...
    public Voiture(String couleur, int carburant, int puissance) {
        // Syntaxe d'appel d'un constructeur dans la classe : this(paramètres);
        this(couleur);
        this.carburant = carburant;
        this.puissance = puissance;
        // Message pour l'exemple
        System.out.println("Utilisation du constructeur avec appel à un autre constructeur");
    }


    // Méthodes d'instance ; syntaxe : visibilité typeRetour nom(paramètres)

    public void demarrer() {
        if (carburant > 0) {
            System.out.println("La voiture démarre");
        } else {
            System.out.println("La voiture ne peut pas démarrer, il n'y a plus de carburant");
        }
    }

    public void freiner() {
        System.out.println("La voiture freine");
    }

    public void faireLePlein(int volume) {
        carburant += volume;
    }

    // Pas besoin d'attribut "puissance fiscale" car elle dépend directement d'un attribut existant (puissance)
    public double puissanceFiscale() {
        return puissance / 7.;
    }

    // Redéfinir la méthode toString() avec l'annotation "Override"
    @Override
    public String toString() {
        return "Détails de la voiture :\n" + "couleur : " + couleur + ", carburant : " + carburant + " litres, puissance : " + puissance + " chevaux, marque : " + marque + ", nombre de portes : " + nbPortes + ".";
    }
}
