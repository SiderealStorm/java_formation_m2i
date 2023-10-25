// Eléments affichés dynamiquement :
const operationDisplay = document.querySelector("span#operation");
const resultDisplay = document.querySelector("span#result");

// Ajout d'une variable pour stocker l'opération
// pour ne pas effacer le calcul lorque l'on fait "="
let operation = "";

// Bouton "virgule" à bloquer dynamiquement
const dotButton = document.querySelector("button#dot");

// Evènement pour effacer l'affichage et l'opération en cours
document.querySelector("button#clear").addEventListener("click", () => {
    operation = "";
    operationDisplay.textContent = "";
    resultDisplay.textContent = "";
    dotButton.disabled = false;
});

// Evènement pour afficher le résultat et effacer l'opération en cours
document.querySelector("button#equal").addEventListener("click", () => {
    try {
        operation = "";
        resultDisplay.textContent = +eval(operationDisplay.textContent).toFixed(10);
        dotButton.disabled = false;
    } catch (error) {
        console.log(error);
        resultDisplay.textContent = "ERR"
    }
});

// Evènements pour ajouter le texte du bouton cliqué à l'opération en cours :

// Chiffres
document.querySelectorAll(`[class="btn-digit"]`).forEach(
    button => button.addEventListener("click", () => {
        operation += button.textContent;
        operationDisplay.textContent = operation;
    })
);

// Bouton "virgule"
dotButton.addEventListener("click", () => {
    operation += dotButton.textContent;
    operationDisplay.textContent = operation;
    dotButton.disabled = true;
});

// Opérateurs et parenthèses
document.querySelectorAll(`[class^="operation-"]`).forEach(
    button => button.addEventListener("click", () => {
        operation += button.textContent;
        operationDisplay.textContent = operation;
        dotButton.disabled = false;
    })
);