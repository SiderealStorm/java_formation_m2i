package org.example.exo.exo6;

public class LePendu {

    private final String mot;

    private String masque;

    private int vies;

    public LePendu(MotAleat motAleat) {
        this.mot = motAleat.genererMot();
    }

    public void genererMasque() {
        // La String n'est pas faite pour la concaténation (gourmand en ressources)
//        masque = "";
//        for (int i = 0; i < mot.length() ; i++) {
//            masque += "*";
//        }

        // Il vaut mieux passer par un StringBuilder
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < mot.length() ; i++) {
//            stringBuilder.append("*");
//        }
//        masque = stringBuilder.toString();

        // On peut aussi simplement utiliser repeat()
        masque = "*".repeat(mot.length());
    }

    public boolean testChar(char lettre) {
        boolean trouve = false;
        for (int i = 0; i < mot.length() ; i++) {
            if (mot.charAt(i) == lettre) {
                StringBuilder stringBuilder = new StringBuilder(masque);
                stringBuilder.setCharAt(i, lettre);
                masque = stringBuilder.toString();
                trouve = true;
            }
        }
        if (!trouve) {
            vies--;
        }
        return trouve;
    }

    public boolean testVictoire() {
        return mot.equals(masque);
    }

    public String getMot() {
        return mot;
    }

    public String getMasque() {
        return masque;
    }

    public void setMasque(String masque) {
        this.masque = masque;
    }

    public int getVies() {
        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }
}
