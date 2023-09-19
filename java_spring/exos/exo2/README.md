# Exercice Spring B

Réaliser une application Spring MVC offrant la visualisation d'une collection d'objets Java.

L'application offrira une API :
- **/api/v1/elementName/listing** : Devra retourner une listing des éléments
- **/api/v1/elementName/details/XXXX** : Devra retourner un seul élément en cas d'élément trouvé, *ou* un code de statut 404 en cas d'élément introuvable

L'application aura aussi une interface Web :
- **/elementName/listing** : Devra offrir les éléments sous la forme d'un tableau
- **/elementName/XXXXXX**: Devra offrir les propriétés de notre objet Java sous la forme d'un listing de type \<ul>

Des **pages d'erreurs** devront également être réalisée pour soutenir la version Web de notre application (codes 404, 400, ...)