package org.example.demos.interfaces;

// L'interface permet de "regrouper" des classes qui n'ont pas de lien entre elles (ex : Formes + Batiment...)
public interface Calculable {

    // Il est possible de déclarer des attributs, qui seront alors des constantes (peu utilisé)

    // Les déclarations classiques des méthodes n'ont pas de visibilité ni d'implémentation
    double calculerAire();

    // On peut définir des méthodes par défaut, qui seront implémentées ; on ne sera pas obligé de l'implémenter dans les classes (peu utilisé)
    default double calculerPerimetre() {
        return 0.0;
    }
}
