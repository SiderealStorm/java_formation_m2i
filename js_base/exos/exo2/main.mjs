import User from "./User.js";

// La référence du tableau ne change jamais, on peut donc le déclarer en constante
const users = [];

const usersCount = document.querySelector("#usersCount");
usersCount.textContent = users.length;

// Pas besoin de mettre le formulaire dans une variable car on ne s'en sert qu'une fois
document.querySelector("form").addEventListener("submit", (event) => {
    event.preventDefault();
    // L'objet User est unique pour l'évènement, c'est donc une constante
    const newUser = new User(
        document.querySelector("input#firstname").value,
        document.querySelector("input#lastname").value,
        document.querySelector("input#email").value,
        document.querySelector("input#password").value
    );
    users.push(newUser);
    usersCount.textContent = users.length;
    console.log(users);
});