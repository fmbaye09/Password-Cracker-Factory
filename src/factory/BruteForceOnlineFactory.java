package factory;

import cracker.BruteForceCracker;
import cracker.Cracker;
import target.OnlineTarget;
import target.Target;

// Fabrique pour créer un cracker brute force et une cible en ligne
public class BruteForceOnlineFactory implements CrackerFactory {
    private int maxLength;
    private String alphabet;
    
    private String url;

    // On passe la longueur max, l'alphabet et l'URL du site cible
    public BruteForceOnlineFactory(int maxLength, String alphabet, String url) {
        this.maxLength = maxLength;
        this.alphabet = alphabet;
        this.url = url;
    }

//crée la stratégie brute force
    @Override
    public Cracker createCracker() {
        
        
        return new BruteForceCracker(maxLength, alphabet);
    }

    // Crée la cible en ligne (requête HTTP)
    @Override
    public Target createTarget() {
        return new OnlineTarget(url);
    }
} 