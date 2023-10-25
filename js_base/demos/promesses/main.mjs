let maVariable;

const faitDansXSecondes = (secondes, quoiFaire) => {
    setTimeout(quoiFaire, secondes * 1000);
}

// Sans promesse
document.querySelector("button").addEventListener("click", () => {
    console.log("On a cliqué sur le bouton");
    faitDansXSecondes(4, () => {
        console.log("Ajout de 'Toto'");
        maVariable = "Toto";

        faitDansXSecondes(2, () => {
            console.log("Ajout de 'Titi'");
            maVariable += " et Titi";
            document.querySelector("span").textContent = maVariable;
        });
    });
});

// Une promesse prend en paramètre une fonction prenant en paramètre les fonction resolve et reject
const maPromesse = new Promise((res, rej) => {
    if (Math.random() >= 0.5) {
        // si la promesse s'est terminée correctement
        res("Ok");
    } else {
        // si la promesse ne s'est pas terminée correctement
        rej("Ko");
    }
});

console.log(maPromesse);

const maFonctionAsync = (secondes) => {
    console.log(`Lancement de ma fonction async avec ${secondes} secondes`);
    // Une fonction asynchrone doit toujours retourner une promesse
    return new Promise((res, rej) => {
        // Le setTimeout permet seulement de simuler de l'asynchrone
        setTimeout(() => {
            if(Math.random() >= 0.5) {
                res("OK");
            } else {
                rej("KO");
            }
        }, secondes * 1000)
    });
}

maFonctionAsync(2)
.then(() => maFonctionAsync(1))
// On peut enchaîner les .then() pour lancer plusieurs fonctions async
.then(resultat => console.log(resultat))
// Un seul .catch() est nécessaire
.catch(error => console.log(error));

// On peut aussi utiliser await
async function maFonction() {
    console.log("Lancement de ma fonction avec 'await'");
    const resultat = await maFonctionAsync(2);
    console.log(resultat);
}

maFonction();

// Fonction asynchrone constante
const maFonctionConstante = async () => {
    console.log("Lancement de ma fonction constante");
    const resultat = await maFonctionAsync(2);
    console.log(resultat);
}

maFonctionConstante();