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
const formElt = document.querySelector("form#contact-form");
const idInput = document.querySelector("form input#id");
const firstNameInput = document.querySelector("form input#firstname");
const lastNameInput = document.querySelector("form input#lastname");
const birthDateInput = document.querySelector("form input#birthdate");
const emailInput = document.querySelector("form input#mail");
const phoneInput = document.querySelector("form input#phone");
let contactList;
let mode = "add";
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
            const newContact = new Contact(element.id, element.firstName, element.lastName, new Date(element.birthDate), element.age, element.email, element.phone);
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
            yield fetch(baseUrl + contact.id, {
                method: "DELETE"
            });
        }
        catch (error) {
            console.error(error);
        }
        updateView();
    }
});
// Fonction pour remplir le formulaire avec les données d'un contact
const fillEditForm = (contact) => {
    idInput.value = contact.id.toString();
    firstNameInput.value = contact.firstName;
    lastNameInput.value = contact.lastName;
    birthDateInput.value = contact.birthDate.toISOString().substring(0, "2000-01-01".length);
    emailInput.value = contact.email;
    phoneInput.value = contact.phone;
    mode = "edit";
};
// Fonction pour envoyer un contact pour ajout ou modification
const sendContact = (contact) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        if (mode === "add") {
            yield fetch(baseUrl + "add", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(contact)
            });
        }
        else {
            yield fetch(baseUrl + contact.id, {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(contact)
            });
        }
    }
    catch (error) {
        console.error(error);
    }
    updateView();
    mode = "add";
});
// Fonction pour actualiser l'affichage de la liste
const updateView = () => __awaiter(void 0, void 0, void 0, function* () {
    const tableBody = document.querySelector("table#contacts tbody");
    let property;
    contactList = yield getContactList();
    document.querySelector("h4 span#count").textContent = contactList.length.toString();
    tableBody.textContent = "";
    contactList.forEach(contact => {
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
        editBtn.addEventListener("click", () => fillEditForm(contact));
        actionsCell.appendChild(deleteBtn);
        actionsCell.appendChild(editBtn);
        row.appendChild(actionsCell);
        tableBody.appendChild(row);
    });
});
// Main
updateView();
formElt.addEventListener("submit", (event) => {
    event.preventDefault();
    const contact = new Contact(parseInt(idInput.value), capitalize(firstNameInput.value).trim(), capitalize(lastNameInput.value).trim(), new Date(birthDateInput.value), 0, emailInput.value.trim(), phoneInput.value.trim());
    console.log(contact);
    sendContact(contact);
    idInput.value = "";
    firstNameInput.value = "";
    lastNameInput.value = "";
    birthDateInput.value = "";
    emailInput.value = "";
    phoneInput.value = "";
});
