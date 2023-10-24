class NombreMystere {

    saisie;

    constructor() {
        this.nombre = Math.ceil(Math.random() * 100);
        this.nbEssais = 1;
    }

    jouer () {
        do {
            this.saisie = prompt("Saisissez un nombre entre 1 et 100 :");
            if (this.saisie < this.nombre) {
                console.log(`${this.saisie} est trop PETIT`);
                this.nbEssais++;
            } else if (this.saisie > this.nombre) {
                console.log(`${this.saisie} est trop GRAND`);
                this.nbEssais++;
            } else {
                console.log(`Bravo, vous avez trouvé en ${this.nbEssais} essais`);
            }
        } while (this.saisie != this.nombre);
    }
}

let jeu = new NombreMystere();

jeu.jouer();

