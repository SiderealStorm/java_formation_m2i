// Recherche d'un élément dans un tableau

const users = [
    {
        firstname: "John",
        lastname: "Doe",
        age: 27
    },
    {
        firstname: "Jack",
        lastname: "Doe",
        age: 23
    },
    {
        firstname: "Jane",
        lastname: "Doe",
        age: 25
    }
];

console.log(users);

// Le predicate (méthode) renvoie un booléen,
// donc find renverra le premier élément pour lequel la condition passée est "true"
const jane = users.find(element => element.firstname == "Jane");

console.log(jane);


// Transformations d'éléments JS en éléments HTML

const listForHtml = users.map(element => {
    const newLi = document.createElement("li");
    newLi.textContent = element.firstname + " " + element.lastname;

    return newLi;
});

listForHtml.forEach(element => document.querySelector("ul").appendChild(element));


const tableForHtml = users.map(element => {
    const newTR = document.createElement("tr");
    const tdFirstname = document.createElement("td");
    const tdLastname = document.createElement("td");

    tdFirstname.textContent = element.firstname;
    tdLastname.textContent = element.lastname;

    newTR.appendChild(tdFirstname);
    newTR.appendChild(tdLastname);

    return newTR;
}).forEach(element => document.querySelector("table > tbody").appendChild(element));


// Trier une liste d'objets par un des attributs

console.log(users);

// Utilisation de sort = fonction de comparaison :
const sortedUsers = users.sort((a, b) => {
    return b.age - a.age;
});

console.log(sortedUsers);


// Faire une somme d'une liste

const grades = [12, 18, 9, 16, 11, 17, 8, 15];

// Dans la fonction reduce, la valeur de a prend le résultat de l'opération précédente
const avg = grades.reduce((a, b) => a + b) / grades.length;

console.log(avg);

const date = new Date;
