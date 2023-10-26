const myForm = document.querySelector("form");

const firstNameInput = document.querySelector("input#firstname") as HTMLInputElement;
const lastNameInput = document.querySelector("input#lastname") as HTMLInputElement;
const firstNameError = document.querySelector("span#firstname-error")!;
const lastNameError = document.querySelector("span#lastname-error")!;

myForm?.addEventListener("submit", (event) => {
    event.preventDefault();

    firstNameError.textContent = "";
    lastNameError.textContent = ""

    const firstName = firstNameInput.value;
    const lastName = lastNameInput.value;

    if (firstName && lastName) {
        console.log(`Bonjour ${firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase()} ${lastName.toUpperCase()} !`);

        document.querySelector("h2#greetings")!.textContent = `Bonjour ${firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase()} ${lastName.toUpperCase()} !`;
    } else {
        if (!firstName) {
            console.log("Veuillez saisir votre prénom");

            firstNameError.textContent = "Champ obligatoire";
        }
    
        if (!lastName) {
            console.log("Veuillez saisir votre nom");

            lastNameError.textContent = "Champ obligatoire";
        }
    };
})