var _a;
// Eléments HTML utilisés
const firstNameInput = document.querySelector("input#firstname");
const lastNameInput = document.querySelector("input#lastname");
const firstNameError = document.querySelector("span#firstname-error");
const lastNameError = document.querySelector("span#lastname-error");
const greetings = document.querySelector("h2#greetings");
// Action sur le bouton du formulaire
(_a = document.querySelector("form")) === null || _a === void 0 ? void 0 : _a.addEventListener("submit", (event) => {
    event.preventDefault();
    // Remise à zéro des champs
    firstNameError.textContent = "";
    lastNameError.textContent = "";
    greetings.textContent = "";
    // Récupération des champs du formulaire
    const firstName = firstNameInput.value.trim();
    const lastName = lastNameInput.value.trim();
    if (firstName != "" && lastName != "") {
        // Affichage HTML et console du nom-prénom
        console.log(`Bonjour ${firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()} ${lastName.toUpperCase()} !`);
        greetings.textContent = `Bonjour ${firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()} ${lastName.toUpperCase()} !`;
    }
    else {
        // Affichage HTML et console des messages d'erreurs
        if (!firstName) {
            console.log("Veuillez saisir votre prénom");
            firstNameError.textContent = "Champ obligatoire";
        }
        if (!lastName) {
            console.log("Veuillez saisir votre nom");
            lastNameError.textContent = "Champ obligatoire";
        }
    }
    ;
});
export {};
