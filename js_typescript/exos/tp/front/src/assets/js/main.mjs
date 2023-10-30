var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import Contact from "./Contact.js";
// Variables du fichier
const baseUrl = "http://localhost:8080/api/v1/contacts/";
const formElt = document.querySelector("form");
const firstNameInput = document.querySelector("form input#firstname");
const lastNameInput = document.querySelector("form input#lastname");
const birthDateInput = document.querySelector("form input#birthdate");
const emailInput = document.querySelector("form input#email");
const phoneInput = document.querySelector("form input#phone");
let contactList;
// Fonction pour mettre la première lette d'une string en majuscule
const capitalize = (text) => {
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLocaleLowerCase();
};
// Fonction pour récupérer la liste des contacts
const getContactList = () => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const response = yield fetch(baseUrl + "list");
        const data = yield response.json();
        const contactList = [];
        data.forEach(element => {
            const newContact = new Contact(element.id, capitalize(element.firstName), capitalize(element.lastName), new Date(element.birthDate), element.age, element.email, element.phone);
            contactList.push(newContact);
        });
        return contactList;
    }
    catch (error) {
        console.error(error);
        return [];
    }
});
// Fonction pour supprimer un contact
const deleteContact = (contact) => __awaiter(void 0, void 0, void 0, function* () {
    const confirm = window.confirm(`Voulez-vous vraiment supprimer ${contact.firstName} ${contact.lastName} de la liste ?`);
    if (confirm) {
        try {
            const response = yield fetch(baseUrl + "delete", {
                method: "DELETE",
                body: JSON.stringify(contact.id)
            });
            // En cours
        }
        catch (error) {
            console.error(error);
        }
    }
});
// Fonction pour supprimer un contact
const editContact = (contact) => {
    console.log("Modification du contact :");
    console.log(contact);
};
// Fonction pour ajouter un contact
const addContact = (contact) => {
    console.log("Ajout contact :");
    console.log(contact);
};
// Fonction pour actualiser l'affichage de la liste
const updateView = () => __awaiter(void 0, void 0, void 0, function* () {
    contactList = yield getContactList();
    document.querySelector("h4 span#count").textContent = contactList.length.toString();
    const tableBody = document.querySelector("table#contacts tbody");
    let property;
    contactList.forEach(contact => {
        console.log(contact);
        const row = document.createElement("tr");
        for (property in contact) {
            const tableCell = document.createElement("td");
            if (property === "birthDate") {
                tableCell.textContent = contact[property].toLocaleDateString();
            }
            else if (property === "age") {
                tableCell.textContent = contact[property].toString() + " ans";
            }
            else {
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
    });
});
// Main
updateView();
