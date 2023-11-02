# java_formation_m2i

Exercices et démonstrations **Java** et **JavaScript/Angular**, faits pendant la formation "*Développeurs Java JEE*" de Juillet à Novembre 2023 avec M2i formation Villeneuve d'Ascq.

### Environnements :
- Java : JDK 20
- IDE Java : IntelliJ
- TomCat (pour Java EE)
- TypeScript : Node.js 20.9.0
- IDE front : VS Code + plugin *Live Server*
- BDD : PostgreSQL

## Contenu de la formation
Chaque partie correspond à un module étudié, dans l'ordre d'apprentissage :
1. [Bases Java](#Bases-Java)
1. [Programmation Orientée Objet](#Programmation-Orientée-Objet)
1. [JDBC/JPA/Hibernate](#JDBC/JPA/Hibernate)
1. [Test Driven Development](#Test-Driven-Development)
1. [HTML/CSS](#HTML/CSS)
1. [Java EE](#Java-EE)
1. [Spring](#Spring)
1. [JavaScript](#JavaScript)
1. [TypeScript](#TypeScript)
1. [Angular](#Angular)

----


## [Bases Java](/java_base/)
### Bases de programmation en Java.

Tout le dossier constitue un seul projet IntelliJ.
Chaque fichier .java possède une fonction `main()` pour pouvoir être exécuté individuellement.

Pour les exercices, l'énoncé est indiqué en commentaire au-dessus de la déclaration de classe.

### Contenu :
- [Démos](/java_base/src/demos/)
- [Exercices](/java_base/src/exos/)
    - [Variables](/java_base/src/exos/variables/)
    - [Instructions](/java_base/src/exos/instructions/)
    - [Tableaux](/java_base/src/exos/tableaux/)

## [Programmation Orientée Objet](/java_poo/src/main/java/org/example/)
### Utilisation de la POO et des collections en Java.

Tout le dossier constitue un seul projet IntelliJ.
Chaque package est individuel et contient (minimum) une classe possédant une fonction `main()` pour exécuter le code associé.

Pour les exercices, l'énoncé est indiqué en commentaire au-dessus de la déclaration de la classe Main.

### Contenu :
- [Démos](/java_poo/src/main/java/org/example/demos/)
- [Exercices](/java_poo/src/main/java/org/example/exos/)

## [JDBC/JPA/Hibernate](/java_jdbc/src/main/java/org/example/)
### Utilisation de JDBC, JPA et Hibernate pour la gestion des données.

Tout le dossier constitue un seul projet IntelliJ.
Chaque package est individuel et contient une classe possédant une fonction `main()` pour exécuter le code associé.

Pour les exercices, l'énoncé est indiqué dans un fichier *readme* présent dans le package. Certains exercices sont en plusieurs parties, chaque partie faisant l'objet d'un tag git.

### Contenu :
- [Démos](/java_jdbc/src/main/java/org/example/demos/)
- [Exercices](/java_jdbc/src/main/java/org/example/exos/)
    - [JDBC](/java_jdbc/src/main/java/org/example/exos/jdbc)
    - [JPA](/java_jdbc/src/main/java/org/example/exos/jpa) : plusieurs versions accessibles via les tags git **jpa_exo_v...**
    - [Hibernate](java_jdbc/src/main/java/org/example/exos/hibernate/) : plusieurs versions accessibles via les tags git **hib_exo_v...**

## [Test Driven Development](/java_tdd/src/test/java/org/example/)
### Initiation au TDD en Java.

Tout le dossier est un projet IntelliJ.
Chaque package est individuel, et se compose d'une partie code et d'une partie test avec des noms correspondants.

Pour les exercices, l'énoncé est indiqué dans un fichier *readme* présent dans le package côté tests.

### Contenu :
- Démos : [Main](/java_tdd/src/main/java/org/example/demo/) | [Test](/java_tdd/src/test/java/org/example/demo/)
- Exercices : [Main](/java_tdd/src/main/java/org/example/exo/) | [Test](/java_tdd/src/test/java/org/example/exo/)

## [HTML/CSS](/html_css/)
### Bases de HTML, CSS et Bootstrap.

Chaque démo ou exercice se trouve dans un dossier séparé.
L'énoncé des exercices est indiqué dans un fichier *readme*.

### Contenu :
- [Démos](/html_css/demo/)
- [Exercices](/html_css/exos/)

## [Java EE](/java_ee/)
### Programmation Java pour le Web, avec vues en JSP.

Chaque exercice ou démo est un projet Intellij individuel. Les projets peuvent être exécutés via un serveur type TomCat.

Chaque exercice contient un fichier *readme* avec son énoncé.

### Contenu :
- [Démo](/java_ee/demo/src/main/java/com/example/demo/)
- [Exercices](/java_ee/exos/)

## [Spring](/java_spring/)
### Utilisation de Spring pour le Web : thymeleaf, validation, security...

Chaque exercice ou démo est un projet Intellij individuel.
Une fois exécuté, le projet est alors accessible via le navigateur à `localhost:8080`.

Chaque exercice contient un fichier *readme* avec son énoncé.

### Contenu :
- [Démos](/java_spring/demos/)
- [Exercices](/java_spring/exos/)

## [JavaScript](/js_bases/)
### Bases de programmation en JavaScript

Chaque dossier correspond à un "projet" (exercice ou démo) pouvant être exécuté en ouvrant le fichier `index.html` dans un navigateur.
Chaque exercice contient un fichier *readme* avec son énoncé.

### Contenu :
- [Démos](/js_javascript/demos/)
- [Exercices](/js_javascript/exos/)

## [TypeScript](/js_typescript/)
### Intégration du typage en vue de l'utilisation d'Angular

Chaque dossier correspond à un "projet" (exercice ou démo).
Chaque exercice contient un fichier *readme* avec son énoncé.

**L'exécution des projets nécessite à minima l'installation de Node.js.**
Pour lancer la compilation, ouvrir un terminal à la racine du projet et exécuter la commande :
```console
$ npx -p typescript tsc --watch
```
Le projet est alors accessible en ouvrant le fichier `index.html` dans le navigateur.

### Contenu :
- [Démos](/js_typescript/demos/)
- [Exercices](/js_typescript/exos/)

## [Angular](/js_angular/)
### Utilisation d'Angular pour créer des applications front-end

Chaque dossier correspond à un "projet" (exercice ou démo) pouvant être exécuté en ouvrant le fichier `index.html` dans un navigateur.
Chaque exercice contient un fichier *readme* avec son énoncé.

**L'exécution des projets nécessite l'installation d'Angular**
Via node :
```console
$ npm install -g @angular/cli
```
Pour exécuter le projet, ouvrir un terminal à sa racine et exécuter la commande :
```console
$ ng serve
```
Le projet est alors accessible via le navigateur à `localhost:4200`.

### Contenu :
- [Démos](/js_angular/demos/)
- [Exercices](/js_angular/exos/)