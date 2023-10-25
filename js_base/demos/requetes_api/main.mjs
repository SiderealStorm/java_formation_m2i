import Post from "./Post.js"

const url = "https://jsonplaceholder.typicode.com/posts";

// Récupérer des données d'une API avec fetch(), qui renvoie une promesse car asynchrone

// l'API n'envoie pas directement les données, mais une réponse
const result = await fetch(url);

console.log(result);

// Récupération des données
console.log("Premières données récupérées avec then");

fetch(url)
.then(result => result.json())
// La fonction .json() renvoie une promesse, on peut donc enchaîner un autre .then()
.then(json => console.log(json));

// Version plus moderne/lisible
console.log("Données suivantes récupérées avec await");

// Il est préférable de passer par des try/catch en cas d'erreurs
// Dans ce cas, il faut déclarer les variables avant
let response;
let data;

try {
    response = await fetch(url);
} catch (error) {
    console.error(error);
}
try {
    data = await response.json();
} catch (error) {
    console.error(error);
}

console.log(data);


// Utiliser .fetch() pour faire un POST

const myPost = new Post(2, 47, "Mon post", "Ceci est un post dans l'API");

try {
    response = await fetch(url, {
        // On passe ici les paramètres de la requête
        method: "POST",
        body: JSON.stringify(myPost)    // Ancienne version
        // body: myPost
    });

    console.log(response);
} catch (error) {
    console.error(error);
}

// Essai API Java :

try {
    response = await fetch("http://localhost:8080/api/media/fc9e0c45-3539-4e3e-83ed-7b5b3d18d84f");
} catch (error) {
    console.error(error);
}