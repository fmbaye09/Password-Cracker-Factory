package cracker;

import target.Target;

/*Implémentation de la stratégie d'attaque par force brute.
  Génère toutes les combinaisons possibles de caractères jusqu'à une longueur maximale.*/
public class BruteForceCracker implements Cracker {
    private int maxLength;
    private String alphabet;

    //constructeur du brute force cracker.

    public BruteForceCracker(int maxLength, String alphabet) {
        this.maxLength = maxLength;
        this.alphabet = alphabet;
    }

    //lance l'attaque brute force sur la cible.
    @Override
    public void crack(Target target, String login) {
        System.out.println("[BruteForce] Début de l'attaque brute force...");
        bruteForceRecursive(target, login, "", 0);
    }

    //méthode récursive pour générer toutes les combinaisons possibles.
    private boolean bruteForceRecursive(Target target, String login, String current, int depth) {
        if (depth > maxLength) return false;
        if (current.length() > 0 && target.authenticate(login, current)) {
            System.out.println("Mot de passe trouvé : " + current);
            return true;
        }
        if (depth == maxLength) return false;
        for (int i = 0; i < alphabet.length(); i++) {
            if (bruteForceRecursive(target, login, current + alphabet.charAt(i), depth + 1)) {
                return true;
            }
        }
        return false;
    }
} 