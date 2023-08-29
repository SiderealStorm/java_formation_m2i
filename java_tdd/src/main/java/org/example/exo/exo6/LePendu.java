package org.example.exo.exo6;

public class LePendu {

    private String mot;

    private String masque;

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
        for (int i = 0; i < mot.length() ; i++) {
            if (mot.charAt(i) == lettre) {
                return true;
            }
        }
        return false;
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
}
