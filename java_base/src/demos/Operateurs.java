package demos;

public class Operateurs {
    public static void main(String[] args) {

        // Opérateurs arithmétiques

        int result = 1 + 2;

        System.out.println("1 + 2 = " + result); // 1 + 2 = 3

        int originalResult = result;

        result = result - 1;
        System.out.println(originalResult + " - 1 = " + result); // 3 - 1 = 2

        originalResult = result;

        result = result * 2;
        System.out.println(originalResult + " * 2 = " + result); // 2 * 2 = 4

        originalResult = result;

        result = result / 2;
        System.out.println(originalResult + " / 1 = " + result); // 4 / 2 = 2

        originalResult = result;

        result = result % 2;
        System.out.println(originalResult + " % 2 = " + result); // 2 % 2 = 0

        // Affectations composées :

        result += 10;
        System.out.println(result); // 10


        // Opérateurs unaires

        int nombre = +1;

        System.out.println(nombre); // 1

        // opérateur de négation unaire :
        int autreNombre = -nombre;

        // opérateur de décrémentation :
        nombre--;
        System.out.println(nombre); // 0

        // opérateur d'incrémentation :
        nombre++;
        System.out.println(nombre); // 1

        // opérateurs préfixdés :

        int somme = nombre++ + --autreNombre;
        System.out.println(somme); // -1
        System.out.println(nombre); // 2
        System.out.println(autreNombre); // -2

        // opérateur Not :

        boolean success = false;

        System.out.println(success); // false
        System.out.println(!success); // true


        // Opérateurs de comparaison

        int value1 = 1;
        int value2 = 2;
        boolean resultat;

        resultat = value1 == value2;
        System.out.println(resultat); // false

        resultat = value1 != value2;
        System.out.println(resultat); // true

        resultat = value1 < value2;
        System.out.println(resultat); // false

        resultat = value1 >= value2;
        System.out.println(resultat); // true

        resultat = (value1 == 1) && (value2 == 2);
        System.out.println(resultat); // true

        resultat = (value1 == 1) || (value2 == 1);
        System.out.println(resultat); // true

    }
}
