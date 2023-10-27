import Contact from "./Contact.js";

// Variables du fichier
const baseUrl = "http://localhost:8080/api/v1/contacts/";

const formElt = document.querySelector("form")!
const firstNameInput = document.querySelector("form input#firstname") as HTMLInputElement;

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
            contactList.push(element);
        })
        return contactList
    } catch (error) {
        console.error(error);
        return [];
    }
}

// Fonction pour supprimer un contact
const deleteContact = (contact : Contact) => {
    const confirm = window.confirm(`Voulez-vous vraiment supprimer ${contact.firstName} ${contact.lastName} de la liste ?`);
    if (confirm) {
        console.log("Suppresion du contact :");
        console.log(contact);
    }
}

// Fonction pour supprimer un contact
const editContact = (contact : Contact) => {
    console.log("Modification du contact :");
    console.log(contact);
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

            tableCell.textContent = contact[property].toString();

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