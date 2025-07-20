# Password Cracker Factory

## Présentation

Ce projet est un outil modulaire de crackage de mots de passe, permettant de choisir dynamiquement la méthode d’attaque (brute force ou dictionnaire) pour attaquer un cible en local ou en ligne.  


---

## Fonctionnalités

- **Attaque par brute force** : génère toutes les combinaisons possibles selon un alphabet et une longueur maximale.
- **Attaque par dictionnaire** : teste chaque mot de passe d’un fichier dictionnaire.
- **Cible locale** : authentification sur un programme Java avec login/mot de passe en dur.
- **Cible en ligne** : authentification via un formulaire PHP (requêtes HTTP POST).

---

## Utilisation

### Compilation

```sh
javac -d bin src/cracker/*.java src/factory/*.java src/target/*.java src/CrackerApp.java
```

### Exécution

#### Brute force sur cible locale
```sh
java -cp bin CrackerApp --type bruteforce --target local --login admin --max L --alphabet azerty1234
```

#### Dictionnaire sur cible locale
```sh
java -cp bin CrackerApp --type dictionary --target local --login admin --dict dictionary.txt
```

#### Brute force sur cible en ligne
```sh
java -cp bin CrackerApp --type bruteforce --target online --login admin --max L --alphabet azerty1234 --url http://localhost/php_target/index.php
```

#### Dictionnaire sur cible en ligne
```sh
java -cp bin CrackerApp --type dictionary --target online --login admin --dict dictionary.txt --url http://localhost/php_target/index.php
```
(L est la longueur du mot de passe)
---

## Architecture logicielle

### Diagramme de classes UML

```

```

---

## Choix du patron de conception

Le pattern « Fabrique » (Factory Method/Abstract Factory) a été choisi pour :
- Permettre de créer dynamiquement la bonne combinaison (stratégie d’attaque + type de cible)
- Faciliter l’ajout de nouvelles stratégies ou de nouveaux types de cibles sans modifier le code existant

---

## Variantes implémentées

- Brute force sur cible locale
- Brute force sur cible en ligne
- Dictionnaire sur cible locale
- Dictionnaire sur cible en ligne

---

## Pistes d’amélioration

- Ajouter d’autres stratégies d’attaque (ex : rainbow tables)
- Supporter d’autres types de cibles (API REST, LDAP, etc.)
- Ajouter une interface graphique
- Gérer le multi-threading pour accélérer les attaques
- Ajouter des logs détaillés et des statistiques

---

## Auteurs

- Projet fait par 
- **Mouhamded BA** 
- **Mamadou DIALLO**
- **Youssouph Gnaga DIATTA**  
- **Mouhamadou Mourtada DIOP**
- **Mouhamed DRAME**  
- **Babacar Mbaye FAYE**
- **Amadou Tidiane KANE**  

 