import Contact from "./Contact.js";

// Variables du fichier
const firstNameInput = document.querySelector("form input#firstname") as HTMLInputElement;
const lastNameInput = document.querySelector("form input#lastname") as HTMLInputElement;
const mailInput = document.querySelector("form input#mail") as HTMLInputElement;
const phoneInput = document.querySelector("form input#phone") as HTMLInputElement;
const countDisplay = document.querySelector("span#count")!;
const tableBody = document.querySelector("table#contacts tbody")!;

let contactList : Contact[] = [];

// Méthode d'ajout de contact
const addContactToList = () => {
    const firstName = firstNameInput.value;
    const lastName = lastNameInput.value;
    const mail = mailInput.value;
    const phone = phoneInput.value;

    if (firstName && lastName && mail && phone) {

        const newContact = new Contact(
            firstName,
            lastName,
            mail,
            phone
        );

        contactList.push(newContact);
    }
}

// Méthode pour mettre à jour l'affichage
const updateView = () => {
    tableBody.textContent = "";

    countDisplay.textContent = contactList.length.toString();

    contactList.map(contact => {
        const newRow = document.createElement("tr");

        const idData = document.createElement("td");
        const firstNameData = document.createElement("td");
        const lastNameData = document.createElement("td");
        const mailData = document.createElement("td");
        const phoneData = document.createElement("td");
        const buttonData = document.createElement("td");
        
        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Supprimer";

        deleteButton.addEventListener("click", () => {
            const confirm = window.confirm(`Voulez-vous vraiment supprimer ${contact.firstName} ${contact.lastName} de la liste ?`);
            if (confirm) {
                contactList = contactList.filter(elt => elt !== contact);
                updateView();
            }
        });

        buttonData.appendChild(deleteButton);

        idData.textContent = contact.id.toString();
        firstNameData.textContent = contact.firstName;
        lastNameData.textContent = contact.lastName;
        mailData.textContent = contact.mail;
        phoneData.textContent = contact.phone;

        newRow.appendChild(idData);
        newRow.appendChild(lastNameData);
        newRow.appendChild(firstNameData);
        newRow.appendChild(mailData);
        newRow.appendChild(phoneData);
        newRow.appendChild(buttonData);
        
        return newRow;
    }).forEach(element => tableBody.appendChild(element));
}

// Main
document.querySelector("form")?.addEventListener("submit", (event) => {
    event.preventDefault();

    addContactToList();
    updateView();
})