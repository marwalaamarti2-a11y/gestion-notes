# Gestion des notes d'étudiants (Spring Boot REST)

TP1 « Architectures logicielles avancées » : service RESTful de gestion des notes d'un module, développé avec Spring Boot.

## Technologies

- Java 17
- Spring Boot (Spring Web)
- Maven

## Architecture

Architecture en couches :

| Couche | Classe | Rôle |
|---|---|---|
| Modèle | `Etudiant` | nom, prénom, note1, note2, coef1, coef2 et `moyenne` calculée |
| Repository | `EtudiantRepository` | stockage en mémoire dans une `Map` |
| Service | `EtudiantService` | logique métier : admis, rattrapage, majorant, tri |
| Controller | `EtudiantController` | expose l'API REST |

## Lancer l'application

```bash
./mvnw spring-boot:run
```

Sous Windows : `.\mvnw.cmd spring-boot:run`. Le serveur démarre sur `http://localhost:8080`.

## API

| Opération | Méthode | URL |
|---|---|---|
| Ajouter Etudiant | POST | `/etudiants` |
| Affichage Notes | GET | `/etudiants` |
| Rechercher Etudiant | GET | `/etudiants/recherche?nom=...&prenom=...` |
| Etudiants Admis (moyenne >= 12) | GET | `/etudiants/admis` |
| Liste Rattrapage (moyenne < 12) | GET | `/etudiants/rattrapage` |
| Majorant | GET | `/etudiants/majorant` |
| Liste Triée (du meilleur au moins bon) | GET | `/etudiants/tries` |

### Exemple de corps pour POST /etudiants

```json
{
  "nom": "Alaoui",
  "prenom": "Sara",
  "note1": 15,
  "note2": 13,
  "coef1": 1,
  "coef2": 1
}
```

La moyenne est pondérée : `(note1 * coef1 + note2 * coef2) / (coef1 + coef2)`.

## Tests

Importer `gestion-notes.postman_collection.json` dans Postman, lancer les 3 requêtes POST, puis les requêtes GET.

## Remarque

Les données sont stockées en mémoire : elles sont perdues à chaque redémarrage du serveur.