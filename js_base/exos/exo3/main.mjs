import Todo from "./Todo.js";

const todoList = [];

document.querySelector("form#add-todo").addEventListener("submit", (event) => {
    event.preventDefault();

    const todo = new Todo(
        document.querySelector("input#description").value,
        document.querySelector("input#deadline").value
    );

    todoList.push(todo);
    todoList.sort((a, b) => {
        return new Date(a.deadline) - new Date(b.deadline);
    })

    const tableBody = document.querySelector("table#todo-list > tbody");
    tableBody.innerHTML = "";

    todoList.map((element, index) => {
        const row = document.createElement("tr");

        const c1 = document.createElement("td");
        const c2 = document.createElement("td");
        const c3 = document.createElement("td");

        const button = document.createElement("button");
        
        c1.textContent = element.description;
        c2.textContent = element.deadline;
        button.textContent = "Supprimer";
        c3.appendChild(button);

        row.appendChild(c1);
        row.appendChild(c2);
        row.appendChild(c3);
        
        button.addEventListener("click", () => {
            const confirm = window.confirm(`Voulez-vous vraiment supprimer "${element.description}" de la liste ?`);
            if (confirm) {
                row.remove()
                // tableBody.deleteRow(index);
                todoList.splice(index, 1);
            }
        });

        return row;
    }).forEach(element => tableBody.appendChild(element));

});
