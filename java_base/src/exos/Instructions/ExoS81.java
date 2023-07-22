package exos.Instructions;

/*
Exercice S81 : Population
1. L'accroissement de la population de Tourcoing est de 0.89%
2. En 2015 la ville comptait 96809 habitants
3. Combien d'années faut-il pour atteindre 120 000 habitants ?
4. Combien d'habitants y aura-t-il cette année-là ?
5. Écrire un programme permettant de résoudre ce problème
 */
public class ExoS81 {
    public static void main(String[] args) {
        double txAccroissement = 0.89;
        double popActuelle = 96_809;
        int popFinale = 120_000;
        int annee = 2015;

        while (popActuelle < popFinale) {
            popActuelle = popActuelle * (1 + txAccroissement/100);
            annee++;
        }

        System.out.printf("La population de Tourcoing dépassera les %d habitants en %d avec environ %.0f habitants", popFinale, annee, popActuelle);

    }
}
