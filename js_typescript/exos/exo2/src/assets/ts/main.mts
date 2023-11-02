import Contact from "./Contact.js";

// Variables du fichier
const firstNameInput = document.querySelector("form input#firstname") as HTMLInputElement;
const lastNameInput = document.querySelector("form input#lastname") as HTMLInputElement;
const birthdateInput = document.querySelector("form input#birthdate") as HTMLInputElement;
const mailInput = document.querySelector("form input#mail") as HTMLInputElement;
const phoneInput = document.querySelector("form input#phone") as HTMLInputElement;

let contactList : Contact[] = [];

// Fonction pour mettre la première lettre en majuscule
const capitalize = (text : string) => text.substring(0, 1).toUpperCase() + text.substring(1).toLocaleLowerCase();

// Fonction de vérification du contact (bonus)
const checkContact = (contact : Contact) => {
    const firstnameError = document.querySelector("form span#firstname-error")!;
    const lastnameError = document.querySelector("form span#lastname-error")!;
    const formError = document.querySelector("form p#error")!;
    let isValid = true;

    firstnameError.textContent = "";
    lastnameError.textContent = "";
    formError.textContent = "";

    if (!contact.firstName) {
        firstnameError.textContent = "Champ obligatoire";
        isValid = false;
    }

    if (!contact.lastName) {
        lastnameError.textContent = "Champ obligatoire";
        isValid = false;
    }

    if (!contact.birthdate.getDate() && !contact.mail && !contact.phone) {
        formError.textContent = "Veuillez remplir au moins un des trois autres champs";
        isValid = false;
    }

    return isValid;
}

// Fonction d'ajout de contact
const addContactToList = () => {
    const firstName = capitalize(firstNameInput.value).trim();
    const lastName = capitalize(lastNameInput.value).trim();
    const birthdate = new Date(birthdateInput.value);
    const mail = mailInput.value.trim();
    const phone = phoneInput.value.trim();

    const newContact = new Contact(
        firstName,
        lastName,
        birthdate,
        mail,
        phone
    );

    if (checkContact(newContact)) {
        contactList.push(newContact);

        firstNameInput.value = "";
        lastNameInput.value = "";
        birthdateInput.value = "";
        mailInput.value = "";
        phoneInput.value = "";

    }
}

// Fonction de suppression de contact
const deleteContact = (contact : Contact) => {
    const confirm = window.confirm(`Voulez-vous vraiment supprimer ${contact.firstName} ${contact.lastName} de la liste ?`);
    if (confirm) {
        contactList = contactList.filter(elt => elt !== contact);
        updateView();
    }
}

// Fonction pour mettre à jour l'affichage
const updateView = () => {
    const tableBody = document.querySelector("table#contacts tbody")!;
    tableBody.textContent = "";

    document.querySelector("span#count")!.textContent = contactList.length.toString();

    contactList.map(contact => {
        const birthdateString = contact.birthdate.toLocaleDateString();

        const newRow = document.createElement("tr");

        const idData = document.createElement("td");
        const firstNameData = document.createElement("td");
        const lastNameData = document.createElement("td");
        const birthdateData = document.createElement("td");
        const mailData = document.createElement("td");
        const phoneData = document.createElement("td");
        const buttonData = document.createElement("td");
        
        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Supprimer";

        deleteButton.addEventListener("click", () => {
            deleteContact(contact);
        });

        buttonData.appendChild(deleteButton);

        idData.textContent = contact.id.toString();
        firstNameData.textContent = contact.firstName;
        lastNameData.textContent = contact.lastName;
        birthdateData.textContent = birthdateString === "Invalid Date" ? "" : birthdateString;
        mailData.textContent = contact.mail;
        phoneData.textContent = contact.phone;

        newRow.appendChild(idData);
        newRow.appendChild(lastNameData);
        newRow.appendChild(firstNameData);
        newRow.appendChild(birthdateData);
        newRow.appendChild(mailData);
        newRow.appendChild(phoneData);
        newRow.appendChild(buttonData);
        
        return newRow;
    }).forEach(element => tableBody.appendChild(element));
}

// Fonction unique pour trier la liste par attribut
function createCompareFn (attributeName : keyof Contact) {
    const compareFn = (a : Contact, b : Contact) => {

        const val1 = a[attributeName];
        const val2 = b[attributeName];

        if (val1 instanceof Date && val2 instanceof Date) {
            return val1.getTime() - val2.getTime();
        } else {
            return val1.toString().localeCompare(val2.toString());
        }
    }
    return compareFn;
}


// Main

// Ajout de contact
document.querySelector("form")?.addEventListener("submit", (event) => {
    event.preventDefault();

    addContactToList();
    updateView();
});

// Tris de la liste
document.querySelector("table button#sort-id")?.addEventListener("click", () => {
    contactList.sort(createCompareFn("id"));
    updateView();
});

document.querySelector("table button#sort-lastname")?.addEventListener("click", () => {
    contactList.sort(createCompareFn("lastName"));
    updateView();
});

document.querySelector("table button#sort-firstname")?.addEventListener("click", () => {
    contactList.sort(createCompareFn("firstName"));
    updateView();
});

document.querySelector("table button#sort-birthdate")?.addEventListener("click", () => {
    contactList.sort(createCompareFn("birthdate"));
    updateView();
});

document.querySelector("table button#sort-mail")?.addEventListener("click", () => {
    contactList.sort(createCompareFn("mail"));
    updateView();
});

document.querySelector("table button#sort-phone")?.addEventListener("click", () => {
    contactList.sort(createCompareFn("phone"));
    updateView();
});

