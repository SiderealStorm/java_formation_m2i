package org.example.demos.heritage;

// Un héritage est défini par le mot-clé extends
public class Chat extends Animal {

    private int nbVies;

    // Appel au constructeur de la classe parent avec super(paramètres)
    public Chat(String nom, int age, String couleur, int nbVies) {
        super(nom, age, couleur);
        this.nbVies = nbVies;
    }

    public int getNbVies() {
        return nbVies;
    }

    public void setNbVies(int nbVies) {
        this.nbVies = nbVies;
    }

    // On peut re-créer (= surcharger) les méthodes de la classe parent pour changer leur comportement, en utilisant l'annotation @Override
    @Override
    public void crier() {
        System.out.println("Miaou miaou");
    }

    // On peut ré-utiliser le comportement du parent en l'appelant grâce au mot-clé "super"
    @Override
    public void manger() {
        super.manger();
        System.out.println("Le chat mange des croquettes");
    }

    @Override
    public String toString() {
        return "Nom du chat : " + getNom() + " ; âge : " + getAge() + " ans (né en " + anneeNaissance() + ") ; vies restantes : " + nbVies;
    }

}
