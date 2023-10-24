const MBR_MYSTERE = Math.ceil(Math.random() * 100);
let saisie;
let nbEssais = 1;

do {
    saisie = prompt("Veuillez saisir un nombre entre 1 et 100 :");
    if (saisie < MBR_MYSTERE) {
        console.log(`${saisie} est trop PETIT`);
        nbEssais++;
    } else if (saisie > MBR_MYSTERE) {
        console.log(`${saisie} est trop GRAND`);
        nbEssais++;
    }
} while (saisie != MBR_MYSTERE);

console.log(`Bravo, vous avez trouvé en ${nbEssais} essais`);