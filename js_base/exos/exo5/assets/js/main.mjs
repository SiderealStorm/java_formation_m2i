import Pokemon from "./Pokemon.js";

//// Variables du fichier

const baseUrl = "https://pokeapi.co/api/v2/pokemon/";
const maxPokeId = 1017;
const maxImgId = 1011;
let pokemon;

//// Méthodes

// Méthode pour mettre la première lettre d'une string en majuscule
const capitalize = (string) => string.substring(0,1).toUpperCase() + string.substring(1);

// Méthode pour rechercher/récupérer le pokémon depuis l'API
const getPokemon = async (search) => {
    try {
        const response = await fetch(baseUrl + search);
        const data = await response.json();
        pokemon = new Pokemon(
            data.id,
            capitalize(data.name),
            data.height,
            data.weight,
            data.types.map(element => capitalize(element.type.name)),
            data.abilities.map(element => capitalize(element.ability.name)),
            data.id < maxImgId
            ? `https://assets.pokemon.com/assets/cms2/img/pokedex/full/${data.id.toString().padStart(3, "0")}.png`
            : "assets/images/Poke_Ball.webp"
        );
        return pokemon;
    } catch (error) {
        console.error(error);
    }
}

// Méthode pour afficher les données du pokémon
const displayPokemon = (pokemon) => {
    const typesDisplay = document.querySelector("#poke-types");
    const abilitiesDisplay = document.querySelector("#poke-abilities");
    const imgDisplay = document.querySelector("#poke-image");

    document.querySelector("title").textContent = `Pokémon - ${pokemon.name}`;
    document.querySelector("#poke-name").textContent = `# ${pokemon.id} - ${pokemon.name}`;
    document.querySelector("#poke-height").textContent = `Height : ${pokemon.height} units`;
    document.querySelector("#poke-weight").textContent = `Weight : ${pokemon.weight} units`;
    
    typesDisplay.textContent = "";
    abilitiesDisplay.textContent = "";
    
    pokemon.types.forEach(type => {
        const newLi = document.createElement("li");
        newLi.textContent = type;
        typesDisplay.appendChild(newLi);
    });

    pokemon.abilities.forEach(type => {
        const newLi = document.createElement("li");
        newLi.textContent = type;
        abilitiesDisplay.appendChild(newLi);
    });
    
    imgDisplay.setAttribute("src", pokemon.imageUrl);
    imgDisplay.setAttribute("alt", pokemon.name);
}

// Méthode pour rechercher puis afficher un pokémon
const updatePage = async (idOrName) => {
    try {
        const pokemon = await getPokemon(idOrName);
        displayPokemon(pokemon);
    } catch (error) {
        console.error(error);
    }
}

// Méthode pour générer un ID aléatoire
const randomId = () => Math.floor(Math.random() * maxPokeId);

//// Main

// Récupération des infos d'un pokémon aléatoire
updatePage(randomId());

// Recherche de pokémon
document.querySelector("#search").addEventListener("submit", (event) => {
    event.preventDefault();

    let idOrName = document.querySelector("form#search input").value;

    if (idOrName == "") {
        idOrName = randomId();
    } else if (idOrName < 1) {
        idOrName = 1;
    } else if (idOrName > maxPokeId) {
        idOrName = maxPokeId;
    }

    updatePage(idOrName);
});

// Pokémon précédent
document.querySelector("#prev").addEventListener("click", () => {
    if (pokemon.id > 1) {
        updatePage(--pokemon.id);
    }
});

// Pokémon suivant
document.querySelector("#next").addEventListener("click", () => {
    if (pokemon.id < maxPokeId) {
        updatePage(--pokemon.id);
    }
});