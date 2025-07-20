package factory;

import cracker.BruteForceCracker;
import cracker.Cracker;
import target.LocalTarget;
import target.Target;

// Fabrique pour créer un cracker brute force et une cible locale
public class BruteForceLocalFactory implements CrackerFactory {
    private int maxLength;
    private String alphabet;

    // On passe la longueur max et l'alphabet à utiliser
    public BruteForceLocalFactory(int maxLength, String alphabet) {
        this.maxLength = maxLength;
        this.alphabet = alphabet;
    }

    // Crée la stratégie brute force

    @Override
    public Cracker createCracker() {
        return new BruteForceCracker(maxLength, alphabet);
    
    }

    // crée la cible locale (login/mot de passe en dur)
    @Override
    public Target createTarget() {
        
        return new LocalTarget();
    }
} 