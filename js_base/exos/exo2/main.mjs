import User from "./User.js";

let users = [];

const usersCount = document.querySelector("#usersCount");
usersCount.textContent = users.length;

const userForm = document.querySelector("form");
userForm.addEventListener("submit", (event) => {
    event.preventDefault();
    let newUser = new User(
        document.querySelector("#firstname").value,
        document.querySelector("#lastname").value,
        document.querySelector("#email").value,
        document.querySelector("#password").value
    );
    users.push(newUser);
    usersCount.textContent = users.length;
    console.log(users);
});