import Contact from "./Contact.js";
import ContactDTO from "./ContactDTO.js";

// Variables du fichier
const baseUrl = "http://localhost:8080/api/v1/contacts/";

const formElt = document.querySelector("form#contact-form")!
const firstNameInput = document.querySelector("form input#firstname") as HTMLInputElement;
const lastNameInput = document.querySelector("form input#lastname") as HTMLInputElement;
const birthDateInput = document.querySelector("form input#birthdate") as HTMLInputElement;
const emailInput = document.querySelector("form input#mail") as HTMLInputElement;
const phoneInput = document.querySelector("form input#phone") as HTMLInputElement;

let contactList: Contact[];

// Fonction pour mettre la première lette d'une string en majuscule
const capitalize = (text: string) => {
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLocaleLowerCase();
}

// Fonction pour récupérer la liste des contacts
const getContactList = async () => {
    try {
        const response = await fetch(baseUrl + "list");
        const data = await response.json() as Contact[];
        const contactList: Contact[] = [];
        data.forEach(element => {
            const newContact : Contact = new Contact(
                element.id,
                element.firstName,
                element.lastName,
                new Date(element.birthDate),
                element.age,
                element.email,
                element.phone
            )
            contactList.push(newContact);
        })
        return contactList
    } catch (error) {
        console.error(error);
        return [];
    }
}

// Fonction pour supprimer un contact
const deleteContact = async (contact : Contact) => {
    const confirm = window.confirm(`Voulez-vous vraiment supprimer ${contact.firstName} ${contact.lastName} de la liste ?`);
    if (confirm) {
        try {
            const response = await fetch(baseUrl + "delete", {
                method: "DELETE",
                body: JSON.stringify(contact.id)
            });
            // En cours
        } catch (error) {
            console.error(error);
        }
    }
}

// Fonction pour modifier un contact
const editContact = async (contact : Contact) => {
    try {
        const response = await fetch(baseUrl + "edit", {
            method: "PATCH",
            body: JSON.stringify(contact)
        });
        // En cours
    } catch (error) {
        console.error(error);
    }
    console.log(contact);
}

// Fonction pour ajouter un contact
const addContact = async () => {
    const newContact = new ContactDTO(
        capitalize(firstNameInput.value).trim(),
        capitalize(lastNameInput.value).trim(),
        birthDateInput.value,
        emailInput.value.trim(),
        phoneInput.value.trim()
    );

    try {
        const response = await fetch(baseUrl + "add", {
            method: "POST",
            body: JSON.stringify(newContact)
        });
        const data = await response.json() as Contact;
        console.log(data);
        
        if (data.id) {
            console.log("OK");
        } else {
            console.log("KO");
            
        }
    } catch (error) {
        console.error(error);
    }
    console.log(newContact);
}

// Fonction pour actualiser l'affichage de la liste
const updateView = async () => {
    contactList = await getContactList();

    document.querySelector("h4 span#count")!.textContent = contactList.length.toString();

    const tableBody = document.querySelector("table#contacts tbody")!;

    let property: keyof Contact;

    contactList.forEach(contact => {
        console.log(contact);
        
        const row = document.createElement("tr");
        for (property in contact) {
            const tableCell = document.createElement("td");

            if (property === "birthDate") {
                tableCell.textContent = contact[property].toLocaleDateString();
            } else if (property === "age") {
                tableCell.textContent = contact[property].toString() + " ans";
            } else {
                tableCell.textContent = contact[property].toString();
            }

            row.appendChild(tableCell);
        }

        const actionsCell = document.createElement("tr");

        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Supprimer";
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm");
        deleteBtn.addEventListener("click", () => deleteContact(contact));
        
        const editBtn = document.createElement("button");
        editBtn.textContent = "Modifier";
        editBtn.setAttribute("class", "btn btn-warning btn-sm");
        editBtn.addEventListener("click", () => editContact(contact));

        actionsCell.appendChild(deleteBtn);
        actionsCell.appendChild(editBtn);
        row.appendChild(actionsCell);

        tableBody.appendChild(row);
    })
}


// Main

updateView();

formElt.addEventListener("submit", (event) => {
    event.preventDefault();
    addContact();
});