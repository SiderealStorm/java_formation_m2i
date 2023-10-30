import { Component } from "@angular/core";

// Annotation permettant de déclarer un composant
@Component({
    // Nom de la balise HTML spacifique du composant
    // Doit toujours être un nom composé (par convention app-xxx)
    // pour éviter les conflits avec d'éventuelles futures balises HTML
    selector: 'app-demo',
    // On peut choisir de faire le template directement dans le fichier .ts
    // ou passer par un fichier HTML (plus propre)
    template: `
        <div>
            <p>
                Mon composant démo !
            </p>
        </div>
    `,
    // On peut aussi ajouter un fichier de style
})
// Déclaration de l'export à la création de la classe :
export class DemoComponent {
    // Code logique du composant
}