package org.example.exo.exo6;

public class LePendu {

    private String mot;

    private String masque;

    private int vies;

    public LePendu(MotAleat motAleat) {
        this.mot = motAleat.genererMot();
    }

    public void genererMasque() {
        masque = "";
        for (int i = 0; i < mot.length() ; i++) {
            masque += "*";
        }
    }

    public boolean testChar(char lettre) {
        boolean trouve = false;
        for (int i = 0; i < mot.length() ; i++) {
            if (mot.charAt(i) == lettre) {
                StringBuilder string = new StringBuilder(masque);
                string.setCharAt(i, lettre);
                masque = String.valueOf(string);
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
