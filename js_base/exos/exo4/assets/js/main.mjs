// Eléments affichés dynamiquement :
const operationDisplay = document.querySelector("span#operation");
const resultDisplay = document.querySelector("span#result");

// Ajout d'une variable pour stocker l'opération
// pour ne pas effacer le calcul lorque l'on fait "="
let operation = "";

// Evènement pour effacer l'affichage et l'opération en cours
document.querySelector("button#clear").addEventListener("click", () => {
    operation = "";
    operationDisplay.textContent = "";
    resultDisplay.textContent = "";
});

// Evènement pour afficher le résultat et effacer l'opération en cours
document.querySelector("button#equal").addEventListener("click", () => {
    resultDisplay.textContent = +eval(operationDisplay.textContent).toFixed(10);
    operation = "";
});

// Evènement pour ajouter le texte du bouton cliqué à l'opération en cours
document.querySelectorAll(`[id^="btn-"]`).forEach(button => button.addEventListener("click", () => {
    operation += button.textContent;
    operationDisplay.textContent = operation;
}));
