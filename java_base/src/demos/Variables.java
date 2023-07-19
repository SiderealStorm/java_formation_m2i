package demos;

public class Variables {
    public static void main(String[] args) {

        // Déclaration d'une variable : Type nomVariable

        // entier sur 32 bits
        int age;

        // entier sur 64 bits
        long indice;

        // décimal "court"
        float distance;

        // décimal "long"
        double monnaie;

        // booléen
        boolean estVrai;

        // caractère
        char lettre;

        // chaîne de caractères
        // Remarque : ce n'est PAS un type primitif !
        String prenom;


        // Déclaration + initialisation : Type nomVariable = valeur

        int jour = 5;


        // Affectation : on utilise le symbole d'affectation (=)

        age = 29;
        indice = 100_000_000;
        distance = 12.74f;
        monnaie = 15.5;
        estVrai = false;
        lettre = 'é';
        prenom = "Storm";


        // Les variables génèrent des Warnings si elles ne sont jamais utilisées ; le nom de variable reste gris

        String texte = "Variable jamais utilisée";


        // types enum ; point virgule non nécessaire mais ne génère pas d'erreur

        // Déclaration : (se déclare normalement dans un fichier à part)
        enum JourSemaine {
            Lundi, Mardi, Mercredi, Jeudi, Vendredi
        }

        // Affectation :
        JourSemaine aujourdhui = JourSemaine.Mardi;


        // Tableaux

        int[] test = {1, 2, 8, 7, 5};


        // Quelques exemples

        double resultat = age + monnaie;
        System.out.println(resultat);

        System.out.println(prenom + " a " + age + " ans.");

        System.out.println("Nous sommes " + aujourdhui);
        System.out.println("Nous sommes " + aujourdhui + ", il fait beau, et ce texte dépasse de la fenêtre de l'IDE car je ne trouve pas le word wrapping !");

    }
}
