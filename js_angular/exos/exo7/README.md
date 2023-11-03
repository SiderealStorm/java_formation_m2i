# Exercice Angular H

Réaliser, via la projection de contenu dans Angular, un composant réutilisable de type Modal.
 
Pour cela, vous utiliserez <ng-content> au sein d'un composant constitué de la sorte: 

```HTML
<div *ngIf="modalVisible" class="background" (click)="closeModal()">
    <div class="content">
        <button (click)="closeModal()">Close</button>
        <ng-content></ng-content>
    </div>
</div>
```

Pour le testez, vous pouvez faire en sorte de provoquer, avec le même composant de modal, soit :
- L'affichage d'une image
- L'affichage d'un formulaire de login
- L'affichage d'un paragraphe