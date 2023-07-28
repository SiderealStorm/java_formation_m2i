package org.example.demos.exceptions;

public class Compte {
    private int code;
    private double solde;

    public void verser(double mt) {
        solde = solde + mt;
    }

    public void retirer(double mt) throws SoldeInsuffisantException {    // On indique que cette méthode remonte ("throws") une exception
        if (mt > solde) {
            // On génère l'exception avec "throw" :
            throw new SoldeInsuffisantException("Solde insuffisant");
        }
        solde = solde - mt;
    }

    public double getSolde() {
        return solde;
    }
}
