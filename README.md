# Depot Maven Module

Un projet Maven multi-modules d'exemple avec une architecture organisée en couches.

## Structure du projet

```
depot-maven-module/
├── pom.xml              # POM parent
├── core/                # Module utilitaires et classes de base
├── api/                 # Module interfaces et contrats
├── service/             # Module implémentations métier
└── app/                 # Module applicatif avec main
```

## Modules

### 1. **core** - Module noyau
Contient les classes utilitaires et les modèles de base utilisés par les autres modules.
- Classe `Util` avec fonctions utilitaires
- Tests unitaires

### 2. **api** - Module API
Définit les contrats d'interface et les modèles métier.
- Interface `UserService`
- Classe `User` (modèle)

### 3. **service** - Module Services
Implémentation des services métier.
- `UserServiceImpl` : implémentation du service utilisateur
- Accès aux modules `core` et `api`

### 4. **app** - Module Application
Point d'entrée principal de l'application.
- Classe `Application` avec méthode `main`
- Configuration de logging

## Dépendances

- **Java 11+**
- **SLF4J** : logging API
- **Logback** : implémentation logging
- **JUnit 4** : tests unitaires

## Compilation et Exécution

### Compiler le projet entier
```bash
mvn clean compile
```

### Compiler un module spécifique
```bash
mvn clean compile -pl core
```

### Exécuter les tests
```bash
mvn clean test
```

### Packager les JARs
```bash
mvn clean package
```

### Exécuter l'application
```bash
java -jar app/target/app-1.0.0.jar
```

## Gestion des dépendances

Le POM parent gère les versions et dépendances :
- `dependencyManagement` : centralise les versions des dépendances
- `pluginManagement` : centralise les versions des plugins

Chaque module enfant hérite de ces configurations.

## Architecture

```
app (executable)
 ├─ service (implémentations)
 │   ├─ api (interfaces)
 │   │   └─ core (utilitaires)
 │   └─ core (utilitaires)
```

Chaque module :
- A son propre `pom.xml`
- Déclare ses propres dépendances
- Peut avoir ses propres tests
- Peut être utilisé indépendamment (une fois compilé)
